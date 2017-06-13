package src.Controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import src.Launcher.Launcher;

public class MenuHebergement {
	
	@FXML private JFXButton btnClient;
	BorderPane root = Launcher.getRoot();
	
	
	
	public void accessToClient(){
		FXMLLoader loaderHebergementClients = new FXMLLoader(getClass().getResource("/src/Views/hebergementClients.fxml"));
			AnchorPane menuHebergementClients;
			try {
				menuHebergementClients = loaderHebergementClients.load();
				root.setCenter(menuHebergementClients);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
}
