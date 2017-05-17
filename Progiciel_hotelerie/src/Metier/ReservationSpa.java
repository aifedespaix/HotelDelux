package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "reservation_spa", schema = "hotel", catalog = "")
public class ReservationSpa {
    private int id;
    private Date dateDebut;
    private Date dateArrivee;
    private int idTva;
    private int idSpa;
    private Tva tvaByIdTva;
    private Spa spaByIdSpa;
    private Collection<FacturationAssoc> facturationAssocsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdTva(Integer idTva) {
        this.idTva = idTva;
    }

    public void setIdSpa(Integer idSpa) {
        this.idSpa = idSpa;
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
    @Column(name = "date_debut", nullable = false)
    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "date_arrivee", nullable = false)
    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    @Basic
    @Column(name = "id_tva", nullable = false)
    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    @Basic
    @Column(name = "id_spa", nullable = false)
    public int getIdSpa() {
        return idSpa;
    }

    public void setIdSpa(int idSpa) {
        this.idSpa = idSpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationSpa that = (ReservationSpa) o;

        if (id != that.id) return false;
        if (idTva != that.idTva) return false;
        if (idSpa != that.idSpa) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateArrivee != null ? !dateArrivee.equals(that.dateArrivee) : that.dateArrivee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateArrivee != null ? dateArrivee.hashCode() : 0);
        result = 31 * result + idTva;
        result = 31 * result + idSpa;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_tva", referencedColumnName = "id", nullable = false)
    public Tva getTvaByIdTva() {
        return tvaByIdTva;
    }

    public void setTvaByIdTva(Tva tvaByIdTva) {
        this.tvaByIdTva = tvaByIdTva;
    }

    @ManyToOne
    @JoinColumn(name = "id_spa", referencedColumnName = "id", nullable = false)
    public Spa getSpaByIdSpa() {
        return spaByIdSpa;
    }

    public void setSpaByIdSpa(Spa spaByIdSpa) {
        this.spaByIdSpa = spaByIdSpa;
    }

    @OneToMany(mappedBy = "reservationSpaByIdReservationSpa")
    public Collection<FacturationAssoc> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssoc> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }
}
