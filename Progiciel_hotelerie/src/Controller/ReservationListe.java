package src.Controller;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.cfg.Configuration;
import javafx.fxml.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.base.JFXTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.application.Application.Parameters;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import src.Launcher.Launcher;
import src.Metier.Client;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;
import util.generalFunctions;

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
		voir.setPrefWidth(100);		
		voir.setCellValueFactory(param -> new ObservableValue() {
				
				@Override
				public void addListener(InvalidationListener listener) {
					// TODO Auto-generated method stub
				}

				@Override
				public void removeListener(InvalidationListener listener) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void addListener(ChangeListener listener) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public Object getValue() {
					// TODO Auto-generated method stub
					JFXButton bouton = new JFXButton("Visualiser");
					
					/**
					 * Id pour recupere le client correspondant a la ligne
					 */
					bouton.setId(String.valueOf(param.getValue().getValue().getId()));
					
					/**
					 * Gere l'evenement clique sur le bouton
					 */
					bouton.setOnAction(new EventHandler<ActionEvent>() {
					    @Override public void handle(ActionEvent e) {
					    	
//					    	/**
//					    	 * Recupere la fenetre
//					    	 */
//					    	BorderPane rootPane = Launcher.getRoot();
//					    	/**
//					    	 * Charge la vue client details
//					    	 */
//					    	FXMLLoader loaderClientDetails = new FXMLLoader(getClass().getResource("/src/Views/clientDetails.fxml"));
//			       			AnchorPane clientDetails;
//							try {
//								clientDetails = loaderClientDetails.load();
//								rootPane.setCenter(clientDetails);
//								/**
//								 * Recupere le client correspondant à l'id
//								 */
//						    	Client c = AccesData.getClientById(Integer.parseInt(bouton.getId()));
//						        //System.out.println(c);
//						        ClientDetails controllerClient = loaderClientDetails.<ClientDetails>getController();
//						        controllerClient.setClient(c);
//						        controllerClient.update();
//						    } catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}   
					    }
					});
					return bouton;
				}

				@Override
				public void removeListener(ChangeListener listener) {
					// TODO Auto-generated method stub
					
				}
		});
		
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<ReservationHotel, String> client = new JFXTreeTableColumn<>("Client");
		client.setPrefWidth(100);
		client.setCellValueFactory(param -> new SimpleStringProperty(AccesData.getClientById(param.getValue().getValue().getIdClient()).getNom() + " " + AccesData.getClientById(param.getValue().getValue().getIdClient()).getPrenom()));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<ReservationHotel, String> numChambre = new JFXTreeTableColumn<>("Numéro de chambre");
		numChambre.setPrefWidth(100);
		numChambre.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getChambreByIdChambre().getNumeroChambre())));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<ReservationHotel, String> dateArrivee = new JFXTreeTableColumn<>("Date arrivée");
		dateArrivee.setPrefWidth(100);
		dateArrivee.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getDateDebut())));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<ReservationHotel, String> dateFin = new JFXTreeTableColumn<>("Date départ");
		dateFin.setPrefWidth(100);
		dateFin.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getDateFin())));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<ReservationHotel, String> prix = new JFXTreeTableColumn<>("Prix");
		prix.setPrefWidth(100);		
		prix.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(generalFunctions.calculPrixChambre(param.getValue().getValue().getChambreByIdChambre().getPrix(),param.getValue().getValue().getDateDebut(), param.getValue().getValue().getDateFin()))));
		
		
		/**
		 * Ajoute l'arbre de clients au panel
		 */
		tableReservations.setRoot(root);
		tableReservations.setShowRoot(false);
		
		/**
		 * Récupère les colonnes du tableau puis ajoute les nouvelles colonnes précédemment déclarées
		 */
		tableReservations.getColumns().setAll(voir,client,numChambre,dateArrivee,dateFin,prix);

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
			listeReservations = AccesData.getReservationHotelByBeginDate(Date.valueOf(dateDepart.getValue()));
		}		
		
		if(listeReservations.size() > 0){
			for(ReservationHotel rh : listeReservations){
				listeReservationHotel.add(rh);
			}
		}
	}
	
	public void createReservation(){
		
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
