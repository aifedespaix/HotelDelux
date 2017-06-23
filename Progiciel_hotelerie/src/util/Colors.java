package src.util;

import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

public class Colors {

    public static String SERVICE_HEBERGEMENT = "Hebergement.png";

    public static void primary(JFXButton b) {
        b.setBackground(new Background(new BackgroundFill(Paint.valueOf("#337ab7"), null, null)));
        addCursorHand(b);
        b.setTextFill(Paint.valueOf("#fff"));
    }

    public static void menu_btnAccueil(JFXButton b, String service) {
        addCursorHand(b);
        b.getStyleClass().add("background-image");
//        String imagepath = "../image/icons/src/image/icons/Hebergement.png";
//        b.setStyle("-fx-background-image: url(/src/image/icons/"+service+")");
//        b.setStyle("-fx-background-image:  url(/Progiciel_hotelerie/src/image/icons/Hebergement.png)");
//        b.setStyle("-fx-background-color: red");

    }

    private static void addCursorHand(JFXButton b) {
        b.setStyle("-fx-cursor: hand");
    }

}
