package src.Persistance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import src.Metier.Chambre;
import src.Metier.Client;
import src.Metier.EquipementHotel;
import src.Metier.ReservationHotel;
import src.Metier.Tva;
import src.Metier.Utilisateur;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class AccesData {

	private static Session s = HibernateSession.getSession();
	private static Transaction t;
	
	public static Utilisateur getLoginUtilisateur(String login, String mdp){
		Utilisateur u = null;
		List<Utilisateur> listeU = s.createQuery("FROM Utilisateur U WHERE U.login = '" + login + "' AND U.password = '" + mdp + "'").list();
		if(listeU.size() == 1){
			u = listeU.get(0);
		}
		return u;
	}
	
	public static EquipementHotel getEquipementHotel(int id){
		EquipementHotel e = null;
		List<EquipementHotel> listeE = s.createQuery("FROM EquipementHotel E WHERE E.id = " + id).list();
		//List<Utilisateur> listeU = s.createQuery("FROM Utilisateur U WHERE U.login = '" + login + "' AND U.password = '" + mdp + "'").list();
		if(listeE.size() == 1){
			e = listeE.get(0);
		}
		return e;
	}
	/**
	 * Fonction de r�cup�ration des clients
	 * @return
	 */
	public static List<Client> getClients(){
		List<Client> listeC = s.createQuery("FROM Client C").list();		
		return listeC;
	}
	
//	public static List<Client> getClientsByName(String nom){
//		List<Client> listeC = s.createQuery("FROM Client C WHERE C.nom LIKE '%" + nom + "%'").list();		
//		return listeC;
//	}
//	
//	public static List<Client> getClientsByPrenom(String prenom){
//		System.out.println(prenom);
//		List<Client> listeC = s.createQuery("FROM Client C WHERE C.prenom LIKE '%" + prenom + "%'").list();		
//		return listeC;
//	}
//	
//	public static List<Client> getClientsByAdresse(String adresse){
//		List<Client> listeC = s.createQuery("FROM Client C WHERE C.adresseRue LIKE '%" + adresse + "%' OR C.adresseVille LIKE '%" + adresse + "%' OR C.codePostal LIKE '%" + adresse + "%'").list();		
//		return listeC;
//	}
//	
//	public static List<Client> getClientsByPhone(String phone){
//		List<Client> listeC = s.createQuery("FROM Client C WHERE C.telephone LIKE '%" + phone + "%'").list();		
//		return listeC;
//	}
	
	 public static List<Client> getClientFiltre(String f_nom, String f_prenom, String f_adresse, String f_phone) {
		  String where = "";

		  String[][] filtreClientConfig = {
		    {"C.nom", f_nom},
		    {"C.prenom", f_prenom},
		    {"C.phone", f_phone}
		  };

		  where += whereFilter(filtreClientConfig);

		  String[] filtreClientConfigAdress = {"C.adresseRue", "C.adresseVille", "C.codePostal"};
		  if(where.equals("")) {
		   where += whereFilterCompose(f_adresse, filtreClientConfigAdress, false);
		  } else {
		   where += whereFilterCompose(f_adresse, filtreClientConfigAdress, true);
		  }

		  List<Client> listeC = s.createQuery("FROM Client C " + (where.equals("") ? "" : "WHERE "+where)).list();
		  return listeC;
		}
	 
	/**
	  * G�n�re un filtre sous la forme : colonne LIKE '%filterValue%'
	  * @param filterConfig String[][] Tableau de config de la forme :
	  * @return String Composante de la requ�te permettant le filtre, s�par� par des espaces pour �viter tout probl�me
	  * Renvoie une cha�ne vide si la filterValue est nulle.
	  */
	 private static String whereFilter(String[][] filterConfig) {
	  Boolean firstFilter = true;
	  String filter = "";


	  for(String[] filterConfigElem : filterConfig) {
	   if(!filterConfigElem[1].equals("")) {
	    // Ajoute AND sauf au premier
	    if(firstFilter) { firstFilter = false; }
	    else    { filter += " AND "; }

	    filter += " " + filterConfigElem[0]+" LIKE '%" + filterConfigElem[1] + "%' ";
	   }
	  }

	  return filter;	
	 }

	 /**
	  *
	  * @param filter String Element filtrant
	  * @param cols String[] Liste des colonnes cibl�es
	  * @param add {@link Boolean} ajouter ADD devant
	  * @return String
	  */
	 private static String whereFilterCompose(String filter, String[] cols, Boolean add) {
	  String filterSQL = "";

	  if(!filter.equals("")) {
	   if(add) { filterSQL += " AND "; }

	   filterSQL += " ( ";

	   Boolean firstElem = true;
	   for(String col : cols) {
	    // Ajoute OR sauf au premier
	    if(firstElem)  { firstElem = false; }
	    else    { filterSQL += " OR "; }

	    // Ajoute le filtre
	    filterSQL += col + " LIKE '%" + filter + "%'";
	   }

	   filterSQL += " ) ";
	  }

	  return  filterSQL;
	 }
	 
	 
	 
	 
	public static String  getChambreClientActuelle(int idClient){
		int idChambre = -1;
		String idChambreString = "";
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		List<ReservationHotel> listeR = s.createQuery("FROM ReservationHotel R WHERE R.idClient = " + idClient + " AND date_debut <= '" + timeStamp + "' AND date_fin >= '" + timeStamp + "'").list();
		if(listeR.size() > 0){
			idChambre = listeR.get(0).getChambreByIdChambre().getNumeroChambre();
		}
		
		if(idChambre != -1){
			idChambreString = String.valueOf(idChambre);
		}
		return idChambreString;
	}
	
	public static boolean ajouterModifierClient(Client unClient){
		boolean ok = false;
		try{
			t=s.beginTransaction();
			s.saveOrUpdate(unClient);
			t.commit();
			ok = true;
		} catch(HibernateException e){
			ok = false;
		}
		return ok;
	}
	
	public static Client getClientById(int id){
		return (Client) s.get(Client.class, id);
	}
	
	public static List<ReservationHotel> getReservationsClients(int idClient){
		List<ReservationHotel> listeR = s.createQuery("FROM ReservationHotel R WHERE R.idClient = " + idClient).list();		
		return listeR;
	}
	
	
	public static List<ReservationHotel> getReservationsHotel(){
		List<ReservationHotel> listeR = s.createQuery("FROM ReservationHotel R").list();		
		return listeR;
	}
	
	public static Chambre getChambreById(int idChambre){
		return (Chambre) s.get(Chambre.class, idChambre);
	}
	
	
	/**
	 * 
	 */
	
	public static List<ReservationHotel> getReservationHotelByName(String nom){
		System.out.println(nom);
		List<ReservationHotel> listeC = s.createQuery("Select R FROM ReservationHotel R, Client C WHERE R.idClient = C.id AND C.nom LIKE '%" + nom + "%'").list();		
		return listeC;
	}
	
	public static List<ReservationHotel> getReservationHotelByRoomNumber(int numeroChambre){
		List<ReservationHotel> listeC = s.createQuery("FROM ReservationHotel R WHERE R.chambreByIdChambre.id = " + numeroChambre).list();		
		return listeC;
	}
	
	public static List<ReservationHotel> getReservationHotelByBeginDate(Date dateDebut){
		List<ReservationHotel> listeC = s.createQuery("FROM ReservationHotel R WHERE R.dateDebut = '" + dateDebut + "'").list();		
		return listeC;
	}
	
	public static List<ReservationHotel> getReservationHotelByEndDate(Date dateFin){
		System.out.println("date de depart : " + dateFin);
		List<ReservationHotel> listeC = s.createQuery("FROM ReservationHotel R WHERE R.dateFin = '" + dateFin + "'").list();		
		return listeC;
	}
	
	public static ReservationHotel getReservationHotelById(int id){
		return (ReservationHotel) s.get(ReservationHotel.class, id);
	}
	
	public static List<Chambre> getFreeRoom(Date dateDebut, Date dateFin){
		//List<Chambre> listeR = s.createQuery("SELECT C FROM Chambre C, ReservationHotel R WHERE C.id = R.chambreByIdChambre.id AND C.id NOT IN (SELECT R.chambreByIdChambre.id FROM reservationHotel R WHERE R.dateDebut > '" + dateDebut + "' AND R.dateFin < '" + dateFin + "'").list();
		List<Chambre> listeR = s.createQuery("SELECT DISTINCT C FROM Chambre C, ReservationHotel R WHERE C.id = R.chambreByIdChambre.id AND C.id NOT IN (SELECT R.chambreByIdChambre.id FROM ReservationHotel R WHERE R.dateDebut > '" + dateDebut + "' AND R.dateFin < '" + dateFin + "')").list();
		return listeR;
	}
	
	public static Chambre getRoomByNum(int numChambre){
		List<Chambre> listC = s.createQuery("FROM Chambre C WHERE C.numeroChambre = " + numChambre).list();
		return listC.get(0);
	}
	
	public static Tva getTVAById(int idTva){
		return (Tva) s.get(Tva.class, idTva);
	}

	public static boolean ajouterModifierReservationHotel(ReservationHotel reservation){
		boolean ok = false;
		try{
			t=s.beginTransaction();
			s.saveOrUpdate(reservation);
			t.commit();
			ok = true;
		} catch(HibernateException e){
			ok = false;
		}
		return ok;
	}
	
//	public static List<ReservationHotel> getReservationHotelPrenom(String prenom){
//		System.out.println(prenom);
//		List<ReservationHotel> listeC = s.createQuery("FROM Client C WHERE C.prenom LIKE '%" + prenom + "%'").list();		
//		return listeC;
//	}
//	
//	public static List<ReservationHotel> getReservationHotelDateDebut(Date date){
//		List<ReservationHotel> listeC = s.createQuery("FROM Client C WHERE C.adresseRue LIKE '%" + date + "%' OR C.adresseVille LIKE '%" + adresse + "%' OR C.codePostal LIKE '%" + adresse + "%'").list();		
//		return listeC;
//	}
//	
//	public static List<ReservationHotel> getReservationHotelDateFin(Date date){
//		List<ReservationHotel> listeC = s.createQuery("FROM Client C WHERE C.telephone LIKE '%" + date + "%'").list();		
//		return listeC;
//	}
	
//	public static Utilisateur getLoginUtilisateur(String login, String mdp){
//		Utilisateur u = null;
//		List<Utilisateur> listeU = s.createQuery("FROM Utilisateur U WHERE U.login = '" + login + "' AND U.mdp = '" + mdp + "'").list();
//		if(listeU.size() == 1){
//			u = listeU.get(0);
//		}
//		return u;
//	}
//	
//	
//	public static Boolean ajouterVisiteur(Utilisateur u){
//		boolean ok=false;
//		try {
//			t=s.beginTransaction();
//			s.save(u);
//			t.commit();
//			ok=true;
//		} catch (HibernateException e) {
//			ok = false;
//		}
//		return ok;		
//	}
//	
//	public static Boolean supprimerVisiteur(Utilisateur u){
//		boolean ok=false;
//		try {
//			t=s.beginTransaction();
//			s.delete(u);
//			t.commit();
//			ok=true;
//		} catch (HibernateException e) {
//			ok = false;
//		}
//		return ok;		
//	}
//	
//	public static boolean modifierVisiteur(Utilisateur unVisiteur){
//		boolean ok = false;
//		try{
//			t=s.beginTransaction();
//			s.saveOrUpdate(unVisiteur);
//			t.commit();
//			ok = true;
//		} catch(HibernateException e){
//			ok = false;
//		}
//		return ok;
//	}
//	
//	public static boolean modifierRegion(Region uneRegion){
//		boolean ok = false;
//		try{
//			t=s.beginTransaction();
//			s.saveOrUpdate(uneRegion);
//			t.commit();
//			ok = true;
//		} catch(HibernateException e){
//			ok = false;
//		}
//		return ok;
//	}
//	
//	public static Boolean supprimerFicheFrais(FicheFrais ff){		
//		boolean ok = false;
//		try{
//			t=s.beginTransaction();
//			s.delete(ff);
//			t.commit();
//			ok = true;
//		} catch(HibernateException e){
//			ok = false;
//		}
//		return ok;
//			
//	}
//	
//	public static Boolean supprimerLigneHF(LigneFraisHorsForfait fhf){
//		boolean ok = false;
//		try{
//			t=s.beginTransaction();
//			s.delete(fhf);
//			t.commit();
//			ok = true;
//		} catch(HibernateException e){
//			ok = false;
//		}
//		return ok;
//	}
//	
//	public static Boolean supprimerLigneFF(LigneFraisForfait lf){
//		boolean ok = false;
//		try{
//			t=s.beginTransaction();
//			s.delete(lf);
//			t.commit();
//			ok = true;
//		} catch(HibernateException e){
//			ok = false;
//		}
//		return ok;		
//	}
//	
//	public static Region getRegionParLibelle(String libelle){
//		Region r = null;
//		List<Region> listeR = s.createQuery("FROM Region R WHERE R.libelleRegion = '" + libelle + "'").list();
//		if(listeR.size() == 1){
//			r = listeR.get(0);
//		}
//		return r;
//	}
//	
//	public static List<Region> getLesRegions(){
//		return s.createQuery("FROM Region R ORDER BY R.libelleRegion").list();
//	}
//	
//	public static Utilisateur getVisiteur(String idVisiteur){
//		return (Utilisateur) s.get(Utilisateur.class, idVisiteur);
//	}
//	
//	public static List<Region> getRegions(){
//		return s.createQuery("FROM Region").list();
//	}
//	
//	public static List<Utilisateur> getVisiteursRegion(Region uneRegion){
//		return s.createQuery("FROM Utilisateur U WHERE U.uneRegion.idRegion = " + uneRegion.getIdRegion() + " AND U.unTypeUtilisateur.idType = 'V'").list();
//	}
//	
//	public static List<Utilisateur> getVisiteurs(){
//		return s.createQuery("FROM Utilisateur U WHERE U.unTypeUtilisateur.idType = 'V'").list();
//	}
//	
//	public static List<Utilisateur> getVisiteursParNom(String nom){
//		return s.createQuery("FROM Utilisateur U WHERE U.nom = '" + nom + "'").list();
//	}
//	
//	public static List<Utilisateur> getVisiteursParPrenom(String prenom){
//		return s.createQuery("FROM Utilisateur U WHERE U.prenom = '" + prenom + "'").list();
//	}
//	
//	public static List<Utilisateur> getVisiteursParNomPrenom(String prenom, String nom){
//		return s.createQuery("FROM Utilisateur U WHERE U.prenom = '" + prenom + "' AND U.nom = '" + nom + "'").list();
//	}
//	
//	public static List<String> getListMoisRegion(int idRegion){
//		return s.createQuery("SELECT DISTINCT FF.mois FROM Utilisateur U JOIN U.lesFichesFrais FF WHERE U.uneRegion.idRegion = " + idRegion + " ORDER BY FF.mois DESC").list();
//	}
//	
//	public static List<Object[]> getListRegionMois(String mois){
//		return s.createQuery("SELECT DISTINCT R.idRegion, R.libelleRegion FROM Region R, Utilisateur U, FicheFrais FF WHERE R.idRegion = U.uneRegion.idRegion AND U.idUtilisateur = FF.unVisiteur.idUtilisateur AND FF.mois = '" + mois + "'").list();
//	}
//	
//	public static List<Utilisateur> getVisiteurRegion(int idRegion){
//		
//		return s.createQuery("FROM Utilisateur U WHERE U.unTypeUtilisateur.idType = 'V' AND U.uneRegion.idRegion = " + idRegion).list();
//		
//	}
//	
//	public static List<Object[]> getVisiteurRegionMois(int idRegion, String mois){
//		
//		return s.createQuery("Select U.idUtilisateur, U.nom, U.prenom FROM Utilisateur U JOIN U.lesFichesFrais FF WHERE FF.mois = '" + mois + "' AND U.uneRegion.idRegion = " + idRegion + " ORDER BY U.nom, U.prenom").list();
//		
//	}
//	
//	public static String getNbFraisHorsForfait(String idUser, String leMois){
//		
//		return s.createQuery("SELECT count(*) FROM FicheFrais FF JOIN FF.lesLignesFraisHorsForfait HF WHERE FF.mois = '" + leMois + "' AND FF.idVisiteur = '" + idUser + "'").uniqueResult().toString();
//	}
//	
//	public static List<String> getListMois(){
//		return s.createQuery("SELECT DISTINCT FF.mois FROM FicheFrais FF ORDER BY FF.mois DESC").list();
//	}
}
