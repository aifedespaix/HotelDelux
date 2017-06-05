package src.Launcher;
	
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import src.Persistance.AccesData;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


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
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/Views/menu.fxml"));
//			AnchorPane menu = loader.load();
//			root.setTop(menu);
			
			
			//FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/src/Views/login.fxml"));
			URL login = getClass().getResource("/src/Views/login.fxml");
			AnchorPane login2 = FXMLLoader.load(login);
			root.setCenter(login2);
			
			
	        
			Scene scene = new Scene(root,640,480);			
			primaryStage.setScene(scene);
			primaryStage.show();
//			loader.setLocation(getClass().getResource("/src/Views/login.fxml"));
//			Parent content = loader.load();
//			root.setTop(content);
//			primaryStage.show();
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
