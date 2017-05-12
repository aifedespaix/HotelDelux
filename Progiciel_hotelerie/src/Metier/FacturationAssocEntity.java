package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "facturation_assoc", schema = "base_definitive", catalog = "")
public class FacturationAssocEntity {
    private int id;
    private int idReservation;
    private int idClient;
    private int idFacture;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_reservation")
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "id_client")
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "id_facture")
    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacturationAssocEntity that = (FacturationAssocEntity) o;

        if (id != that.id) return false;
        if (idReservation != that.idReservation) return false;
        if (idClient != that.idClient) return false;
        if (idFacture != that.idFacture) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idReservation;
        result = 31 * result + idClient;
        result = 31 * result + idFacture;
        return result;
    }
}
