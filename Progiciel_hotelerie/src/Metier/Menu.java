package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Menu {
    private int id;
    private String libelle;
    private double prix;
    private Collection<RestaurantAssoc> restaurantAssocsById;

    public Menu(int id, String libelle, double prix, Collection<RestaurantAssoc> restaurantAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public Menu(String libelle, double prix, Collection<RestaurantAssoc> restaurantAssocsById) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", restaurantAssocsById="
				+ restaurantAssocsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "prix", nullable = false, precision = 0)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @OneToMany(mappedBy = "menuByIdMenu")
    public Collection<RestaurantAssoc> getRestaurantAssocsById() {
        return restaurantAssocsById;
    }

    public void setRestaurantAssocsById(Collection<RestaurantAssoc> restaurantAssocsById) {
        this.restaurantAssocsById = restaurantAssocsById;
    }
}
