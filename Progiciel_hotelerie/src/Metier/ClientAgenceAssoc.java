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
}
