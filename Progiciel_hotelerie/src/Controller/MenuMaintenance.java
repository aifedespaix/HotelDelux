package src.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.Launcher.Launcher;

public class MenuMaintenance {
	
	private BorderPane root = Launcher.getRoot();
	
	public void openListeDemandes() throws IOException {	
		System.out.println("chargement liste demandes");
		
		try {
			FXMLLoader loaderListeDemandes = new FXMLLoader(getClass().getResource("/src/Views/listeDemandes.fxml"));
			AnchorPane menuMaintenance;
			menuMaintenance = loaderListeDemandes.load();
			root.setCenter(menuMaintenance);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void openNewDemande() throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/Views/newDemande.fxml"));
		openWindowNewDemande(root);
	}
	
	public static void openWindowNewDemande(Parent root) throws IOException
    {
        Stage stage = new Stage();
        stage.setTitle("Nouvelle demande de maintenance");
        stage.setScene(new Scene(root,800, 700));
        stage.show();
        
    }

}
