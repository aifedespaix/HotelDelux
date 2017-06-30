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
import src.Metier.DemandeIntervention;
import src.Metier.Etat;
import src.Persistance.Maintenance.AccesDataListeDemandes;
import src.Persistance.Maintenance.AccesDataMaintenance;
import src.util.Colors;
import src.util.generalFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListeDemandes implements Initializable {
	
	@FXML private JFXTreeTableView<DemandeIntervention> tableDemandes;
	@FXML private JFXTextField champsObjet;
	@FXML private JFXTextField champsDemandeur;
	@FXML private JFXDatePicker champsDate;
	@FXML private JFXComboBox<String> champsService;
	@FXML private JFXComboBox<Etat> champsEtat;
	@FXML private JFXComboBox<Criticite> champsCriticite;
	
	private ObservableList<DemandeIntervention> listeDemandes = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Charge la liste des demandes dans le tableau prévu à cet effet
		List<DemandeIntervention> liste = AccesDataListeDemandes.getDemandeInterventions();
		
		for (DemandeIntervention demande : liste) {
			listeDemandes.add(demande);
		}
		
		final TreeItem<DemandeIntervention> root = new RecursiveTreeItem<DemandeIntervention>(listeDemandes, RecursiveTreeObject::getChildren);	
		JFXTreeTableColumn<DemandeIntervention, JFXButton> voir = new JFXTreeTableColumn<>("Voir");
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
					    	FXMLLoader loaderDemandeDetail = new FXMLLoader(getClass().getResource("/src/Views/demandeDetail.fxml"));
			       			AnchorPane demandeDetail;
							try {
								demandeDetail = loaderDemandeDetail.load();
								rootPane.setCenter(demandeDetail);
						    	DemandeIntervention d = AccesDataListeDemandes.getDemandeById(Integer.parseInt(bouton.getId()));
						        DemandeDetail controllerDemandeDetail = loaderDemandeDetail.<DemandeDetail>getController();
						        controllerDemandeDetail.setDemande(d);
						        controllerDemandeDetail.update();
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
		JFXTreeTableColumn<DemandeIntervention, String> objet = new JFXTreeTableColumn<>("Objet");
		objet.setPrefWidth(150);
		objet.setMinWidth(100);
		objet.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getObjet()));
		
		JFXTreeTableColumn<DemandeIntervention, String> equipement = new JFXTreeTableColumn<>("Equipement");
		equipement.setPrefWidth(150);
		equipement.setMinWidth(100);
		equipement.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.getEquipementDemande(param.getValue().getValue())));
		
		JFXTreeTableColumn<DemandeIntervention, String> date = new JFXTreeTableColumn<>("Date Cration");
		date.setPrefWidth(150);
		date.setMinWidth(100);
		date.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.formatDate(param.getValue().getValue().getDateCreation())));
		
		JFXTreeTableColumn<DemandeIntervention, String> demandeur = new JFXTreeTableColumn<>("Demandeur");
		demandeur.setPrefWidth(150);
		demandeur.setMinWidth(100);
		demandeur.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDemandeurById().toString()));
		
		JFXTreeTableColumn<DemandeIntervention, String> service = new JFXTreeTableColumn<>("Service");
		service.setPrefWidth(150);
		service.setMinWidth(100);
		service.setCellValueFactory(param -> new SimpleStringProperty(generalFunctions.getServiceDemande(param.getValue().getValue())));
		
		JFXTreeTableColumn<DemandeIntervention, String> etat = new JFXTreeTableColumn<>("Etat");
		etat.setPrefWidth(150);
		etat.setMinWidth(100);
		etat.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getEtat().getLibelle()));
		
		JFXTreeTableColumn<DemandeIntervention, String> criticite = new JFXTreeTableColumn<>("Criticté");
		criticite.setPrefWidth(150);
		criticite.setMinWidth(100);
		criticite.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCriticiteByIdCriticite().getLibelle()));

		tableDemandes.setRoot(root);
		tableDemandes.setShowRoot(false);
		
		tableDemandes.getColumns().setAll(voir, objet, equipement, date, demandeur, service, etat, criticite);
		
		// Charge les différents services
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
		listeDemandes.clear();
		// Recr�e une nouvelle liste pour stocker les demandes
		String date = champsDate.getValue() != null ? champsDate.getValue().toString() : "";
		String etat = champsEtat.getValue() != null ? String.valueOf(champsEtat.getValue().getId()) : "";
		String criticite = champsCriticite.getValue() != null ? String.valueOf(champsCriticite.getValue().getId()) : "";
		
		// Récupération du service et appel de la fonction en conséquence
		String service = champsService.getValue();
		
		List<DemandeIntervention> liste = AccesDataListeDemandes.getRequeteFiltre(champsObjet.getText(), champsDemandeur.getText(),
				date, champsService.getValue(), etat, criticite);
		
		listeDemandes.addAll(liste);
	}
	
}
