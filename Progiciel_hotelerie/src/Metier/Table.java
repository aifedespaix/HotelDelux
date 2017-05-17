package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Table {
    private int id;
    private int nbCouverts;
    private Collection<EquipementRestaurant> equipementRestaurantsById;
    private Collection<ReservationRestaurant> reservationRestaurantsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNbCouverts(Integer nbCouverts) {
        this.nbCouverts = nbCouverts;
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
    @Column(name = "nbCouverts", nullable = false)
    public int getNbCouverts() {
        return nbCouverts;
    }

    public void setNbCouverts(int nbCouverts) {
        this.nbCouverts = nbCouverts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        if (id != table.id) return false;
        if (nbCouverts != table.nbCouverts) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nbCouverts;
        return result;
    }

    @OneToMany(mappedBy = "tableByIdTable")
    public Collection<EquipementRestaurant> getEquipementRestaurantsById() {
        return equipementRestaurantsById;
    }

    public void setEquipementRestaurantsById(Collection<EquipementRestaurant> equipementRestaurantsById) {
        this.equipementRestaurantsById = equipementRestaurantsById;
    }

    @OneToMany(mappedBy = "tableByIdTable")
    public Collection<ReservationRestaurant> getReservationRestaurantsById() {
        return reservationRestaurantsById;
    }

    public void setReservationRestaurantsById(Collection<ReservationRestaurant> reservationRestaurantsById) {
        this.reservationRestaurantsById = reservationRestaurantsById;
    }
}
