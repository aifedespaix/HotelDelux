package src.Controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuMaintenance {
	
	public void openNewDemande() throws IOException
    {
		Parent root;
		
		try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("src/Views/newDemande.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Nouvelle demande de maintenance");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
