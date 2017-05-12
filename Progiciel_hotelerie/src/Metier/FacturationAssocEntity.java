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
    private ClientEntity clientByIdClient;
    private FactureEntity factureByIdFacture;

    
    public FacturationAssocEntity(int id, int idReservation, ClientEntity clientByIdClient,
			FactureEntity factureByIdFacture) {
		super();
		this.id = id;
		this.idReservation = idReservation;
		this.clientByIdClient = clientByIdClient;
		this.factureByIdFacture = factureByIdFacture;
	}
    

	public FacturationAssocEntity(int idReservation, ClientEntity clientByIdClient,
			FactureEntity factureByIdFacture) {
		super();
		this.idReservation = idReservation;
		this.clientByIdClient = clientByIdClient;
		this.factureByIdFacture = factureByIdFacture;
	}


	public FacturationAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FacturationAssocEntity [id=" + id + ", idReservation=" + idReservation + ", " + " clientByIdClient=" + clientByIdClient + ", factureByIdFacture="
				+ factureByIdFacture + "]";
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
