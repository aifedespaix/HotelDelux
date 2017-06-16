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
    private Tva tvaByIdTva;
    private Chambre chambreByIdChambre;
    private int id_client;
    private Collection<FacturationAssoc> facturationAssocsById;

    public ReservationHotel(int id, Date dateFin, Date dateDebut, Tva tvaByIdTva, Chambre chambreByIdChambre,
			Collection<FacturationAssoc> facturationAssocsById) {
		super();
		this.id = id;
		this.dateFin = dateFin;
		this.dateDebut = dateDebut;
		this.tvaByIdTva = tvaByIdTva;
		this.chambreByIdChambre = chambreByIdChambre;
		this.facturationAssocsById = facturationAssocsById;
	}

	public ReservationHotel(Date dateFin, Date dateDebut, Tva tvaByIdTva, Chambre chambreByIdChambre,
			Collection<FacturationAssoc> facturationAssocsById) {
		super();
		this.dateFin = dateFin;
		this.dateDebut = dateDebut;
		this.tvaByIdTva = tvaByIdTva;
		this.chambreByIdChambre = chambreByIdChambre;
		this.facturationAssocsById = facturationAssocsById;
	}

	public ReservationHotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReservationHotel [id=" + id + ", dateFin=" + dateFin + ", dateDebut=" + dateDebut
				+ ", tvaByIdTva=" + tvaByIdTva + ", chambreByIdChambre=" + chambreByIdChambre
				+ ", facturationAssocsById=" + facturationAssocsById + "]";
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
    public int getidClient(){
    	return this.id_client;
    }
    
    public void setidClient(int id_client){
    	this.id_client = id_client;
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

    @OneToMany(mappedBy = "reservationHotelByIdReservationHotel")
    public Collection<FacturationAssoc> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssoc> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }
}
