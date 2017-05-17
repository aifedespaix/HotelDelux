package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "client_agence_assoc", schema = "hotel", catalog = "")
public class ClientAgenceAssoc {
    private int id;
    private int idClient;
    private int idAgence;
    private Client clientByIdClient;
    private Agence agenceByIdAgence;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public void setIdAgence(Integer idAgence) {
        this.idAgence = idAgence;
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
    @Column(name = "id_client", nullable = false, updatable = false,insertable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "id_agence", nullable = false, updatable = false,insertable = false)
    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false, updatable = false,insertable = false)
    public Client getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(Client clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id", nullable = false, updatable = false,insertable = false)
    public Agence getAgenceByIdAgence() {
        return agenceByIdAgence;
    }

    public void setAgenceByIdAgence(Agence agenceByIdAgence) {
        this.agenceByIdAgence = agenceByIdAgence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAgenceAssoc that = (ClientAgenceAssoc) o;

        if (id != that.id) return false;
        if (idClient != that.idClient) return false;
        if (idAgence != that.idAgence) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idClient;
        result = 31 * result + idAgence;
        return result;
    }
}
