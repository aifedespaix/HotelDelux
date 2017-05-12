package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "plat", schema = "base_definitive", catalog = "")
public class PlatEntity {
    private int id;
    private String libelle;
    private double prix;
    private Collection<PlatAlimentAssocEntity> platAlimentAssocsById;
    private Collection<RestaurantAssocEntity> restaurantAssocsById;

    
    public PlatEntity(int id, String libelle, double prix, Collection<PlatAlimentAssocEntity> platAlimentAssocsById,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.platAlimentAssocsById = platAlimentAssocsById;
		this.restaurantAssocsById = restaurantAssocsById;
	}
    
    

	public PlatEntity(String libelle, double prix, Collection<PlatAlimentAssocEntity> platAlimentAssocsById,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.platAlimentAssocsById = platAlimentAssocsById;
		this.restaurantAssocsById = restaurantAssocsById;
	}



	public PlatEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	@Override
	public String toString() {
		return "PlatEntity [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", platAlimentAssocsById="
				+ platAlimentAssocsById + ", restaurantAssocsById=" + restaurantAssocsById + "]";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatEntity that = (PlatEntity) o;

        if (id != that.id) return false;
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
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "platByIdPlat")
    public Collection<PlatAlimentAssocEntity> getPlatAlimentAssocsById() {
        return platAlimentAssocsById;
    }

    public void setPlatAlimentAssocsById(Collection<PlatAlimentAssocEntity> platAlimentAssocsById) {
        this.platAlimentAssocsById = platAlimentAssocsById;
    }

    @OneToMany(mappedBy = "platByIdPlat")
    public Collection<RestaurantAssocEntity> getRestaurantAssocsById() {
        return restaurantAssocsById;
    }

    public void setRestaurantAssocsById(Collection<RestaurantAssocEntity> restaurantAssocsById) {
        this.restaurantAssocsById = restaurantAssocsById;
    }
}
