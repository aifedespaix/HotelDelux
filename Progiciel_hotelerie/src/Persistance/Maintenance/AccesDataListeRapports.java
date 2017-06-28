package src.Persistance.Maintenance;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import src.Metier.Criticite;
import src.Metier.DemandeIntervention;
import src.Metier.Etat;
import src.Metier.Rapport;
import src.Persistance.AccesData;
import src.Persistance.HibernateSession;

public class AccesDataListeRapports {
	
	private static Session s = HibernateSession.getSession();
	private static Transaction t;
	
	/**
	 * Obtenir la totalité des demandes d'intervention dans la base
	 * @return
	 */
	public static List<Rapport> getRapports() {
		List<Rapport> listeRapports = s.createQuery("FROM Rapport").list();		
		return listeRapports;
	}
	
	public static List<Rapport> getRequeteFiltre(String objet, String demandeur, String technicien, String dateDebut, String dateFin, String service, String etat, String criticite) {
		// Filtre sur le service
		String filtreService = " WHERE"; // Initialisation de la partie de la requête concernant le service
		if (service != null) {
			switch (service) {
			case "Hôtel":
				filtreService = ", EquipementHotel EH WHERE D.equipementHotelByIdEquipementHotel IS NOT NULL AND D.equipementHotelByIdEquipementHotel = EH.id AND EH.estEquipementJardin = 0 AND";
				break;
			case "Jardin":
				filtreService = ", EquipementHotel EH WHERE D.equipementHotelByIdEquipementHotel IS NOT NULL AND D.equipementHotelByIdEquipementHotel = EH.id AND EH.estEquipementJardin = 1 AND";
				break;
			case "Restaurant":
				filtreService = " WHERE D.equipementRestaurantByIdEquipementRestaurant IS NOT NULL AND";
				break;
			case "Spa":
				filtreService = " WHERE D.equipementSpaByIdEquipementSpa IS NOT NULL AND";
				break;
			default:
				System.err.println("Erreur de service");
			}
		}

		String where = "";

		String[][] filtreClientConfig = {
				{ "D.objet", objet },
				{ "R.dateDebut", dateDebut },
				{ "R.dateFin", dateFin },
				{ "D.etat", etat },
				{ "D.criticiteByIdCriticite", criticite }
			};

		where += AccesData.whereFilter(filtreClientConfig, false);

		// Filtre pour le demandeur
		String[] filtreDemandeur = { "demandeur.nom", "demandeur.prenom" };
		where += AccesData.whereFilterCompose(demandeur, filtreDemandeur, true);
		
		// Filtre pour le technicien
		String[] filtreTechnicien = { "technicien.nom", "technicien.prenom" };
		where += AccesData.whereFilterCompose(technicien, filtreTechnicien, true);

		System.out.println("SELECT D FROM DemandeIntervention D, Utilisateur U" + filtreService
				+ " D.demandeurById = U.id " + where);

		List<Rapport> listeDemandesFiltres = s
				.createQuery("SELECT R FROM Rapport R, DemandeIntervention D, Utilisateur demandeur, Utilisateur technicien" + filtreService
						+ " D.demandeurById = demandeur.id AND R.technicien = technicien.id AND R.demandeIntervention = D.id" + where)
				.list();
		return listeDemandesFiltres;
	}

	/**
	 * Permet de retrouver une demande à partir de son id
	 * @param id l'id de la demande
	 * @return la demande d'intervention
	 */
	public static DemandeIntervention getDemandeById(int id) {
		Query q = s.createQuery("FROM DemandeIntervention WHERE id = :id");
		q.setInteger("id", id);
		return (DemandeIntervention) q.uniqueResult();
	}

	public static Rapport getRapportById(int id) {
		Query q = s.createQuery("FROM Rapport WHERE id = :id");
		q.setInteger("id", id);
		return (Rapport) q.uniqueResult();
	}

}
