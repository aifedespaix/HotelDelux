package util;

import java.io.IOException;
import java.sql.Date;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
}
