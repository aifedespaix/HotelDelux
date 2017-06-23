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
import src.Metier.Client;
import src.Persistance.AccesData;
import src.util.Colors;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
					JFXButton bouton = new JFXButton("Visualiser");
					Colors.primary(bouton);

					/* Id pour recupere le client correspondant a la ligne */
					bouton.setId(String.valueOf(param.getValue().getValue().getId()));
					
					/* Gere l'evenement clique sur le bouton */
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
						        ClientDetails controllerClient = loaderClientDetails.<ClientDetails>getController();
						        controllerClient.setClient(c);
						        controllerClient.update();
						    } catch (IOException e1) {
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

		
		JFXTreeTableColumn<Client, String> prenom = new JFXTreeTableColumn<>("Prénom");

		prenom.setPrefWidth(100);
		prenom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPrenom()));

		JFXTreeTableColumn<Client, String> adresse = new JFXTreeTableColumn<>("Adresse");
		adresse.setPrefWidth(100);
		adresse.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAdresseRue() + ", " + param.getValue().getValue().getAdresseVille() + ", " + param.getValue().getValue().getCodePostal()));

		JFXTreeTableColumn<Client, String> telephone = new JFXTreeTableColumn<>("Téléphone");
		telephone.setPrefWidth(100);
		telephone.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getTelephone()));

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
		 * Réupère les colonnes du tableau puis ajoute les nouvelles colonnes précédemment déclarées
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
		 * Ajoute dans une liste tous les clients correspondant au filtre aprÃ©s avoir fait la requÃ©te nÃ©cessaire
		 */
		 List<Client> listeClient = AccesData.getClientFiltre(this.txtName.getText(), this.txtPrenom.getText(), this.txtAdresse.getText(), this.txtPhone.getText());

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
		FXMLLoader loaderClientNew = new FXMLLoader(getClass().getResource("/src/Views/editClient.fxml"));
		AnchorPane newClient;
		try {
			newClient = loaderClientNew.load();
			EditClient controllerEditClient = loaderClientNew.<EditClient>getController();
			controllerEditClient.setTitreLabel();
			root.setCenter(newClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
