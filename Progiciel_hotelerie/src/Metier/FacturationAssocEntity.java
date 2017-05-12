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
    private ClientEntity clientByIdClient;
    private FactureEntity factureByIdFacture;

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

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(name = "id_facture", referencedColumnName = "id", nullable = false)
    public FactureEntity getFactureByIdFacture() {
        return factureByIdFacture;
    }

    public void setFactureByIdFacture(FactureEntity factureByIdFacture) {
        this.factureByIdFacture = factureByIdFacture;
    }
}
