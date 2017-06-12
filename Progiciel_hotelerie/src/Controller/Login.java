package src.Controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import src.Launcher.Launcher;
import src.Metier.Utilisateur;
import src.Persistance.AccesData;
import util.generalFunctions;

/**
 * Created by ledze on 12/05/2017.
 */
public class Login
{
    @FXML
   private JFXTextField login;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton btn_login;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   	double width = screenSize.getWidth();
   	double height = screenSize.getHeight();
   	BorderPane root = Launcher.getRoot();
    
    public void connexion() throws IOException
    {
    	Stage primaryStage = (Stage) password.getScene().getWindow();
    	primaryStage.setMaximized(true);
    	
    	root.prefHeightProperty().bind(primaryStage.heightProperty());
        root.prefWidthProperty().bind(primaryStage.widthProperty());
        
        
        Utilisateur u = null;
        u = AccesData.getLoginUtilisateur(login.getText(), password.getText());
        if(u != null)
        {
           switch (u.getRoleByIdRole().getId())
           {
               case 1:
                //  Appel de la vue
                   System.out.println("admin");
                   break;
               case 2:
                   //  Appel de la vue
                    System.out.println("direction");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuDirecteur.fxml"));
	       			AnchorPane menu = loader.load();
	       			menu.setMaxWidth(width);
	       			root.setTop(menu);
                   break;
               case 3:
                   //  Appel de la vue
                    System.out.println("Hebergement");
                    FXMLLoader loaderHebergement = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuHebergement.fxml"));
	       			AnchorPane menuHebergement = loaderHebergement.load();
	       			menuHebergement.setMaxWidth(width);
	       			root.setTop(menuHebergement);
	       			
	       			
	       			FXMLLoader loaderHebergementClients = new FXMLLoader(getClass().getResource("/src/Views/hebergementClients.fxml"));
	       			AnchorPane menuHebergementClients = loaderHebergementClients.load();
	       			menuHebergementClients.setMaxWidth(width);
	       			root.setCenter(menuHebergementClients);
	       			
	       			
                   break;
               case 4:
                   //  Appel de la vue
                   System.out.println("Maintenance");
                   FXMLLoader loaderMaintenance = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuMaintenance.fxml"));
	       			AnchorPane menuMaintenance = loaderMaintenance.load();
	       			menuMaintenance.setMaxWidth(width);
	       			root.setTop(menuMaintenance);
                   break;
               case 5:
                   //  Appel de la vue
                   System.out.println("Restaurant");
                   FXMLLoader loaderRestaurant = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuRestaurant.fxml"));
	       			AnchorPane menuRestaurant = loaderRestaurant.load();
	       			menuRestaurant.setMaxWidth(width);
	       			root.setTop(menuRestaurant);
                   break;
               case 6:
                   //  Appel de la vue
                   System.out.println("Responsable Spa");
                   FXMLLoader loaderSpa = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuSpa.fxml"));
	       			AnchorPane menuSpa = loaderSpa.load();
	       			menuSpa.setMaxWidth(width);
	       			root.setTop(menuSpa);
                   break;
               case 7:
                   //  Appel de la vue
                   System.out.println("maintenance");
                   break;
               case 8:
                   //  Appel de la vue
                   System.out.println("cuisine");
                   break;
               default:
                   	System.out.println("default");
                   	                   
//                   Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/src/Views/login.fxml")));
//                   primaryStage.setScene(scene);
//                   primaryStage.show();
           }
        }
        else
        {
            System.out.println("Echec");
        }

    }
}
