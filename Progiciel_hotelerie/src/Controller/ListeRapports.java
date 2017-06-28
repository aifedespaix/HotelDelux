package src.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import src.Launcher.Launcher;
import src.Metier.Criticite;
import src.Metier.DemandeIntervention;
import src.Metier.Etat;
import src.Metier.Rapport;
import src.Persistance.Maintenance.AccesDataListeRapports;
import src.Persistance.Maintenance.AccesDataMaintenance;
import src.util.Colors;
import src.util.generalFunctions;

public class ListeRapports implements Initializable {
	
	@FXML private JFXTreeTableView<Rapport> tableRapports;
	@FXML private JFXTextField champsObjet;
	@FXML private JFXTextField champsDemandeur;
	@FXML private JFXTextField champsTechnicien;
	@FXML private JFXDatePicker champsDateDebut;
	@FXML private JFXDatePicker champsDateArrivee;
	@FXML private JFXComboBox<String> champsService;
	@FXML private JFXComboBox<Etat> champsEtat;
	@FXML private JFXComboBox<Criticite> champsCriticite;
	
	private ObservableList<Rapport> listeRapports = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Charge la liste des rapports dans le tableau prévu à cet effet
		List<Rapport> liste = AccesDataListeRapports.getRapports();
		
		for (Rapport rapport : liste) {
			listeRapports.add(rapport);
		}
		
		final TreeItem<Rapport> root = new RecursiveTreeItem<Rapport>(listeRapports, RecursiveTreeObject::getChildren);	
		
		JFXTreeTableColumn<Rapport, JFXButton> voir = new JFXTreeTableColumn<>("Voir");
		voir.setPrefWidth(150);
		voir.setMinWidth(100);
		voir.setCellValueFactory(param -> new ObservableValue() {
				
				@Override
				public void addListener(InvalidationListener listener) { }

				@Override
				public void removeListener(InvalidationListener listener) { }

				@Override
				public void addListener(ChangeListener listener) { }

				@Override
				public Object getValue() {
					JFXButton bouton = new JFXButton("Visualiser");
					Colors.primary(bouton);
					bouton.setId(String.valueOf(param.getValue().getValue().getId()));
					
					bouton.setOnAction(new EventHandler<ActionEvent>() {
					    @Override public void handle(ActionEvent e) {
					    	BorderPane rootPane = Launcher.getRoot();
					    	FXMLLoader loaderRapportDetail = new FXMLLoader(getClass().getResource("/src/Views/rapportDetail.fxml"));
			       			AnchorPane rapportDetail;
							try {
								rapportDetail = loaderRapportDetail.load();
								rootPane.setCenter(rapportDetail);
						    	Rapport r = AccesDataListeRapports.getRapportById(Integer.parseInt(bouton.getId()));
						        RapportDetail controllerRapportDetail = loaderRapportDetail.<RapportDetail>getController();
						        controllerRapportDetail.setRapport(r);
						        controllerRapportDetail.update();
						    } catch (IOException e1) {
								e1.printStackTrace();
							}
					    }
					});
					return bouton;
				}

				@Override
				public void removeListener(ChangeListener listener) { }
		});
		
		//Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		JFXTreeTableColumn<Rapport, String> objet = new JFXTreeTableColumn<>("Objet");
		objet.setPrefWidth(150);
		objet.setMinWidth(100);
		objet.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeIntervention().getObjet()));
		
		JFXTreeTableColumn<Rapport, String> equipement = new JFXTreeTableColumn<>("Equipement");
		equipement.setPrefWidth(150);
		equipement.setMinWidth(100);
		equipement.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.getEquipementDemande(param.getValue().getValue().getDemandeIntervention())));
		
		JFXTreeTableColumn<Rapport, String> dateDebut = new JFXTreeTableColumn<>("Date Début");
		dateDebut.setPrefWidth(150);
		dateDebut.setMinWidth(100);
		dateDebut.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.formatDate(param.getValue().getValue().getDateDebut())));
		
		JFXTreeTableColumn<Rapport, String> dateFin = new JFXTreeTableColumn<>("Date Fin");
		dateFin.setPrefWidth(150);
		dateFin.setMinWidth(100);
		dateFin.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.formatDate(param.getValue().getValue().getDateFin())));
		
		JFXTreeTableColumn<Rapport, String> demandeur = new JFXTreeTableColumn<>("Demandeur");
		demandeur.setPrefWidth(150);
		demandeur.setMinWidth(100);
		demandeur.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeIntervention().getDemandeurById().toString()));
		
		JFXTreeTableColumn<Rapport, String> service = new JFXTreeTableColumn<>("Service");
		service.setPrefWidth(150);
		service.setMinWidth(100);
		service.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.getServiceDemande(param.getValue().getValue().getDemandeIntervention())));
		
		JFXTreeTableColumn<Rapport, String> technicien = new JFXTreeTableColumn<>("Technicien");
		technicien.setPrefWidth(150);
		technicien.setMinWidth(100);
		technicien.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getTechnicien() != null ? param.getValue().getValue().getTechnicien().toString() : "Non affecté"));
		
		JFXTreeTableColumn<Rapport, String> etat = new JFXTreeTableColumn<>("Etat");
		etat.setPrefWidth(150);
		etat.setMinWidth(100);
		etat.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeIntervention().getEtat().getLibelle()));
		
		JFXTreeTableColumn<Rapport, String> criticite = new JFXTreeTableColumn<>("Criticté");
		criticite.setPrefWidth(150);
		criticite.setMinWidth(100);
		criticite.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeIntervention().getCriticiteByIdCriticite().getLibelle()));
		
		tableRapports.setRoot(root);
		tableRapports.setShowRoot(false);
		
		tableRapports.getColumns().setAll(voir, objet, equipement, dateDebut, dateFin, demandeur, service, technicien, etat, criticite);
		
		// Charge les diff�rents services
		champsService.getItems().add("Hôtel");
		champsService.getItems().add("Jardin");
		champsService.getItems().add("Restaurant");
		champsService.getItems().add("Spa");
		
		// Charge les états pour le filtre
		champsEtat.getItems().addAll(AccesDataMaintenance.getListeEtat());
		
		// Charge les criticités pour le filtre
		champsCriticite.getItems().addAll(AccesDataMaintenance.getListeCriticite());
	}
	
	/**
	 * Fonction appel� lors de l'appui sur le bouton de recherche. Permet de filtrer les r�sultats de la liste
	 */
	public void search(){
		// Nettoie le tableau
		listeRapports.clear();
		// Recrée une nouvelle liste pour stocker les demandes
		/*
		String date = champsDate.getValue() != null ? champsDate.getValue().toString() : "";
		String etat = champsEtat.getValue() != null ? String.valueOf(champsEtat.getValue().getId()) : "";
		String criticite = champsCriticite.getValue() != null ? String.valueOf(champsCriticite.getValue().getId()) : "";
		
		// Récupération du service et appel de la fonction en conséquence
		String service = champsService.getValue();
		
		List<DemandeIntervention> liste = AccesDataListeDemandes.getRequeteFiltre(champsObjet.getText(), champsDemandeur.getText(),
				date, champsService.getValue(), etat, criticite);
		
		listeRapports.addAll(liste);*/
	}
	
}
