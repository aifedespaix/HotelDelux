package src.Controller;

import com.jfoenix.controls.JFXTextArea;
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
import src.util.generalFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClientDetails implements Initializable {
	Client client = new Client();
	@FXML private Text lblName;
	@FXML private Text lblPhone;
	@FXML private Text lblBirth;
	@FXML private Text lblAddress;
	@FXML private Text areaInfos;
	@FXML private Text lblResaChambre;
	@FXML private JFXTreeTableView<ReservationHotel> tableResaChambreClient;
	private ObservableList<ReservationHotel> listeReservationsHotel = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) { }
	
	public void setClient(Client client){
	    this.client = client;
	}
	public void update(){
		lblName.setText(this.client.getNom() + " " + this.client.getPrenom());
		lblPhone.setText(this.client.getTelephone());
		lblBirth.setText(generalFunctions.formatDate(this.client.getDateNaissance()));
		lblAddress.setText(this.client.getAdresseRue() + " " + this.client.getAdresseVille() + " " + this.client.getCodePostal());

		areaInfos.setText(this.client.getAllergies());
		lblResaChambre.setText("Réservation en cours : " + AccesData.getChambreClientActuelle(this.client.getId()));
		
		
		
		List<ReservationHotel> listeR = AccesData.getReservationsClients(this.client.getId());
		for( ReservationHotel r : listeR){
			listeReservationsHotel.add(r);
		}
		final TreeItem<ReservationHotel> root = new RecursiveTreeItem<ReservationHotel>(listeReservationsHotel, RecursiveTreeObject::getChildren);	

		JFXTreeTableColumn<ReservationHotel, String> reservationNumber = new JFXTreeTableColumn<>("Numéro de réservation");
		reservationNumber.setPrefWidth(100);
		reservationNumber.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getId())));
		
		JFXTreeTableColumn<ReservationHotel, String> beginDateResa = new JFXTreeTableColumn<>("Date de d'arrivée");
		beginDateResa.setPrefWidth(100);
		beginDateResa.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.formatDate(param.getValue().getValue().getDateDebut())));
		
		JFXTreeTableColumn<ReservationHotel, String> endDateResa = new JFXTreeTableColumn<>("Date de départ");
		endDateResa.setPrefWidth(100);
		endDateResa.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.formatDate(param.getValue().getValue().getDateFin())));
		
		tableResaChambreClient.setRoot(root);
		tableResaChambreClient.setShowRoot(false);
		tableResaChambreClient.getColumns().setAll(reservationNumber,beginDateResa,endDateResa);

	}
	
	public void editClient(){
		/**
    	 * Recupere la fenetre
    	 */
    	BorderPane rootPane = Launcher.getRoot();
    	/**
    	 * Charge la vue client details
    	 */
    	FXMLLoader loaderClientEdit = new FXMLLoader(getClass().getResource("/src/Views/editClient.fxml"));
		AnchorPane editClient;
		try {
			editClient = loaderClientEdit.load();
			rootPane.setCenter(editClient);
	        EditClient controllerEditClient = loaderClientEdit.<EditClient>getController();
	        controllerEditClient.setClient(this.client);
	        controllerEditClient.setTitreLabel();
	        controllerEditClient.fieldContent();
	    } catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	

}
