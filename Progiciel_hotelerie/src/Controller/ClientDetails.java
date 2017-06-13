package src.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import src.Metier.Client;

public class ClientDetails implements Initializable {
	Client client = new Client();
	@FXML private JFXTextField txtName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setClient(Client client){
	    this.client = client;
	}
	public void update(){
		txtName.setText(this.client.getNom());
	}
	

}
