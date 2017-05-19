package src.Controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.Metier.Utilisateur;
import src.Persistance.AccesData;
import util.generalFunctions;

/**
 * Created by ledze on 12/05/2017.
 */
public class Login
{
    private final static int DIRECTEUR = 5;
    private final static int RESTAURANT= 6;
    @FXML
   private JFXTextField login;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton btn_login;
    public void connexion() throws IOException
    {
        Utilisateur u = null;
        u = AccesData.getLoginUtilisateur(login.getText(), password.getText());
        if(u != null)
        {
        	Stage primaryStage = (Stage) password.getScene().getWindow();
           switch (u.getRoleByIdRole().getId())
           {
               case DIRECTEUR:
                //  Appel de la vue
                   System.out.println("case 5");
                   break;
               case RESTAURANT:
                   //  Appel de la vue
                   System.out.println("case 6");
                   break;
               default:
                   System.out.println("default");
                   Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/src/Views/login.fxml")));
                   primaryStage.setScene(scene);
                   primaryStage.show();
           }
        }
        else
        {
            System.out.println("Echec");
        }

    }
}
