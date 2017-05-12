package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "client_agence_assoc", schema = "base_definitive", catalog = "")
public class ClientAgenceAssocEntity {
    private int id;
    private ClientEntity clientByIdClient;
    private AgenceEntity agenceByIdAgence;

    public ClientAgenceAssocEntity(int id, ClientEntity clientByIdClient,
			AgenceEntity agenceByIdAgence) {
		super();
		this.id = id;
		this.clientByIdClient = clientByIdClient;
		this.agenceByIdAgence = agenceByIdAgence;
	}

	public ClientAgenceAssocEntity( ClientEntity clientByIdClient,
			AgenceEntity agenceByIdAgence) {
		super();
		this.clientByIdClient = clientByIdClient;
		this.agenceByIdAgence = agenceByIdAgence;
	}

	public ClientAgenceAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClientAgenceAssocEntity [id=" + id + ", idClient=" + ", idAgence="
				+ ", clientByIdClient=" + clientByIdClient + ", agenceByIdAgence=" + agenceByIdAgence + "]";
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
