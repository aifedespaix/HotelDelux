package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Boisson {
    private int id;
    private String libelle;
    private double quantite;
    private double prix;
    private Collection<RestaurantAssoc> restaurantAssocsById;

    public Boisson(int id, String libelle, double quantite, double prix,
			Collection<RestaurantAssoc> restaurantAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.quantite = quantite;
		this.prix = prix;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public Boisson(String libelle, double quantite, double prix, Collection<RestaurantAssoc> restaurantAssocsById) {
		super();
		this.libelle = libelle;
		this.quantite = quantite;
		this.prix = prix;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public Boisson() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Boisson [id=" + id + ", libelle=" + libelle + ", quantite=" + quantite + ", prix=" + prix
				+ ", restaurantAssocsById=" + restaurantAssocsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
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
    @Column(name = "libelle", nullable = false, length = 250)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "quantite", nullable = false, precision = 0)
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @Basic
    @Column(name = "prix", nullable = false, precision = 0)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @OneToMany(mappedBy = "boissonByIdBoisson")
    public Collection<RestaurantAssoc> getRestaurantAssocsById() {
        return restaurantAssocsById;
    }

    public void setRestaurantAssocsById(Collection<RestaurantAssoc> restaurantAssocsById) {
        this.restaurantAssocsById = restaurantAssocsById;
    }
}
