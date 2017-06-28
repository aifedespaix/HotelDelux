package src.Controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.Metier.Criticite;
import src.Metier.DemandeIntervention;
import src.Metier.EquipementHotel;
import src.Metier.EquipementRestaurant;
import src.Metier.EquipementSpa;
import src.Metier.Etat;
import src.Persistance.Maintenance.AccesDataNewDemande;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

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
		locationEquipement = 1; // => H�tel
		
		// Charge la liste des �tages dans le combo box correspondant
		etages.getItems().addAll(AccesDataNewDemande.getListeEtages());
		
		// Charge la liste de toutes les chambres par d�faut
		// Une fois un �tage s�lectionn�, la liste des cjhambres sera recharg� et de m�me pour les �quipements
		chambres.getItems().addAll(AccesDataNewDemande.getListeChambres());
		
		// Charge la liste des �quipements
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipement());
		equipementsJardin.getItems().addAll(AccesDataNewDemande.getListeEquipementJardin());
		equipementsRestaurant.getItems().addAll(AccesDataNewDemande.getListeEquipementRestaurant());
		equipementsSpa.getItems().addAll(AccesDataNewDemande.getListeEquipementSpa());
		
		// Charge la liste des criticit�
		criticite.getItems().addAll(AccesDataNewDemande.getListeCriticite());
	}
	
	/**
	 * Met � jour le label du temps de prise en charge en fonction de la criticit� s�lectionn�e
	 */
	public void tempsPriseEnCharge() {
		priseEnCharge.setText("Temps de prise en charge : " + criticite.getValue().getTempsMaximum().toString());
	}
	
	/**
	 * Permet de cr�er une demande � partir des �l�ments renseign�s dans la fen�tre
	 */
	public void createDemande() {
		System.out.println("Objet : " + objetField.getText());
		System.out.println("Description : " + descriptionField.getText());
		System.out.println("Criticit� : " + criticite.getValue());
		
		EquipementHotel equipementHotel = null;
		EquipementRestaurant equipementRestaurant = null;
		EquipementSpa equipementSpa = null;
		
		switch (locationEquipement) {
			case ID_ONGLET_HOTEL :
				System.out.println("Equipement H�tel : " + equipementsHotel.getValue());
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
		
		// Cr�ation de la demande
		DemandeIntervention newDemande = new DemandeIntervention(
				new Date(0), //date de cr�ation
				objetField.getText(),
				descriptionField.getText(),
				false, // la demande n'est pas valid� par d�faut
				criticite.getValue(),
				(EquipementSpa) equipementSpa, //spa
				(EquipementHotel) equipementHotel, // hotel ou jardin
				(EquipementRestaurant) equipementRestaurant, //restaurant
				null, //pi�ce de rechange
				null, //demande utilisateur
				null, //rapport
				Login.getConnectedUser(), // Demandeur
				new Etat(1) // Etat en prise de connaissance par d�faut
				);
		//Persistance dans la base
		AccesDataNewDemande.ajouterDemande(newDemande);
		// TODO Afficher un message de confirmation
		
		closeButtonAction();
	}
	
	/**
	 * Filtre les autres combo box en fonction de l'�tage s�lectionn�
	 */
	public void filterEtage() {
		chambres.getItems().clear();
		chambres.getItems().addAll(AccesDataNewDemande.getListeChambres((int) etages.getValue()));
		equipementsHotel.getItems().clear();
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipementByEtage((int) etages.getValue()));
	}
	
	/**
	 * Filtre la liste des �quipements en fonction de la chambre s�lectionn�e
	 */
	public void filterChambre() {
		equipementsHotel.getItems().clear();
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipementByChambre((int) chambres.getValue()));
	}
	
	/**
	 * Ferme la fen�tre
	 */
	public void closeButtonAction(){
	    // R�cup�re la sc�ne et la ferme
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
