package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "reservation_hotel")
public class ReservationHotel  extends RecursiveTreeObject<ReservationHotel>{
    private int id;
    private Date dateFin;
    private Date dateDebut;
    private int nbEnfants;
    private int nbAdultes;
    private Boolean valide;
    private String informationsComplementaires;
    private Tva tvaByIdTva;
    private Chambre chambreByIdChambre;
    private int idClient;

    public ReservationHotel(int id, Date dateFin, Date dateDebut, Boolean valide, String informationsComplementaires, Tva tvaByIdTva, Chambre chambreByIdChambre,int nbEnfants,int nbAdultes, int idClient) {
		super();
		this.id = id;
		this.dateFin = dateFin;
		this.dateDebut = dateDebut;
		this.valide = valide;
		this.informationsComplementaires = informationsComplementaires;
		this.tvaByIdTva = tvaByIdTva;
		this.chambreByIdChambre = chambreByIdChambre;
		this.nbAdultes = nbAdultes;
		this.nbEnfants = nbEnfants;
		this.idClient = idClient;
	}

	public ReservationHotel(Date dateFin, Date dateDebut, Boolean valide, Tva tvaByIdTva, Chambre chambreByIdChambre) {
		super();
		this.dateFin = dateFin;
		this.dateDebut = dateDebut;
		this.valide = false;
		this.tvaByIdTva = tvaByIdTva;
		this.chambreByIdChambre = chambreByIdChambre;
	}

	public ReservationHotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReservationHotel [id=" + id + ", dateFin=" + dateFin + ", dateDebut=" + dateDebut
				+ ", tvaByIdTva=" + tvaByIdTva.getId() + ", chambreByIdChambre=" + chambreByIdChambre.getId()
				+ "]";
	}

	public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "date_fin", nullable = false)
    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
    @Column(name = "id_client", nullable = false)
    public int getIdClient(){
    	return this.idClient;
    }
    
    public void setIdClient(int id_client){
    	this.idClient = id_client;
    }
    
    
    @Basic
    @Column(name = "valide")
    public Boolean getValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}
	
	
	@Basic
    @Column(name = "infos_complementaires")
	public String getInformationsComplementaires() {
		return informationsComplementaires;
	}

	public void setInformationsComplementaires(String informationsComplementaires) {
		this.informationsComplementaires = informationsComplementaires;
	}

	@Basic
    @Column(name = "nb_enfants", nullable = false)
    public int getNbEnfants() {
        return this.nbEnfants;
    }

    public void setNbEnfants(int nbEnfants) {
        this.nbEnfants = nbEnfants;
    }
    
    @Basic
    @Column(name = "nb_adultes", nullable = false)
    public int getNbAdultes() {
        return this.nbAdultes;
    }

    public void setNbAdultes(int nbAdultes) {
        this.nbAdultes = nbAdultes;
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
    @JoinColumn(name = "id_chambre", referencedColumnName = "id", nullable = false)
    public Chambre getChambreByIdChambre() {
        return chambreByIdChambre;
    }

    public void setChambreByIdChambre(Chambre chambreByIdChambre) {
        this.chambreByIdChambre = chambreByIdChambre;
    }
}
