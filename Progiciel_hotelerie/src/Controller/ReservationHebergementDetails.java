package src.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;
import src.util.generalFunctions;
import src.util.generationFactureHebergement;

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
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setReservationHotel(ReservationHotel reservation){
	    this.reservation = reservation;
	}
	
	public void update(){
		lblNumReservation.setText("Réservation né" + this.reservation.getId());
		lblValide.setText("Validée : " + generalFunctions.isValidate(this.reservation.getValide()));
		lblNumeroChambre.setText("Chambre né : " + String.valueOf(this.reservation.getChambreByIdChambre().getNumeroChambre()));
		lblDateArrivee.setText("Arrivée le " + this.reservation.getDateDebut());
		lblDateDepart.setText("Départ le " + this.reservation.getDateFin());
		lblClientName.setText(AccesData.getClientById(this.reservation.getIdClient()).getNom() + " " + AccesData.getClientById(this.reservation.getIdClient()).getPrenom());
		lblNbAdultes.setText("Nombre d'adulte(s) : " + this.reservation.getNbAdultes());
		lblNbEnfants.setText("Nombre d'enfant(s) : " + this.reservation.getNbEnfants());
		areaInfosComp.setText(this.reservation.getInformationsComplementaires());
		lblPrixChambre.setText("Total : " + generalFunctions.calculPrixChambre(this.reservation.getChambreByIdChambre().getPrix(), this.reservation.getDateDebut(), this.reservation.getDateFin()) + "é");

	}
	public void generateFacture(){
		generationFactureHebergement.editFactureLauncher(this.reservation);
	}
	public void editClient(){
//		/**
//    	 * Recupere la fenetre
//    	 */
//    	BorderPane rootPane = Launcher.getRoot();
//    	/**
//    	 * Charge la vue client details
//    	 */
//    	FXMLLoader loaderClientEdit = new FXMLLoader(getClass().getResource("/src/Views/editClient.fxml"));
//			AnchorPane editClient;
//		try {
//			editClient = loaderClientEdit.load();
//			rootPane.setCenter(editClient);
//	        //System.out.println(c);
//	        EditClient controllerEditClient = loaderClientEdit.<EditClient>getController();
//	        controllerEditClient.setClient(this.client);
//	        controllerEditClient.fieldContent();
//	    } catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
	

}
