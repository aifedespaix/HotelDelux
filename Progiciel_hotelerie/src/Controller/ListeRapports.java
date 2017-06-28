package src.Controller;

import com.jfoenix.controls.*;
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
import src.Metier.Etat;
import src.Metier.Rapport;
import src.Persistance.Maintenance.AccesDataListeRapports;
import src.Persistance.Maintenance.AccesDataMaintenance;
import src.util.Colors;
import src.util.generalFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
		// Charge la liste des rapports dans le tableau pr�vu � cet effet
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
		
		//Cr�� la colonne en la nommant, d�finie sa taille par d�fault puis Ajoute une valeur � la ligne (boucle sur la liste d'observables
		JFXTreeTableColumn<Rapport, String> objet = new JFXTreeTableColumn<>("Objet");
		objet.setPrefWidth(150);
		objet.setMinWidth(100);
		objet.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeInterventionByIdDemandeIntervention().getObjet()));
		
		JFXTreeTableColumn<Rapport, String> equipement = new JFXTreeTableColumn<>("Equipement");
		equipement.setPrefWidth(150);
		equipement.setMinWidth(100);
		equipement.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.getEquipementDemande(param.getValue().getValue().getDemandeInterventionByIdDemandeIntervention())));
		
		JFXTreeTableColumn<Rapport, String> dateDebut = new JFXTreeTableColumn<>("Date D�but");
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
		demandeur.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeInterventionByIdDemandeIntervention().getDemandeurById().toString()));
		
		JFXTreeTableColumn<Rapport, String> service = new JFXTreeTableColumn<>("Service");
		service.setPrefWidth(150);
		service.setMinWidth(100);
		service.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.getServiceDemande(param.getValue().getValue().getDemandeInterventionByIdDemandeIntervention())));
		
		JFXTreeTableColumn<Rapport, String> technicien = new JFXTreeTableColumn<>("Technicien");
		technicien.setPrefWidth(150);
		technicien.setMinWidth(100);
		technicien.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getTechnicien() != null ? param.getValue().getValue().getTechnicien().toString() : "Non affect�"));
		
		JFXTreeTableColumn<Rapport, String> etat = new JFXTreeTableColumn<>("Etat");
		etat.setPrefWidth(150);
		etat.setMinWidth(100);
		etat.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeInterventionByIdDemandeIntervention().getEtat().getLibelle()));
		
		JFXTreeTableColumn<Rapport, String> criticite = new JFXTreeTableColumn<>("Critict�");
		criticite.setPrefWidth(150);
		criticite.setMinWidth(100);
		criticite.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeInterventionByIdDemandeIntervention().getCriticiteByIdCriticite().getLibelle()));
		
		tableRapports.setRoot(root);
		tableRapports.setShowRoot(false);
		
		tableRapports.getColumns().setAll(voir, objet, equipement, dateDebut, dateFin, demandeur, service, technicien, etat, criticite);
		
		// Charge les diff�rents services
		champsService.getItems().add("H�tel");
		champsService.getItems().add("Jardin");
		champsService.getItems().add("Restaurant");
		champsService.getItems().add("Spa");
		
		// Charge les �tats pour le filtre
		champsEtat.getItems().addAll(AccesDataMaintenance.getListeEtat());
		
		// Charge les criticit�s pour le filtre
		champsCriticite.getItems().addAll(AccesDataMaintenance.getListeCriticite());
	}
	
	/**
	 * Fonction appel� lors de l'appui sur le bouton de recherche. Permet de filtrer les r�sultats de la liste
	 */
	public void search(){
		// Nettoie le tableau
		listeRapports.clear();
		// Recr�e une nouvelle liste pour stocker les demandes
		/*
		String date = champsDate.getValue() != null ? champsDate.getValue().toString() : "";
		String etat = champsEtat.getValue() != null ? String.valueOf(champsEtat.getValue().getId()) : "";
		String criticite = champsCriticite.getValue() != null ? String.valueOf(champsCriticite.getValue().getId()) : "";
		
		// R�cup�ration du service et appel de la fonction en cons�quence
		String service = champsService.getValue();
		
		List<DemandeIntervention> liste = AccesDataListeDemandes.getRequeteFiltre(champsObjet.getText(), champsDemandeur.getText(),
				date, champsService.getValue(), etat, criticite);
		
		listeRapports.addAll(liste);*/
	}
	
}
