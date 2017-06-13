package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Tva {
    private int id;
    private String libelle;
    private double prix;
    private Collection<ReservationHotel> reservationHotelsById;
    private Collection<ReservationRestaurant> reservationRestaurantsById;
    private Collection<ReservationSpa> reservationSpasById;

    public Tva(int id, String libelle, double prix, Collection<ReservationHotel> reservationHotelsById,
			Collection<ReservationRestaurant> reservationRestaurantsById,
			Collection<ReservationSpa> reservationSpasById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.reservationHotelsById = reservationHotelsById;
		this.reservationRestaurantsById = reservationRestaurantsById;
		this.reservationSpasById = reservationSpasById;
	}
    
	public Tva() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tva [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", reservationHotelsById="
				+ reservationHotelsById + ", reservationRestaurantsById=" + reservationRestaurantsById
				+ ", reservationSpasById=" + reservationSpasById + "]";
	}

	public Tva(String libelle, double prix, Collection<ReservationHotel> reservationHotelsById,
			Collection<ReservationRestaurant> reservationRestaurantsById,
			Collection<ReservationSpa> reservationSpasById) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.reservationHotelsById = reservationHotelsById;
		this.reservationRestaurantsById = reservationRestaurantsById;
		this.reservationSpasById = reservationSpasById;
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

    @OneToMany(mappedBy = "tvaByIdTva")
    public Collection<ReservationHotel> getReservationHotelsById() {
        return reservationHotelsById;
    }

    public void setReservationHotelsById(Collection<ReservationHotel> reservationHotelsById) {
        this.reservationHotelsById = reservationHotelsById;
    }

    @OneToMany(mappedBy = "tvaByIdTva")
    public Collection<ReservationRestaurant> getReservationRestaurantsById() {
        return reservationRestaurantsById;
    }

    public void setReservationRestaurantsById(Collection<ReservationRestaurant> reservationRestaurantsById) {
        this.reservationRestaurantsById = reservationRestaurantsById;
    }

    @OneToMany(mappedBy = "tvaByIdTva")
    public Collection<ReservationSpa> getReservationSpasById() {
        return reservationSpasById;
    }

    public void setReservationSpasById(Collection<ReservationSpa> reservationSpasById) {
        this.reservationSpasById = reservationSpasById;
    }
}
