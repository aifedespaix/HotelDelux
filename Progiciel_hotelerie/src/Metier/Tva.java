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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tva tva = (Tva) o;

        if (id != tva.id) return false;
        if (Double.compare(tva.prix, prix) != 0) return false;
        if (libelle != null ? !libelle.equals(tva.libelle) : tva.libelle != null) return false;

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
