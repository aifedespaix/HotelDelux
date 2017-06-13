package src.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

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

public class NewClient implements Initializable {
	
	@FXML private JFXTextField txtNom;
	@FXML private JFXTextField txtPrenom;
	@FXML private JFXTextField txtPhone;
	@FXML private JFXTextField txtAdress;
	@FXML private JFXTextField txtCity;
	@FXML private JFXDatePicker dateBirth;
	@FXML private JFXTextField txtCp;
	@FXML private JFXTextField txtCountry;
	@FXML private JFXTextArea txtComplementaire;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void save(){
		String nom = txtNom.getText();
		String prenom = txtPrenom.getText();
		String phone = txtPhone.getText();
		String address = txtAdress.getText();
		String city = txtCity.getText();
		
		LocalDate birth = dateBirth.getValue();
		Date date = Date.valueOf(birth);
		
		String cp = txtCp.getText();
		String country = txtCountry.getText();
		String complementaire = txtComplementaire.getText();
		
		
		Client c = new Client(nom,prenom,address,city,cp,phone,date,complementaire);
		if(AccesData.ajouterModifierClient(c)){
			System.out.println("insertion client réussie");
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
		} else {
			System.out.println("insertion client échouée");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
