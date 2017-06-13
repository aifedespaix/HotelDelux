package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "commande_assoc", schema = "hotel", catalog = "")
public class CommandeAssoc {
    private int id;
    private double quantite;
    private Commande commandeByIdCommande;
    private EquipementRestaurant equipementRestaurantByIdEquipementRestaurant;
    private EquipementHotel equipementHotelByIdEquipementHotel;
    private EquipementSpa equipementSpaByIdEquipementSpa;

    public CommandeAssoc(int id, double quantite, Commande commandeByIdCommande,
			EquipementRestaurant equipementRestaurantByIdEquipementRestaurant,
			EquipementHotel equipementHotelByIdEquipementHotel, EquipementSpa equipementSpaByIdEquipementSpa) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.commandeByIdCommande = commandeByIdCommande;
		this.equipementRestaurantByIdEquipementRestaurant = equipementRestaurantByIdEquipementRestaurant;
		this.equipementHotelByIdEquipementHotel = equipementHotelByIdEquipementHotel;
		this.equipementSpaByIdEquipementSpa = equipementSpaByIdEquipementSpa;
	}

	public CommandeAssoc(double quantite, Commande commandeByIdCommande,
			EquipementRestaurant equipementRestaurantByIdEquipementRestaurant,
			EquipementHotel equipementHotelByIdEquipementHotel, EquipementSpa equipementSpaByIdEquipementSpa) {
		super();
		this.quantite = quantite;
		this.commandeByIdCommande = commandeByIdCommande;
		this.equipementRestaurantByIdEquipementRestaurant = equipementRestaurantByIdEquipementRestaurant;
		this.equipementHotelByIdEquipementHotel = equipementHotelByIdEquipementHotel;
		this.equipementSpaByIdEquipementSpa = equipementSpaByIdEquipementSpa;
	}

	public CommandeAssoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommandeAssoc [id=" + id + ", quantite=" + quantite + ", commandeByIdCommande=" + commandeByIdCommande
				+ ", equipementRestaurantByIdEquipementRestaurant=" + equipementRestaurantByIdEquipementRestaurant
				+ ", equipementHotelByIdEquipementHotel=" + equipementHotelByIdEquipementHotel
				+ ", equipementSpaByIdEquipementSpa=" + equipementSpaByIdEquipementSpa + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantite", nullable = false, precision = 0)
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @ManyToOne
    @JoinColumn(name = "id_commande", referencedColumnName = "id", nullable = false, updatable = false,insertable = false)
    public Commande getCommandeByIdCommande() {
        return commandeByIdCommande;
    }

    public void setCommandeByIdCommande(Commande commandeByIdCommande) {
        this.commandeByIdCommande = commandeByIdCommande;
    }



    @ManyToOne
    @JoinColumn(name = "id_equipement_restaurant", referencedColumnName = "id")
    public EquipementRestaurant getEquipementRestaurantByIdEquipementRestaurant() {
        return equipementRestaurantByIdEquipementRestaurant;
    }

    public void setEquipementRestaurantByIdEquipementRestaurant(EquipementRestaurant equipementRestaurantByIdEquipementRestaurant) {
        this.equipementRestaurantByIdEquipementRestaurant = equipementRestaurantByIdEquipementRestaurant;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_hotel", referencedColumnName = "id")
    public EquipementHotel getEquipementHotelByIdEquipementHotel() {
        return equipementHotelByIdEquipementHotel;
    }

    public void setEquipementHotelByIdEquipementHotel(EquipementHotel equipementHotelByIdEquipementHotel) {
        this.equipementHotelByIdEquipementHotel = equipementHotelByIdEquipementHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_spa", referencedColumnName = "id")
    public EquipementSpa getEquipementSpaByIdEquipementSpa() {
        return equipementSpaByIdEquipementSpa;
    }

    public void setEquipementSpaByIdEquipementSpa(EquipementSpa equipementSpaByIdEquipementSpa) {
        this.equipementSpaByIdEquipementSpa = equipementSpaByIdEquipementSpa;
    }
}
