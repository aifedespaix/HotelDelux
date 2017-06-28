package src.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import src.Metier.DemandeIntervention;

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
	
	/**
	 * Formate la date en jj/mm/aaaa
	 * @param date la date à formater
	 * @return la date formatée
	 */
	public static String formatDate(Date date) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	return formatter.format(date);
	}
	
	/**
	 * Retrouve la location de l'équipement sur lequel a été fait la demande
	 * @param demande
	 * @return le service dans lequel se trouve l'équipement
	 */
	public static String getServiceDemande(DemandeIntervention demande) {
		if (demande.getEquipementHotelByIdEquipementHotel() == null) {
			if (demande.getEquipementRestaurantByIdEquipementRestaurant() == null) {
				return "Spa";
			} else {
				return "Restaurant";
			}
		} else {
			if (demande.getEquipementHotelByIdEquipementHotel().getEstEquipementJardin()) {
				return "Jardin";
			} else {
				return "Hôtel";
			}
		}
	}

	public static String getEquipementDemande(DemandeIntervention demande) {
		if (demande.getEquipementHotelByIdEquipementHotel() != null) {
			return demande.getEquipementHotelByIdEquipementHotel().getLibelle();
		} else if (demande.getEquipementRestaurantByIdEquipementRestaurant() != null) {
			return demande.getEquipementRestaurantByIdEquipementRestaurant().getLibelle();
		} else {
			return demande.getEquipementSpaByIdEquipementSpa().getLibelle();
		}
	}
}
