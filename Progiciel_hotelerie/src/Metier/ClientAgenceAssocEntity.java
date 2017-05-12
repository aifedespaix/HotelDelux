package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "client_agence_assoc", schema = "base_definitive", catalog = "")
public class ClientAgenceAssocEntity {
    private int id;
    private int idClient;
    private int idAgence;
    private ClientEntity clientByIdClient;
    private AgenceEntity agenceByIdAgence;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "id_agence", nullable = false)
    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAgenceAssocEntity that = (ClientAgenceAssocEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id", nullable = false)
    public AgenceEntity getAgenceByIdAgence() {
        return agenceByIdAgence;
    }

    public void setAgenceByIdAgence(AgenceEntity agenceByIdAgence) {
        this.agenceByIdAgence = agenceByIdAgence;
    }
}
