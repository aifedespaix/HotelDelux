package src.Controller;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.cfg.Configuration;
import javafx.fxml.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.base.JFXTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.application.Application.Parameters;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import src.Launcher.Launcher;
import src.Metier.Client;
import src.Persistance.AccesData;

public class HebergementClients implements Initializable {
	
	/**
	 * Déclaration des objets présents dans la vue pour y ajouter des événements
	 */
	@FXML private AnchorPane hebergementClientPane;
	@FXML private JFXTreeTableView<Client> tableHebergementClient;
	@FXML private JFXTreeTableColumn<Client, String> nom;
	@FXML private JFXTextField txtName;
	@FXML private JFXTextField txtPrenom;
	@FXML private JFXTextField txtAdresse;
	@FXML private JFXTextField txtPhone;
	@SuppressWarnings(value = { "" })
	/**
	 * Déclaration de la liste d'observables qui contiendra les objets a afficher dans le tableau
	 */
	private ObservableList<Client> listeClients = FXCollections.observableArrayList();

	@SuppressWarnings({ "unchecked", "unchecked", "unchecked", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/**
		 * Récupère la liste de tous les clients		
		 */
		List<Client> listec = AccesData.getClients();
		
		/**
		 * Ajoute chaque client récupéré à la liste d'observable de clients
		 */
		for(Client c : listec){
			listeClients.add(c);
		}
		
		/**
		 * Créé l'arbre d'objets avec la liste d'observables de clients
		 */
		final TreeItem<Client> root = new RecursiveTreeItem<Client>(listeClients, RecursiveTreeObject::getChildren);	
		

		JFXTreeTableColumn<Client, JFXButton> voir = new JFXTreeTableColumn<>("Voir");
		voir.setPrefWidth(100);
		
		voir.setCellValueFactory(param -> new ObservableValue() {
				
				@Override
				public void addListener(InvalidationListener listener) {
					// TODO Auto-generated method stub
				}

				@Override
				public void removeListener(InvalidationListener listener) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void addListener(ChangeListener listener) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public Object getValue() {
					// TODO Auto-generated method stub
					JFXButton bouton = new JFXButton("Visualiser");
					
					/**
					 * Id pour recupere le client correspondant a la ligne
					 */
					bouton.setId(String.valueOf(param.getValue().getValue().getId()));
					
					/**
					 * Gere l'evenement clique sur le bouton
					 */
					bouton.setOnAction(new EventHandler<ActionEvent>() {
					    @Override public void handle(ActionEvent e) {
					    	
					    	/**
					    	 * Recupere la fenetre
					    	 */
					    	BorderPane rootPane = Launcher.getRoot();
					    	/**
					    	 * Charge la vue client details
					    	 */
					    	FXMLLoader loaderClientDetails = new FXMLLoader(getClass().getResource("/src/Views/clientDetails.fxml"));
			       			AnchorPane clientDetails;
							try {
								clientDetails = loaderClientDetails.load();
								rootPane.setCenter(clientDetails);
								/**
								 * Recupere le client correspondant à l'id
								 */
						    	Client c = AccesData.getClientById(Integer.parseInt(bouton.getId()));
						        //System.out.println(c);
						        ClientDetails controllerClient = loaderClientDetails.<ClientDetails>getController();
						        controllerClient.setClient(c);
						        controllerClient.update();
						    } catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}   
					    }
					});
					return bouton;
				}

				@Override
				public void removeListener(ChangeListener listener) {
					// TODO Auto-generated method stub
					
				}
		});
		
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> nom = new JFXTreeTableColumn<>("Nom");
		nom.setPrefWidth(100);
		nom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getNom()));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> prenom = new JFXTreeTableColumn<>("Prénom");
		prenom.setPrefWidth(100);
		prenom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPrenom()));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> adresse = new JFXTreeTableColumn<>("Adresse");
		adresse.setPrefWidth(100);
		adresse.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAdresseRue() + ", " + param.getValue().getValue().getAdresseVille() + ", " + param.getValue().getValue().getCodePostal()));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> telephone = new JFXTreeTableColumn<>("Téléphone");
		telephone.setPrefWidth(100);
		telephone.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getTelephone()));
		
		/**
		 * Créé la colonne en la nommant, définie sa taille par défault puis Ajoute une valeur à la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> chambre = new JFXTreeTableColumn<>("Chambre actuelle");
		chambre.setPrefWidth(100);		
		chambre.setCellValueFactory(param -> new SimpleStringProperty(AccesData.getChambreClientActuelle(param.getValue().getValue().getId())));
		
		System.out.println("id de la chambre : " + AccesData.getChambreClientActuelle(1));
		/**
		 * Ajoute l'arbre de clients au panel
		 */
		tableHebergementClient.setRoot(root);
		tableHebergementClient.setShowRoot(false);
		
		/**
		 * Récupère les colonnes du tableau puis ajoute les nouvelles colonnes précédemment déclarées
		 */
		tableHebergementClient.getColumns().setAll(voir,nom,prenom,adresse,telephone,chambre);

	}
	
	/**
	 * Fonction de recherche lors du clique sur rechercher
	 */
	public void search(){
		/**
		 * Vide la liste d'observable de clients
		 */
		listeClients.clear();
		
		/**
		 * Ajoute dans une liste tous les clients correspondant au filtre après avoir fait la requête nécessaire
		 */
		 List<Client> listeClient = AccesData.getClientFiltre(this.txtName.getText(), this.txtPrenom.getText(), this.txtAdresse.getText(), this.txtPhone.getText());
//		if(!txtName.getText().equals("")){
//			listeClient = AccesData.getClientsByName(txtName.getText());
//		} else if (!txtPrenom.getText().equals("")){
//			listeClient = AccesData.getClientsByPrenom(txtPrenom.getText());
//		} else if (!txtAdresse.getText().equals("")){
//			listeClient = AccesData.getClientsByAdresse(txtAdresse.getText());
//		} else if (!txtPhone.getText().equals("")){
//			listeClient = AccesData.getClientsByPhone(txtPhone.getText());
//		}		
		
		/**
		 * Ajoute les clients à la liste d'observables pour qu'ils soient affichés
		 */
		if(listeClient.size() > 0){
			for(Client c : listeClient){
				listeClients.add(c);
			}
		}
	}
	
	public void createClient(){
		BorderPane root = Launcher.getRoot();
		FXMLLoader loaderClientNew = new FXMLLoader(getClass().getResource("/src/Views/newClient.fxml"));
		AnchorPane newClient;
		try {
			newClient = loaderClientNew.load();
			root.setCenter(newClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
