package src.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class generalFunctions {

	/**
	 * Function qui calcule le prix d'une chambre en fonction du nombre d'enfants, adultes, des prix et du nombre de jours dans l'hotel
	 * @param nbAdultes
	 * @param nbEnfants
	 * @param prixAdulte
	 * @param prixEnfant
	 * @param dateDebut
	 * @param dateFin
	 * @return
	 */
	
	public static double calculPrixChambre(double prix, Date dateDebut, Date dateFin){
		double prixReservation = 0;
		final long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
		int nbJoursSejour = (int)((dateFin.getTime() - dateDebut.getTime()) / MILLISECONDS_IN_DAY);		
		prixReservation = prix * nbJoursSejour;
		
		return prixReservation;
	}
	
	public static String isValidate(Boolean valide){
		String isValide = "";
		if( valide == true){
			isValide = "Validée";
		} else {
			isValide = "Non validée";
		}
		return isValide;
	}
	
	public static String idFormuleToString(int id) {
		switch(id) {
			case 0 : return "All-Inclusive";
			case 1 : return "Demi-Pensionnaire";
			case 2 : return "Externe";
			default : return "Erreur sur l'id de la formule";
		}
	}
	
	public static String formatDate(Date date) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	return formatter.format(date);
	}
}
