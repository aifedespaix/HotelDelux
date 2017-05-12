package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "tva", schema = "base_definitive", catalog = "")
public class TvaEntity {
    private int id;
    private String libelle;
    private double prix;
    private Collection<ReservationHotelEntity> reservationHotelsById;
    private Collection<ReservationRestaurantEntity> reservationRestaurantsById;
    private Collection<ReservationSpaEntity> reservationSpasById;

    
    
    public TvaEntity(int id, String libelle, double prix, Collection<ReservationHotelEntity> reservationHotelsById,
			Collection<ReservationRestaurantEntity> reservationRestaurantsById,
			Collection<ReservationSpaEntity> reservationSpasById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.reservationHotelsById = reservationHotelsById;
		this.reservationRestaurantsById = reservationRestaurantsById;
		this.reservationSpasById = reservationSpasById;
	}

    
	public TvaEntity(String libelle, double prix, Collection<ReservationHotelEntity> reservationHotelsById,
			Collection<ReservationRestaurantEntity> reservationRestaurantsById,
			Collection<ReservationSpaEntity> reservationSpasById) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.reservationHotelsById = reservationHotelsById;
		this.reservationRestaurantsById = reservationRestaurantsById;
		this.reservationSpasById = reservationSpasById;
	}


	public TvaEntity() {
		super();
		// TODO Auto-generated constructor stub
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

        TvaEntity tvaEntity = (TvaEntity) o;

        if (id != tvaEntity.id) return false;
        if (Double.compare(tvaEntity.prix, prix) != 0) return false;
        if (libelle != null ? !libelle.equals(tvaEntity.libelle) : tvaEntity.libelle != null) return false;

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

    @OneToMany(mappedBy = "tvaByIdTva")
    public Collection<ReservationHotelEntity> getReservationHotelsById() {
        return reservationHotelsById;
    }

    public void setReservationHotelsById(Collection<ReservationHotelEntity> reservationHotelsById) {
        this.reservationHotelsById = reservationHotelsById;
    }

    @OneToMany(mappedBy = "tvaByIdTva")
    public Collection<ReservationRestaurantEntity> getReservationRestaurantsById() {
        return reservationRestaurantsById;
    }

    public void setReservationRestaurantsById(Collection<ReservationRestaurantEntity> reservationRestaurantsById) {
        this.reservationRestaurantsById = reservationRestaurantsById;
    }

    @OneToMany(mappedBy = "tvaByIdTva")
    public Collection<ReservationSpaEntity> getReservationSpasById() {
        return reservationSpasById;
    }

    public void setReservationSpasById(Collection<ReservationSpaEntity> reservationSpasById) {
        this.reservationSpasById = reservationSpasById;
    }


	@Override
	public String toString() {
		return "TvaEntity [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", reservationHotelsById="
				+ reservationHotelsById + ", reservationRestaurantsById=" + reservationRestaurantsById
				+ ", reservationSpasById=" + reservationSpasById + "]";
	}
    
    
}
