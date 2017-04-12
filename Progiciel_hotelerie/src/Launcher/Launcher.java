package Launcher;
	
import Metier.Utilisateur;
import Persistance.AccesData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Launcher extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/Views/Login.fxml"));
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
