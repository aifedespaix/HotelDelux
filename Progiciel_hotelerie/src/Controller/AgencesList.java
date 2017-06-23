package src.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import src.Metier.Agence;
import src.Persistance.AccesData;

public class AgencesList implements Initializable{
	@FXML private GridPane gridAgences;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		List<Agence> listeA = AccesData.getAgences();
		for(int i = 0 ; i < 3; i++){
			for(int j = 0; j < 3 ; j++){
				Pane pane = new Pane();				
				Text nom = new Text(10,10,listeA.get(i + j).getNom());				
				Text telephone = new Text(10,30,String.valueOf(listeA.get(i + j).getTelephone()));				
				Text email = new Text(10,50,listeA.get(i + j).getEmail());
				
				pane.getChildren().addAll(nom,telephone,email);
				gridAgences.add(pane, j, i);
				
				
				gridAgences.setMinWidth(200);
				gridAgences.setMinHeight(200);
//				gridAgences.add(nom, j, i);
//				gridAgences.add(telephone, j, i);
//				gridAgences.add(email, j, i);
				
			}
		}
	}

}
