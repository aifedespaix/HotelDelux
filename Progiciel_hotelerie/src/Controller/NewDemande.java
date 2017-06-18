package src.Controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.Metier.Criticite;
import src.Metier.DemandeIntervention;
import src.Metier.EquipementHotel;
import src.Metier.EquipementRestaurant;
import src.Metier.EquipementSpa;
import src.Persistance.Maintenance.AccesDataNewDemande;

public class NewDemande implements Initializable {
	
	@FXML private JFXTabPane onglet;
	@FXML private JFXComboBox etages;
	@FXML private JFXComboBox chambres;
	@FXML private JFXComboBox<EquipementHotel> equipementsHotel;
	@FXML private JFXComboBox<EquipementHotel> equipementsJardin;
	@FXML private JFXComboBox<EquipementRestaurant> equipementsRestaurant;
	@FXML private JFXComboBox<EquipementSpa> equipementsSpa;
	@FXML private JFXTextField objetField;
	@FXML private JFXTextArea descriptionField;
	@FXML private JFXComboBox<Criticite> criticite;
	@FXML private JFXButton closeButton;
	@FXML private Text priseEnCharge;
	
	private int locationEquipement;
	private final int ID_ONGLET_HOTEL = 1;
	private final int ID_ONGLET_JARDIN = 2;
	private final int ID_ONGLET_RESTAURANT = 3;
	private final int ID_ONGLET_SPA = 4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		locationEquipement = 1; // => Hôtel
		
		// Charge la liste des étages dans le combo box correspondant
		etages.getItems().addAll(AccesDataNewDemande.getListeEtages());
		
		// Charge la liste de toutes les chambres par défaut
		// Une fois un étage sélectionné, la liste des cjhambres sera rechargé et de même pour les équipements
		chambres.getItems().addAll(AccesDataNewDemande.getListeChambres());
		
		// Charge la liste des équipements
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipement());
		equipementsJardin.getItems().addAll(AccesDataNewDemande.getListeEquipementJardin());
		equipementsRestaurant.getItems().addAll(AccesDataNewDemande.getListeEquipementRestaurant());
		equipementsSpa.getItems().addAll(AccesDataNewDemande.getListeEquipementSpa());
		
		// Charge la liste des criticité
		criticite.getItems().addAll(AccesDataNewDemande.getListeCriticite());
	}
	
	public void tempsPriseEnCharge() {
		priseEnCharge.setText("Temps de prise en charge : " + criticite.getValue().getTempsMaximum().toString());
	}
	
	/**
	 * Permet de créer une demande à partir des éléments renseignés dans la fenêtre
	 */
	public void createDemande() {
		System.out.println("Objet : " + objetField.getText());
		System.out.println("Description : " + descriptionField.getText());
		System.out.println("Criticité : " + criticite.getValue());
		
		EquipementHotel equipementHotel = null;
		EquipementRestaurant equipementRestaurant = null;
		EquipementSpa equipementSpa = null;
		
		switch (locationEquipement) {
			case ID_ONGLET_HOTEL :
				System.out.println("Equipement Hôtel : " + equipementsHotel.getValue());
				equipementHotel = equipementsHotel.getValue();
				break;
			case ID_ONGLET_JARDIN :
				System.out.println("Equipement Jardin : " + equipementsJardin.getValue());
				equipementHotel = equipementsJardin.getValue();
				break;
			case ID_ONGLET_RESTAURANT :
				System.out.println("Equipement Restaurant : " + equipementsRestaurant.getValue());
				equipementRestaurant = equipementsRestaurant.getValue();
				break;
			case ID_ONGLET_SPA :
				System.out.println("Equipement Spa : " + equipementsSpa.getValue());
				equipementSpa = equipementsSpa.getValue();
				break;
		}
		
		// Création de la demande
		DemandeIntervention newDemande = new DemandeIntervention(
				new Date(0), //date de création
				objetField.getText(),
				descriptionField.getText(),
				true, //valide
				criticite.getValue(),
				(EquipementSpa) equipementSpa, //spa
				(EquipementHotel) equipementHotel, // hotel ou jardin
				(EquipementRestaurant) equipementRestaurant, //restaurant
				null, //pièce de rechange
				null, //demande utilisateur
				null //rapport
				);
		//Persistance dans la base
		AccesDataNewDemande.ajouterDemande(newDemande);
		// TODO Afficher un message de confirmation
		
		closeButtonAction();
	}
	
	/**
	 * Filtre les autres combo box en fonction de l'étage sélectionné
	 */
	public void filterEtage() {
		chambres.getItems().clear();
		chambres.getItems().addAll(AccesDataNewDemande.getListeChambres((int) etages.getValue()));
		equipementsHotel.getItems().clear();
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipementByEtage((int) etages.getValue()));
	}
	
	/**
	 * Filtre la liste des équipements en fonction de la chambre sélectionnée
	 */
	public void filterChambre() {
		equipementsHotel.getItems().clear();
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipementByChambre((int) chambres.getValue()));
	}
	
	/**
	 * Ferme la fenêtre
	 */
	public void closeButtonAction(){
	    // Récupère la scène et la ferme
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}
	
	public void setOngletHotel() {
		locationEquipement = 1;
	}
	
	public void setOngletJardin() {
		locationEquipement = 2;
	}
	
	public void setOngletRestaurant() {
		locationEquipement = 3;
	}
	
	public void setOngletSpa() {
		locationEquipement = 4;
	}
}
