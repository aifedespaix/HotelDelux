package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "facturation_assoc", schema = "base_definitive", catalog = "")
public class FacturationAssoc {
    private int id;
    private int idReservation;
    private int idClient;
    private int idFacture;
    private Client clientByIdClient;
    private Facture factureByIdFacture;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public void setIdFacture(Integer idFacture) {
        this.idFacture = idFacture;
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
    @Column(name = "id_reservation", nullable = false)
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "id_client", nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "id_facture", nullable = false)
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

        FacturationAssoc that = (FacturationAssoc) o;

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

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    public Client getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(Client clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(name = "id_facture", referencedColumnName = "id", nullable = false)
    public Facture getFactureByIdFacture() {
        return factureByIdFacture;
    }

    public void setFactureByIdFacture(Facture factureByIdFacture) {
        this.factureByIdFacture = factureByIdFacture;
    }
}
