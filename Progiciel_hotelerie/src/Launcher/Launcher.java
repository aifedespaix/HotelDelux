package src.Launcher;
	
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import src.Persistance.AccesData;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Launcher extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/src/Views/menu.fxml"));
			loader.setLocation(getClass().getResource("/src/Views/login.fxml"));
			Parent content = loader.load();
			root.setTop(content);
			primaryStage.show();
			//final String dir = System.getProperty("user.dir");
			///String chemin = AccesData.getEquipementHotel(1).getPhoto();
	        //System.out.println("current dir = " + dir + File.separator + "src" + File.separator + chemin);
//	        Path path = Paths.get(dir + File.separator + "src" + File.separator + chemin);
//	        System.out.println(path.getFileName());
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
