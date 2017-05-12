package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "table", schema = "base_definitive", catalog = "")
public class TableEntity {
    private int id;
    private int nbCouverts;
    private Collection<EquipementRestaurantEntity> equipementRestaurantsById;
    private Collection<ReservationRestaurantEntity> reservationRestaurantsById;

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

        TableEntity that = (TableEntity) o;

        if (id != that.id) return false;
        if (nbCouverts != that.nbCouverts) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nbCouverts;
        return result;
    }

    @OneToMany(mappedBy = "tableByIdTable")
    public Collection<EquipementRestaurantEntity> getEquipementRestaurantsById() {
        return equipementRestaurantsById;
    }

    public void setEquipementRestaurantsById(Collection<EquipementRestaurantEntity> equipementRestaurantsById) {
        this.equipementRestaurantsById = equipementRestaurantsById;
    }

    @OneToMany(mappedBy = "tableByIdTable")
    public Collection<ReservationRestaurantEntity> getReservationRestaurantsById() {
        return reservationRestaurantsById;
    }

    public void setReservationRestaurantsById(Collection<ReservationRestaurantEntity> reservationRestaurantsById) {
        this.reservationRestaurantsById = reservationRestaurantsById;
    }
}
