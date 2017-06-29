package src.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import src.Launcher.Launcher;
import src.Metier.DemandeIntervention;
import src.Metier.Rapport;
import src.Persistance.Maintenance.AccesDataMaintenance;
import src.util.generalFunctions;

import java.io.IOException;
import java.sql.Date;

public class DemandeDetail {
	
	private DemandeIntervention demande;
	private Rapport rapport;
	
	@FXML private Text demandeLabel;
	@FXML private Text demandeurLabel;
	@FXML private Text etatLabel;
	@FXML private Text criticiteLabel;
	@FXML private Text serviceLabel;
	@FXML private HBox hBoxEquipement;
	@FXML private Text descriptionLabel;
	@FXML JFXButton rapportBtn;
	
	public void setDemande(DemandeIntervention demande) {
		this.demande = demande;
	}

	public void update() {
		// Dynamisation des champs
		demandeLabel.setText(demandeLabel.getText() + demande.getId() + " - " + demande.getObjet());
		demandeurLabel.setText(demandeurLabel.getText() + demande.getDemandeurById() + " le " + generalFunctions.formatDate(demande.getDateCreation()));
		etatLabel.setText(etatLabel.getText() + demande.getEtat());
		criticiteLabel.setText(criticiteLabel.getText() + demande.getCriticiteByIdCriticite());
		String service = generalFunctions.getServiceDemande(demande);
		serviceLabel.setText(serviceLabel.getText() + service);
		switch (service) {
		case "Hôtel" :
			Text etage = new Text("Etage " + demande.getEquipementHotelByIdEquipementHotel().getChambreByIdChambre().getEtage());
			etage.setFont(new Font(15));
			Text chambre = new Text("Chambre n°" + demande.getEquipementHotelByIdEquipementHotel().getChambreByIdChambre().getNumeroChambre());
			chambre.setUnderline(true);
			chambre.setFont(new Font(15));
			Text equipementHotel = new Text(demande.getEquipementHotelByIdEquipementHotel().getLibelle());
			equipementHotel.setUnderline(true);
			equipementHotel.setFont(new Font(15));
			chambre.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println("Redirection vers la chambre");
					//Lien vers la chambre
				}
			});
			equipementHotel.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println("Redirection vers l'équipement");
					//Lien vers l'équipement
				}
			});
			hBoxEquipement.getChildren().add(etage);
			ImageView arrow1 = new ImageView("/src/image/icons/arrow_right.png");
			arrow1.setFitHeight(50);
			arrow1.setPreserveRatio(true);
			hBoxEquipement.getChildren().add(arrow1);
			hBoxEquipement.getChildren().add(chambre);
			ImageView arrow2 = new ImageView("/src/image/icons/arrow_right.png");
			arrow2.setFitHeight(50);
			arrow2.setPreserveRatio(true);
			hBoxEquipement.getChildren().add(arrow2);
			hBoxEquipement.getChildren().add(equipementHotel);
			break;
		case "Jardin" :
			Text equipementJardin = new Text(demande.getEquipementHotelByIdEquipementHotel().getLibelle());
			equipementJardin.setUnderline(true);
			equipementJardin.setFont(new Font(15));
			equipementJardin.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println("Redirection vers l'équipement");
					//Lien vers l'équipement
				}
			});
			hBoxEquipement.getChildren().add(equipementJardin);
			break;
		case "Restaurant" :
			Text equipementRestaurant = new Text(demande.getEquipementRestaurantByIdEquipementRestaurant().getLibelle());
			equipementRestaurant.setUnderline(true);
			equipementRestaurant.setFont(new Font(15));
			equipementRestaurant.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println("Redirection vers l'équipement");
					//Lien vers l'équipement
				}
			});
			hBoxEquipement.getChildren().add(equipementRestaurant);
			break;
		case "Spa" :
			Text equipementSpa = new Text(demande.getEquipementSpaByIdEquipementSpa().getLibelle());
			equipementSpa.setUnderline(true);
			equipementSpa.setFont(new Font(15));
			equipementSpa.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					System.out.println("Redirection vers l'équipement");
					//Lien vers l'équipement
				}
			});
			hBoxEquipement.getChildren().add(equipementSpa);
			break;
		default : System.err.println("Erreur sur le service");
		}
		descriptionLabel.setText(demande.getDescription());
		
		// Changement du libellé du bouton Rapport en fonction si un rapport est associé à la demande
		if ((this.rapport = demande.getRapport()) != null) {
			rapportBtn.setText("Voir le rapport");
		} else {
			rapportBtn.setText("Créer le rapport");
			
		}
	}
	
	/**
	 * Bouton création du rapport associé à la demande
	 */
	public void rapport() {
		try {
			if (this.rapport ==null) {
				// Création du rapport et l'affecte automatiquement à l'utilisateur connecté
				this.rapport = new Rapport(new Date(0), new Date(0),"", demande, Login.getConnectedUser());
				//Persistance dans la base
				AccesDataMaintenance.ajouterRapport(this.rapport);
			}
			// Charge la page du rapport fraichement créé
			BorderPane rootPane = Launcher.getRoot();
	    	FXMLLoader loaderRapportDetail = new FXMLLoader(getClass().getResource("/src/Views/rapportDetail.fxml"));
   			AnchorPane rapportDetail;
			rapportDetail = loaderRapportDetail.load();
			rootPane.setCenter(rapportDetail);
	        RapportDetail controllerRapportDetail = loaderRapportDetail.<RapportDetail>getController();
	        controllerRapportDetail.setRapport(this.rapport);
	        controllerRapportDetail.update();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Permet de revenir à la liste
	 * @throws IOException
	 */
	public void cancel() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/Views/ListeDemandes.fxml"));
		AnchorPane demandes = loader.load();
		Launcher.getRoot().setCenter(demandes);
	}
}
