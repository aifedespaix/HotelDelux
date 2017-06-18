package src.Controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import src.Metier.Criticite;
import src.Metier.DemandeIntervention;
import src.Metier.EquipementHotel;
import src.Metier.EquipementRestaurant;
import src.Metier.EquipementSpa;
import src.Persistance.Maintenance.AccesDataNewDemande;

public class NewDemande implements Initializable {
	
	@FXML private JFXTabPane onglets;
	@FXML private JFXComboBox etages;
	@FXML private JFXComboBox chambres;
	@FXML private JFXComboBox<EquipementHotel> equipementsHotel;
	@FXML private JFXComboBox<EquipementHotel> equipementsJardin;
	@FXML private JFXComboBox<EquipementRestaurant> equipementsRestaurant;
	@FXML private JFXComboBox<EquipementSpa> equipementsSpa;
	@FXML private JFXTextField objetField;
	@FXML private JFXTextArea descriptionField;
	@FXML private JFXComboBox<Criticite> criticite;
	@FXML private Text priseEnCharge;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
		System.out.println("Equipement : " + equipementsHotel.getValue());
		
		// Création de la demande
		DemandeIntervention newDemande = new DemandeIntervention(
				new Date(0), //date de création
				objetField.getText(),
				descriptionField.getText(),
				true, //valide
				criticite.getValue(),
				null, //spa
				(EquipementHotel) equipementsHotel.getValue(),
				null, //restaurant
				null, //pièce de rechange
				null, //demande utilisateur
				null //rapport
				);
		//Persistance dans la base
		AccesDataNewDemande.ajouterDemande(newDemande);
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
	
	public void changeLocationEquipement() {
		System.out.println(onglets.toString());
	}
}
