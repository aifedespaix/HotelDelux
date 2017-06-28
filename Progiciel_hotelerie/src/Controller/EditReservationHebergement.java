package src.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.Launcher.Launcher;
import src.Metier.Chambre;
import src.Metier.Client;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;
import src.util.generalFunctions;

public class EditReservationHebergement implements Initializable  {

	@FXML private Text titreLabel;
	@FXML private JFXComboBox<Chambre> comboRoom;
	@FXML private JFXDatePicker dateBegin;
	@FXML private JFXDatePicker dateEnd;
	@FXML private Text clientLabel;
	@FXML private JFXTextField txtName;
	@FXML private JFXTextField txtPrenom;
	@FXML private JFXTreeTableView<Client> tableClient;
	@FXML private Text capaciteMax;
	@FXML private Spinner<Integer> nbAdultes;
	@FXML private Spinner<Integer> nbEnfants;
	@FXML private JFXRadioButton inclusive;
	@FXML private JFXRadioButton demi;
	@FXML private JFXRadioButton externe;
	@FXML private JFXTextArea areaInfos;
	@FXML private ToggleGroup formule;
	
	BorderPane root = Launcher.getRoot();
	private ObservableList<Client> listeClientReservations = FXCollections.observableArrayList();
	private ReservationHotel reservationToInsert;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inclusive.setUserData(0);
		demi.setUserData(1);
		externe.setUserData(2);
	}

	public void setReservationToInsert(ReservationHotel reservationToInsert) {
		this.reservationToInsert = reservationToInsert;
	}

	/**
	 * Change le titre de la page en fonction de si c'est une édition ou une création de réservation
	 */
	public void setTitreLabel() {
		if (reservationToInsert == null) {
			titreLabel.setText("Nouvelle Réservation");
			reservationToInsert = new ReservationHotel();
		} else {
			titreLabel.setText("Edition de la réservation n°" + reservationToInsert.getId());
			// Elle a déjà été setté au moment de la création de la vue.
		}
	}
	
	public void loadRoomList(){
		comboRoom.setDisable(false);
		List<Chambre> listeChambreDisponibles = AccesData.getFreeRoom(Date.valueOf(dateBegin.getValue()), Date.valueOf(dateEnd.getValue()));
		comboRoom.getItems().addAll(listeChambreDisponibles);
	}
	
	public void save(){		
		this.reservationToInsert.setDateDebut(Date.valueOf(dateBegin.getValue()));
		this.reservationToInsert.setDateFin(Date.valueOf(dateEnd.getValue()));
		this.reservationToInsert.setNbAdultes(Integer.valueOf(nbAdultes.getValue().toString()));
		this.reservationToInsert.setNbEnfants(Integer.valueOf(nbEnfants.getValue().toString()));
		this.reservationToInsert.setTvaByIdTva(AccesData.getTVAById(1));
		this.reservationToInsert.setChambreByIdChambre(comboRoom.getValue());
		this.reservationToInsert.setValide(false);
		this.reservationToInsert.setInformationsComplementaires(areaInfos.getText());
		this.reservationToInsert.setFormule((int) formule.getSelectedToggle().getUserData());
		
		AccesData.ajouterModifierReservationHotel(this.reservationToInsert);
	}
	
	public void cancel() throws IOException{
		FXMLLoader loaderReservations = new FXMLLoader(getClass().getResource("/src/Views/reservationsList.fxml"));
		AnchorPane reservation = loaderReservations.load();
		root.setCenter(reservation);
	}
	
	public void searchClient(){
		listeClientReservations.clear();
		List<Client> listeClient = null;
		if(!txtName.equals("") || !txtPrenom.equals("")){
			listeClient = AccesData.getClientFiltre(txtName.getText(), txtPrenom.getText(),"","");
		}
		
		listeClientReservations.addAll(listeClient);
		
		final TreeItem<Client> root = new RecursiveTreeItem<Client>(listeClientReservations, RecursiveTreeObject::getChildren);	

		
		JFXTreeTableColumn<Client, JFXButton> ajouter = new JFXTreeTableColumn<>("Sélectionner");
		ajouter.setPrefWidth(100);		
		ajouter.setCellValueFactory(param -> new ObservableValue() {
				
				@Override
				public void addListener(InvalidationListener listener) { }

				@Override
				public void removeListener(InvalidationListener listener) {	}

				@Override
				public void addListener(ChangeListener listener) { }

				@Override
				public Object getValue() {
					JFXButton bouton = new JFXButton("Sélectionner");
					
					/**
					 * Id pour recupere le client correspondant a la ligne
					 */
					bouton.setId(String.valueOf(param.getValue().getValue().getId()));
					
					/**
					 * Gere l'evenement clique sur le bouton
					 */
					bouton.setOnAction(new EventHandler<ActionEvent>() {
					    @Override public void handle(ActionEvent e) {
					    	// Récupération du client
					    	Client client = AccesData.getClientById(Integer.valueOf(bouton.getId()));
					    	reservationToInsert.setIdClient(client.getId());
					    	clientLabel.setText(client.getPrenom() + " " + client.getNom());
					    }
					});
					return bouton;
				}

				@Override
				public void removeListener(ChangeListener listener) { }
		});

		JFXTreeTableColumn<Client, String> client = new JFXTreeTableColumn<>("Nom");
		client.setPrefWidth(100);
		client.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getNom()));
		
		JFXTreeTableColumn<Client, String> numChambre = new JFXTreeTableColumn<>("Prénom");
		numChambre.setPrefWidth(100);
		numChambre.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPrenom()));

		JFXTreeTableColumn<Client, String> dateArrivee = new JFXTreeTableColumn<>("Adresse");
		dateArrivee.setPrefWidth(100);
		dateArrivee.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getAdresseRue() + " , " + param.getValue().getValue().getAdresseVille() + " , " + param.getValue().getValue().getCodePostal())));
		
		/**
		 * Ajoute l'arbre de clients au panel
		 */

		tableClient.setRoot(root);
		tableClient.setShowRoot(false);
		
		tableClient.getColumns().setAll(ajouter,client,numChambre,dateArrivee);
	}
	
	@SuppressWarnings("unchecked")
	public void fieldContent(){
		this.dateBegin.setValue(this.reservationToInsert.getDateDebut().toLocalDate());
		this.dateEnd.setValue(this.reservationToInsert.getDateFin().toLocalDate());
		this.loadRoomList();
		comboRoom.setValue(this.reservationToInsert.getChambreByIdChambre());
		Client client = AccesData.getClientById(this.reservationToInsert.getIdClient());
		txtName.setText(client.getNom());
		txtPrenom.setText(client.getPrenom());
		this.searchClient();
		clientLabel.setText(client.getPrenom() + " " + client.getNom());
		capaciteMax.setText(Integer.toString(comboRoom.getValue().getCapacite()));
		nbAdultes.setDisable(false);
		nbEnfants.setDisable(false);
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, this.reservationToInsert.getChambreByIdChambre().getCapacite() - this.reservationToInsert.getNbEnfants(), this.reservationToInsert.getNbAdultes());
		nbAdultes.setValueFactory(valueFactory);		
		SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, this.reservationToInsert.getChambreByIdChambre().getCapacite() - this.reservationToInsert.getNbAdultes(), this.reservationToInsert.getNbEnfants());
		nbEnfants.setValueFactory(valueFactory2);
		areaInfos.setText(this.reservationToInsert.getInformationsComplementaires());
		switch(this.reservationToInsert.getFormule()) {
		case 0 : formule.selectToggle(inclusive); break;
		case 1 : formule.selectToggle(demi); break;
		case 2 : formule.selectToggle(externe); break;
		default : System.err.println("Il y a une erreur dans la formule de la réservation " + this.reservationToInsert);
		}
		
	}
	
	/**
	 * Rempli les stepper pour le nb d'adulte et d'enfants en fonction de la capacité max de la chambre
	 */
	public void updateMaxStepper() {
		//Informe la capacité max de la chambre
		capaciteMax.setText(Integer.toString(comboRoom.getValue().getCapacite()));
		
		//Rend disponible les steppers
		nbAdultes.setDisable(false);
		nbEnfants.setDisable(false);
		
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, this.comboRoom.getValue().getCapacite());
		nbAdultes.setValueFactory(valueFactory);
		
		SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, this.comboRoom.getValue().getCapacite());
		nbEnfants.setValueFactory(valueFactory2);
	}
	
	/**
	 * Remet à jour la valeur max du stepper pour le nb d'adulte en fonction du nb d'enfants sélectionné
	 */
	public void updateNbAdulte() {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, this.comboRoom.getValue().getCapacite() - this.nbEnfants.getValue(), this.nbAdultes.getValue());
		nbAdultes.setValueFactory(valueFactory);
	}
	
	/**
	 * Remet à jour la valeur max du stepper pour le nb d'enfants en fonction du nb d'adulte sélectionné
	 */
	public void updateNbEnfants() {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, this.comboRoom.getValue().getCapacite() - this.nbAdultes.getValue(), this.nbEnfants.getValue());
		nbEnfants.setValueFactory(valueFactory);
	}

}
