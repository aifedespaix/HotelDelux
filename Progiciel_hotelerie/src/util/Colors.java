package src.util;

import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

public class Colors {

//    public static Background primary() {
//        return
//    }

    public static void primary(JFXButton b) {
        b.setBackground(new Background(new BackgroundFill(Paint.valueOf("#337ab7"),null, null)));
        b.setStyle("-fx-text-fill:#fff");
        b.setStyle("-fx-cursor: hand");
    }

}
