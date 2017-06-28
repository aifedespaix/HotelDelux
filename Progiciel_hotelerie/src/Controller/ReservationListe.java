package src.Controller;


import com.jfoenix.controls.*;
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
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import src.Launcher.Launcher;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;
import src.util.Colors;
import src.util.generalFunctions;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationListe implements Initializable {
	
	/**
	 * Déclaration des objets présents dans la vue pour y ajouter des événements
	 */
	@FXML private JFXTreeTableView<ReservationHotel> tableReservations;
	@FXML private JFXTextField txtName;
	@FXML private JFXTextField txtNumeroChambre;
	@FXML private JFXDatePicker dateArrive;
	@FXML private JFXDatePicker dateDepart;
	@SuppressWarnings(value = { "" })
	/**
	 * Déclaration de la liste d'observables qui contiendra les objets a afficher dans le tableau
	 */
	private ObservableList<ReservationHotel> listeReservationHotel = FXCollections.observableArrayList();

	@SuppressWarnings({ "unchecked", "unchecked", "unchecked", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//List<Client> listec = AccesData.getClients();
		List<ReservationHotel> listeResasHotel = AccesData.getReservationsHotel();
		/**
		 * Ajoute chaque client récupéré à la liste d'observable de clients
		 */
		for(ReservationHotel r : listeResasHotel){
			listeReservationHotel.add(r);
		}
		/**
		 * Créé l'arbre d'objets avec la liste d'observables de clients
		 */
		final TreeItem<ReservationHotel> root = new RecursiveTreeItem<ReservationHotel>(listeReservationHotel, RecursiveTreeObject::getChildren);	
		

		JFXTreeTableColumn<ReservationHotel, JFXButton> voir = new JFXTreeTableColumn<>("Voir");
		voir.setPrefWidth(150);
		voir.setMinWidth(100);
		voir.setCellValueFactory(param -> new ObservableValue() {
				
				@Override
				public void addListener(InvalidationListener listener) { }

				@Override
				public void removeListener(InvalidationListener listener) { }

				@Override
				public void addListener(ChangeListener listener) { }

				@Override
				public Object getValue() {
					// TODO Auto-generated method stub
					JFXButton bouton = new JFXButton("Visualiser");
					Colors.primary(bouton);

					/**
					 * Id pour recupere le client correspondant a la ligne
					 */
					bouton.setId(String.valueOf(param.getValue().getValue().getId()));
					
					/**
					 * Gere l'evenement clique sur le bouton
					 */
					bouton.setOnAction(new EventHandler<ActionEvent>() {
					    @Override public void handle(ActionEvent e) {
					    	BorderPane rootPane = Launcher.getRoot();

					    	FXMLLoader loaderReservationDetails = new FXMLLoader(getClass().getResource("/src/Views/hebergementReservationDetails.fxml"));
			       			AnchorPane reservationDetails;
							try {
								reservationDetails = loaderReservationDetails.load();
								rootPane.setCenter(reservationDetails);
						    	ReservationHotel r = AccesData.getReservationHotelById(Integer.parseInt(bouton.getId()));
						        ReservationHebergementDetails controllerReservationHotel = loaderReservationDetails.<ReservationHebergementDetails>getController();
						        controllerReservationHotel.setReservationHotel(r);
						        controllerReservationHotel.update();
						    } catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}   
					    }
					});
					return bouton;
				}

				@Override
				public void removeListener(ChangeListener listener) { }
		});
		
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<ReservationHotel, String> client = new JFXTreeTableColumn<>("Client");
		client.setPrefWidth(150);
		client.setMinWidth(100);
		client.setCellValueFactory(param -> new SimpleStringProperty(AccesData.getClientById(param.getValue().getValue().getIdClient()).getNom() + " " + AccesData.getClientById(param.getValue().getValue().getIdClient()).getPrenom()));
		
		JFXTreeTableColumn<ReservationHotel, String> numChambre = new JFXTreeTableColumn<>("Numéro de chambre");
		numChambre.setPrefWidth(150);
		numChambre.setMinWidth(100);
		numChambre.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getChambreByIdChambre().getNumeroChambre())));
		
		JFXTreeTableColumn<ReservationHotel, String> dateArrivee = new JFXTreeTableColumn<>("Date arrivée");
		dateArrivee.setPrefWidth(150);
		dateArrivee.setMinWidth(100);
		dateArrivee.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.formatDate(param.getValue().getValue().getDateDebut())));
		
		JFXTreeTableColumn<ReservationHotel, String> dateFin = new JFXTreeTableColumn<>("Date départ");
		dateFin.setPrefWidth(150);
		dateFin.setMinWidth(100);
		dateFin.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.formatDate(param.getValue().getValue().getDateFin())));

		JFXTreeTableColumn<ReservationHotel, String> prix = new JFXTreeTableColumn<>("Prix");
		prix.setPrefWidth(150);
		prix.setMinWidth(100);
		prix.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(generalFunctions.calculPrixChambre(param.getValue().getValue().getChambreByIdChambre().getPrix(),param.getValue().getValue().getDateDebut(), param.getValue().getValue().getDateFin()))));
		
		JFXTreeTableColumn<ReservationHotel, String> valide = new JFXTreeTableColumn<>("Validée");
		valide.setPrefWidth(150);
		valide.setMinWidth(100);
		valide.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.isValidate(param.getValue().getValue().getValide())));
		
		JFXTreeTableColumn<ReservationHotel, String> formule = new JFXTreeTableColumn<>("Formule");
		formule.setPrefWidth(150);
		formule.setMinWidth(100);
		formule.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.idFormuleToString(param.getValue().getValue().getFormule())));

		tableReservations.setRoot(root);
		tableReservations.setShowRoot(false);
		
		/**
		 * Récupère les colonnes du tableau puis ajoute les nouvelles colonnes précédemment déclarées
		 */
		tableReservations.getColumns().setAll(voir,client,numChambre,dateArrivee,dateFin,prix,valide, formule);

	}

	public void search(){
		listeReservationHotel.clear();
		
		List<ReservationHotel> listeReservations = null;
		
		if(!txtName.getText().equals("")){
			listeReservations = AccesData.getReservationHotelByName(txtName.getText());
		} else if (!txtNumeroChambre.getText().equals("")){
			listeReservations = AccesData.getReservationHotelByRoomNumber(Integer.valueOf(txtNumeroChambre.getText()));
		} else if (dateArrive.getValue() != null){
			listeReservations = AccesData.getReservationHotelByBeginDate(Date.valueOf(dateArrive.getValue()));
		} else if (dateDepart.getValue() != null){
			listeReservations = AccesData.getReservationHotelByEndDate(Date.valueOf(dateDepart.getValue()));
		}		
		
		if(listeReservations.size() > 0){
			for(ReservationHotel rh : listeReservations){
				listeReservationHotel.add(rh);
			}
		}
	}
	
	public void createReservation(){
		AnchorPane newReservation;
		BorderPane root = Launcher.getRoot();
		try {
			FXMLLoader loaderReservation = new FXMLLoader(getClass().getResource("/src/Views/editReservationHebergement.fxml"));
			newReservation = loaderReservation.load();
			EditReservationHebergement controllerEditReservation = loaderReservation.<EditReservationHebergement>getController();
			controllerEditReservation.setTitreLabel();
			root.setCenter(newReservation);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	
//	public void createClient(){
//		BorderPane root = Launcher.getRoot();
//		FXMLLoader loaderClientNew = new FXMLLoader(getClass().getResource("/src/Views/newClient.fxml"));
//		AnchorPane newClient;
//		try {
//			newClient = loaderClientNew.load();
//			root.setCenter(newClient);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
}
