package src.Persistance.Maintenance;

import org.hibernate.Session;
import org.hibernate.Transaction;
import src.Metier.Criticite;
import src.Metier.Etat;
import src.Metier.Rapport;
import src.Persistance.HibernateSession;

import java.util.List;

public class AccesDataMaintenance {
	
	private static Session s = HibernateSession.getSession();
	private static Transaction t;
	
	/**
	 * @return la liste des tous les états
	 */
	public static List<Etat> getListeEtat() {
		List<Etat> listeEtat = s.createQuery("FROM Etat").list();		
		return listeEtat;
	}

	/**
	 * @return la liste des toutes les criticités
	 */
	public static List<Criticite> getListeCriticite() {
		List<Criticite> listeCriticite = s.createQuery("FROM Criticite").list();	
		return listeCriticite;
	}

	/**
	 * Ajoute le rapport dans la base
	 * @param rapport le rapport à ajouté
	 */
	public static void ajouterRapport(Rapport rapport) {
		try {
			t = s.beginTransaction();
			s.save(rapport);
			t.commit();
		} catch (org.hibernate.HibernateException e) {
			System.err.println("Erreur Hibernate : " + e.getMessage());
		}
	}

}
