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

    public ClientAgenceAssocEntity(int id, int idClient, int idAgence, ClientEntity clientByIdClient,
			AgenceEntity agenceByIdAgence) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.idAgence = idAgence;
		this.clientByIdClient = clientByIdClient;
		this.agenceByIdAgence = agenceByIdAgence;
	}

	public ClientAgenceAssocEntity(int idClient, int idAgence, ClientEntity clientByIdClient,
			AgenceEntity agenceByIdAgence) {
		super();
		this.idClient = idClient;
		this.idAgence = idAgence;
		this.clientByIdClient = clientByIdClient;
		this.agenceByIdAgence = agenceByIdAgence;
	}

	public ClientAgenceAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClientAgenceAssocEntity [id=" + id + ", idClient=" + idClient + ", idAgence=" + idAgence
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
