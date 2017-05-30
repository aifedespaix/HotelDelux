package src.Launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/src/Views/login.fxml"));
			Parent content = loader.load();
			root.setTop(content);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		//Utilisateur u = new Utilisateur(1,"bb","aa");
		//System.out.println(AccesData.getLoginUtilisateur(u.getLogin(), u.getMdp()));
	}
}
