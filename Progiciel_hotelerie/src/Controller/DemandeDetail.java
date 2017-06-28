package src.Controller;

import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import src.Launcher.Launcher;
import src.Metier.DemandeIntervention;
import src.util.generalFunctions;

public class DemandeDetail {
	
	DemandeIntervention demande;
	
	@FXML private Text demandeLabel;
	@FXML private Text demandeurLabel;
	@FXML private Text etatLabel;
	@FXML private Text criticiteLabel;
	@FXML private Text serviceLabel;
	@FXML private HBox hBoxEquipement;
	@FXML private Text descriptionLabel;
	
	public void setDemande(DemandeIntervention demande) {
		this.demande = demande;
	}

	public void update() {
		// Dynamisation des champs
		demandeLabel.setText(demandeLabel.getText() + demande.getId());
		demandeurLabel.setText(demandeurLabel.getText() + demande.getDemandeurById());
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
