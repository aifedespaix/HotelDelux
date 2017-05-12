package src.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import src.Metier.UtilisateurEntity;
import src.Persistance.AccesData;

/**
 * Created by ledze on 12/05/2017.
 */
public class Login
{
    @FXML
   private JFXTextField login;
    @FXML
    private JFXPasswordField password;
    public void connexion()
    {
        UtilisateurEntity u = null;
        u = AccesData.getLoginUtilisateur(login.getText(), password.getText());
        if(u != null)
        {
            System.out.println("connexion");
        }
        else
        {
            System.out.println("échec");
        }

    }
}
