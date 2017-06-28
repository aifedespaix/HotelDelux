package src.Controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.Launcher.Launcher;
import src.Metier.Client;
import src.Persistance.AccesData;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class EditClient implements Initializable {

	@FXML private Text titreLabel;
	@FXML private JFXTextField txtNom;
	@FXML private JFXTextField txtPrenom;
	@FXML private JFXTextField txtPhone;
	@FXML private JFXTextField txtAdress;
	@FXML private JFXTextField txtCity;
	@FXML private JFXDatePicker dateBirth;
	@FXML private JFXTextField txtCp;
	@FXML private JFXTextArea txtComplementaire;
	
	Client client;

	@Override
	public void initialize(URL location, ResourceBundle resources) { }
	public void setClient(Client client){
	    this.client = client;
	}

	public void fieldContent(){
		txtNom.setText(this.client.getNom());
		txtPrenom.setText(this.client.getPrenom());
		txtPhone.setText(this.client.getTelephone());
		txtAdress.setText(this.client.getAdresseRue());
		txtCity.setText(this.client.getAdresseVille());
		dateBirth.setValue(this.client.getDateNaissance().toLocalDate());
		txtCp.setText(this.client.getCodePostal());
		txtComplementaire.setText(this.client.getAllergies());
	}
	
	/**
	 * Change le titre de la page en fonction de si c'est une �dition ou une cr�ation de client
	 */
	public void setTitreLabel() {
		if (client == null) {
			titreLabel.setText("Nouveau client");
			client = new Client();
		} else {
			titreLabel.setText("Edition du client " + client.getPrenom() + " " + client.getNom());
			// Il a déjà été setté au moment de la création de la vue.
		}
	}

	public void cancel(){
		BorderPane root = Launcher.getRoot();
		FXMLLoader loaderHebergementClients = new FXMLLoader(getClass().getResource("/src/Views/hebergementClients.fxml"));
		AnchorPane hebergementClients;
		try {
			hebergementClients = loaderHebergementClients.load();
			root.setCenter(hebergementClients);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveClientEdit(){
		this.client.setNom(txtNom.getText());
		this.client.setPrenom(txtPrenom.getText());
		this.client.setTelephone(txtPhone.getText());
		this.client.setAdresseRue(txtAdress.getText());
		this.client.setAdresseVille(txtCity.getText());
		this.client.setDateNaissance(Date.valueOf(dateBirth.getValue()));
		this.client.setCodePostal(txtCp.getText());
		this.client.setAllergies(txtComplementaire.getText());

		AccesData.ajouterModifierClient(this.client);
		
		// On affiche la vue détail du client qui vient d'être créé
		BorderPane rootPane = Launcher.getRoot();
    	FXMLLoader loaderClientDetails = new FXMLLoader(getClass().getResource("/src/Views/clientDetails.fxml"));
		AnchorPane clientDetails;
		try {
			clientDetails = loaderClientDetails.load();
			rootPane.setCenter(clientDetails);
	        ClientDetails controllerClient = loaderClientDetails.<ClientDetails>getController();
	        controllerClient.setClient(client);
	        controllerClient.update();
	    } catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
