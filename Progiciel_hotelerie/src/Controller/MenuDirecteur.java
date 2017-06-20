package src.Controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MenuDirecteur {
	
	/**
	 * Appelle la fonction dans le menu maintenance qui permet d'ouvrir la fenêtre de nouvelle demande
	 * @throws IOException
	 */
	public void openNewDemande() throws IOException
    {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/Views/newDemande.fxml"));
		MenuMaintenance.openWindowNewDemande(root);
    }

}
