package src.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.Launcher.Launcher;
import src.Metier.Client;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;
import util.generalFunctions;

public class ReservationHebergementDetails implements Initializable {
	ReservationHotel reservation = new ReservationHotel();
//	@FXML private Text lblName;
//	@FXML private Text lblPhone;
//	@FXML private Text lblBirth;
//	@FXML private Text lblAddress;
//	@FXML private JFXTextArea areaInfos;
//	@FXML private Text lblResaChambre;
	
	@FXML private Text lblNumReservation;
	@FXML private Text lblValide;
	@FXML private JFXButton btnFacture;
	@FXML private Text lblNumChambre;
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
		System.out.println("update");
		lblNumReservation.setText("Réservation n°" + this.reservation.getId());
		lblValide.setText("Validée : " + generalFunctions.isValidate(this.reservation.getValide()));
		lblNumChambre.setText("Chambre n° : " + this.reservation.getChambreByIdChambre().getNumeroChambre());
		lblDateArrivee.setText("Arrivée le " + this.reservation.getDateDebut());
		lblDateDepart.setText("Départ le " + this.reservation.getDateFin());
		
		lblClientName.setText(AccesData.getClientById(this.reservation.getIdClient()).getNom() + " " + AccesData.getClientById(this.reservation.getIdClient()).getPrenom());
		lblNbAdultes.setText("Nombre d'adulte(s) : " + this.reservation.getNbAdultes());
		lblNbEnfants.setText("Nombre d'enfant(s) : " + this.reservation.getNbEnfants());
		areaInfosComp.setText(this.reservation.getInformationsComplementaires());
		lblPrixChambre.setText("Total : " + generalFunctions.calculPrixChambre(this.reservation.getChambreByIdChambre().getPrix(), this.reservation.getDateDebut(), this.reservation.getDateFin()));

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
