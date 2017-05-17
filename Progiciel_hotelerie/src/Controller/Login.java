package src.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import src.Metier.Utilisateur;
import src.Persistance.AccesData;

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
    public void connexion()
    {
        Utilisateur u = null;
        u = AccesData.getLoginUtilisateur(login.getText(), password.getText());
        if(u != null)
        {
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
                   break;
           }
        }
        else
        {
            System.out.println("échec");
        }

    }
}
