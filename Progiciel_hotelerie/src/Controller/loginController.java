package Controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import Metier.Utilisateur;
import Persistance.AccesData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class loginController implements Initializable{
	@FXML private TextField username;
	@FXML private TextField password;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void Connect(ActionEvent event){
		if(AccesData.getLoginUtilisateur(username.getText(), password.getText()) != null){
			System.out.println("connecté");
		} else {
			System.out.println("échec");
		}
	}
}
