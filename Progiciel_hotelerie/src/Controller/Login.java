package src.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.Launcher.Launcher;
import src.Metier.Utilisateur;
import src.Persistance.AccesData;

import java.awt.*;
import java.io.IOException;

/**
 * Created by ledze on 12/05/2017.
 */
public class Login {

    private static Utilisateur user;

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

    public void connexion() throws IOException {
        Utilisateur u = null;
        u = AccesData.getLoginUtilisateur(login.getText(), password.getText());
        if (u != null) {
            Stage primaryStage = (Stage) password.getScene().getWindow();
            primaryStage.setMaximized(true);

            root.prefHeightProperty().bind(primaryStage.heightProperty());
            root.prefWidthProperty().bind(primaryStage.widthProperty());

            Login.user = u;

            switch (u.getRoleByIdRole().getId()) {
                case 1:
                    System.out.println("Admin");
                    FXMLLoader loaderAdmin = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuAdministration.fxml"));
                    AnchorPane menuAdmin = loaderAdmin.load();

                    root.setTop(menuAdmin);
                    root.setCenter(null);
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
                    FXMLLoader loaderListeReservations = new FXMLLoader(getClass().getResource("/src/Views/reservationsList.fxml"));
                    AnchorPane listeReservations = loaderListeReservations.load();
                    root.setCenter(listeReservations);
                    break;
                case 4:
                    System.out.println("Réception");
                    FXMLLoader loaderReception = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuReception.fxml"));
                    AnchorPane menuReception = loaderReception.load();
                    root.setTop(menuReception);
                    root.setCenter(null);
                    break;
                case 5:
                    System.out.println("Restaurant");
                    FXMLLoader loaderRestaurant = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuRestaurant.fxml"));
                    AnchorPane menuRestaurant = loaderRestaurant.load();
                    root.setTop(menuRestaurant);
                    root.setCenter(null);
                    break;
                case 6:
                    System.out.println("Spa");
                    FXMLLoader loaderSpa = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuSpa.fxml"));
                    AnchorPane menuSpa = loaderSpa.load();
                    root.setTop(menuSpa);
                    root.setCenter(null);
                    break;
                case 7:
                    System.out.println("Maintenance");
                    FXMLLoader loaderMenuMaintenance = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuMaintenance.fxml"));
                    AnchorPane menuMaintenance = loaderMenuMaintenance.load();
                    root.setTop(menuMaintenance);
                    FXMLLoader loaderListeDemandes = new FXMLLoader(getClass().getResource("/src/Views/listeDemandes.fxml"));
                    AnchorPane listeDemandes = loaderListeDemandes.load();
                    root.setCenter(listeDemandes);
                    break;
                case 8:
                    System.out.println("Entretien");
                    FXMLLoader loaderEntretien = new FXMLLoader(getClass().getResource("/src/ViewsMenu/menuEntretien.fxml"));
                    AnchorPane menuEntretien = loaderEntretien.load();
                    root.setTop(menuEntretien);
                    root.setCenter(null);
                    break;
                default:
                    System.out.println("default");
            }
        } else {
            System.out.println("Echec");
            // Efface les champs et remet le curseur sur le champs du login
            login.setText("");
            password.setText("");
            login.requestFocus();
        }

    }

    /**
     * @return String le login de connexion de l'utilisateur connecté
     */
    public static String getUsername() {
        return user.getNom();
    }
    
    /**
     * @return {@link Utilisateur} l'utilisateur connecté
     */
    public static Utilisateur getConnectedUser() {
    	return user;
    }

}
