package src.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.Launcher.Launcher;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;
import src.util.generalFunctions;
import src.util.generationFactureHebergement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReservationHebergementDetails implements Initializable {
	ReservationHotel reservation = new ReservationHotel();

	@FXML private Text lblNumReservation;
	@FXML private Text lblValide;
	@FXML private JFXButton btnFacture;
	@FXML private Text lblNumeroChambre;
	@FXML private Text lblDateArrivee;
	@FXML private Text lblDateDepart;
	@FXML private Text lblClientName;
	@FXML private Text lblNbAdultes;
	@FXML private Text lblNbEnfants;
	@FXML private JFXTextArea areaInfosComp;
	@FXML private Text lblPrixChambre;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) { }
	
	public void setReservationHotel(ReservationHotel reservation){
	    this.reservation = reservation;
	}
	
	public void update(){
		lblNumReservation.setText("Réservation n°" + this.reservation.getId());
		lblValide.setText("Validée : " + generalFunctions.isValidate(this.reservation.getValide()));
		lblNumeroChambre.setText("Chambre n° : " + String.valueOf(this.reservation.getChambreByIdChambre().getNumeroChambre()));
		lblDateArrivee.setText("Arrivée le " + this.reservation.getDateDebut());
		lblDateDepart.setText("Départ le " + this.reservation.getDateFin());
		lblClientName.setText(AccesData.getClientById(this.reservation.getIdClient()).getNom() + " " + AccesData.getClientById(this.reservation.getIdClient()).getPrenom());
		lblNbAdultes.setText("Nombre d'adulte(s) : " + this.reservation.getNbAdultes());
		lblNbEnfants.setText("Nombre d'enfant(s) : " + this.reservation.getNbEnfants());
		areaInfosComp.setText(this.reservation.getInformationsComplementaires());
		lblPrixChambre.setText("Total : " + generalFunctions.calculPrixChambre(this.reservation.getChambreByIdChambre().getPrix(), this.reservation.getDateDebut(), this.reservation.getDateFin()) + "€");

	}
	public void generateFacture(){
		generationFactureHebergement.editFactureLauncher(this.reservation);
	}
	public void edit(){

		/**
    	 * Recupere la fenetre
    	 */
    	BorderPane rootPane = Launcher.getRoot();
    	/**
    	 * Charge la vue client details
    	 */
    	FXMLLoader loaderReservationEdit = new FXMLLoader(getClass().getResource("/src/Views/editReservationHebergement.fxml"));
		AnchorPane editReservation;
		try {
			editReservation = loaderReservationEdit.load();
			rootPane.setCenter(editReservation);
			EditReservationHebergement controllerEditReservation = loaderReservationEdit.<EditReservationHebergement>getController();
			controllerEditReservation.setReservationToInsert(this.reservation);
			controllerEditReservation.setTitreLabel();
			controllerEditReservation.fieldContent();
	    } catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void cloture(){

	}
	

}
