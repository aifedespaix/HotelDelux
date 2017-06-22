package src.Controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import src.Launcher.Launcher;
import src.Metier.Client;
import src.Persistance.AccesData;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class EditClient implements Initializable {

	@FXML private JFXTextField txtNom;
	@FXML private JFXTextField txtPrenom;
	@FXML private JFXTextField txtPhone;
	@FXML private JFXTextField txtAdress;
	@FXML private JFXTextField txtCity;
	@FXML private JFXDatePicker dateBirth;
	@FXML private JFXTextField txtCp;
	@FXML private JFXTextField txtCountry;
	@FXML private JFXTextArea txtComplementaire;

	private Client client = new Client();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

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
		txtCountry.setText("");
		txtComplementaire.setText(this.client.getAllergies());
	}

	public void cancel(){
		BorderPane root = Launcher.getRoot();
		FXMLLoader loaderHebergementClients = new FXMLLoader(getClass().getResource("/src/Views/hebergementClients.fxml"));
		AnchorPane hebergementClients;
		try {
			hebergementClients = loaderHebergementClients.load();
			root.setCenter(hebergementClients);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	}
}
