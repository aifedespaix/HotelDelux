package src.Persistance;

import org.hibernate.Session;
import org.hibernate.Transaction;
import src.Metier.Utilisateur;

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
