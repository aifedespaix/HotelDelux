package src.Launcher;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.Persistance.AccesData;

import java.net.URL;


public class Launcher extends Application {
	/**
	 * Declaration du border Pan principale.
	 */
	private static BorderPane root = new BorderPane();
	
	public static BorderPane getRoot() {
	    return root;
	  }
	
	public void start(Stage primaryStage) {
		try {

			URL login = getClass().getResource("/src/Views/login.fxml");
			AnchorPane login2 = FXMLLoader.load(login);
			root.setCenter(login2);
	        
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
