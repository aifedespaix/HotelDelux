package src.Controller;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
                   System.out.println("Admin");
                   break;
               case 2:
                    System.out.println("Direction");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuDirecteur.fxml"));
	       			AnchorPane menu = loader.load();
	       			root.setTop(menu);
	       			root.setCenter(null);
                   break;
               case 3:
                    System.out.println("Hebergement");
                    FXMLLoader loaderHebergement = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuHebergement.fxml"));
	       			AnchorPane menuHebergement = loaderHebergement.load();
	       			root.setTop(menuHebergement);
	       			
//	       			FXMLLoader loaderClientNew = new FXMLLoader(getClass().getResource("/src/Views/newClient.fxml"));
//	       			AnchorPane newClient = loaderClientNew.load();
//	       			root.setCenter(newClient);
                   break;
               case 4:
                   System.out.println("Réception");
                   FXMLLoader loaderReception = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuReception.fxml"));
	       		   AnchorPane menuReception = loaderReception.load();
	       		   root.setTop(menuReception);
	       		   break;
               case 5:
            	   System.out.println("Restaurant");
                   FXMLLoader loaderRestaurant = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuRestaurant.fxml"));
	       		   AnchorPane menuRestaurant = loaderRestaurant.load();
	       		   root.setTop(menuRestaurant);
                   break;
               case 6:
                   System.out.println("Spa");
                   FXMLLoader loaderSpa = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuSpa.fxml"));
	       			AnchorPane menuSpa = loaderSpa.load();
	       			root.setTop(menuSpa);
                   break;
               case 7:
                   System.out.println("Maintenance");
                   FXMLLoader loaderMaintenance = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuMaintenance.fxml"));
	       		   AnchorPane menuMaintenance = loaderMaintenance.load();
	       		   root.setTop(menuMaintenance);
                   break;
               case 8:
            	   System.out.println("Entretien");
            	   FXMLLoader loaderEntretien = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuEntretien.fxml"));
	       		   AnchorPane menuEntretien = loaderEntretien.load();
	       		   root.setTop(menuEntretien);
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
