package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "boisson", schema = "base_definitive", catalog = "")
public class BoissonEntity {
    private int id;
    private String libelle;
    private double quantite;
    private double prix;
    private Collection<RestaurantAssocEntity> restaurantAssocsById;

    public BoissonEntity(int id, String libelle, double quantite, double prix,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.quantite = quantite;
		this.prix = prix;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public BoissonEntity(String libelle, double quantite, double prix,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.libelle = libelle;
		this.quantite = quantite;
		this.prix = prix;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public BoissonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BoissonEntity [id=" + id + ", libelle=" + libelle + ", quantite=" + quantite + ", prix=" + prix
				+ ", restaurantAssocsById=" + restaurantAssocsById + "]";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoissonEntity that = (BoissonEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.quantite, quantite) != 0) return false;
        if (Double.compare(that.prix, prix) != 0) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        temp = Double.doubleToLongBits(quantite);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "boissonByIdBoisson")
    public Collection<RestaurantAssocEntity> getRestaurantAssocsById() {
        return restaurantAssocsById;
    }

    public void setRestaurantAssocsById(Collection<RestaurantAssocEntity> restaurantAssocsById) {
        this.restaurantAssocsById = restaurantAssocsById;
    }
}
