package src.Metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "reservation_restaurant", schema = "base_definitive", catalog = "")
public class ReservationRestaurantEntity {
    private int id;
    private Date dateArrivee;
    private Date dateDepart;
    private int idTva;
    private int idTable;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_arrivee")
    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    @Basic
    @Column(name = "date_depart")
    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    @Basic
    @Column(name = "id_tva")
    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    @Basic
    @Column(name = "id_table")
    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationRestaurantEntity that = (ReservationRestaurantEntity) o;

        if (id != that.id) return false;
        if (idTva != that.idTva) return false;
        if (idTable != that.idTable) return false;
        if (dateArrivee != null ? !dateArrivee.equals(that.dateArrivee) : that.dateArrivee != null) return false;
        if (dateDepart != null ? !dateDepart.equals(that.dateDepart) : that.dateDepart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateArrivee != null ? dateArrivee.hashCode() : 0);
        result = 31 * result + (dateDepart != null ? dateDepart.hashCode() : 0);
        result = 31 * result + idTva;
        result = 31 * result + idTable;
        return result;
    }
}
