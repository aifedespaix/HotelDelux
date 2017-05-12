package src.Metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "reservation_hotel", schema = "base_definitive", catalog = "")
public class ReservationHotelEntity {
    private int id;
    private Date dateArrivee;
    private Date dateDebut;
    private TvaEntity tvaByIdTva;
    private ChambreEntity chambreByIdChambre;

    
    public ReservationHotelEntity(int id, Date dateArrivee, Date dateDebut,
			TvaEntity tvaByIdTva, ChambreEntity chambreByIdChambre) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDebut = dateDebut;
		this.tvaByIdTva = tvaByIdTva;
		this.chambreByIdChambre = chambreByIdChambre;
	}

    
	public ReservationHotelEntity(Date dateArrivee, Date dateDebut, TvaEntity tvaByIdTva,
			ChambreEntity chambreByIdChambre) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDebut = dateDebut;
		this.tvaByIdTva = tvaByIdTva;
		this.chambreByIdChambre = chambreByIdChambre;
	}


	public ReservationHotelEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ReservationHotelEntity [id=" + id + ", dateArrivee=" + dateArrivee + ", dateDebut=" + dateDebut
				+ ", tvaByIdTva=" + tvaByIdTva
				+ ", chambreByIdChambre=" + chambreByIdChambre + "]";
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
    @Column(name = "date_arrivee", nullable = false)
    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    @Basic
    @Column(name = "date_debut", nullable = false)
    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @ManyToOne
    @JoinColumn(name = "id_tva", referencedColumnName = "id", nullable = false)
    public TvaEntity getTvaByIdTva() {
        return tvaByIdTva;
    }

    public void setTvaByIdTva(TvaEntity tvaByIdTva) {
        this.tvaByIdTva = tvaByIdTva;
    }

    @ManyToOne
    @JoinColumn(name = "id_chambre", referencedColumnName = "id", nullable = false)
    public ChambreEntity getChambreByIdChambre() {
        return chambreByIdChambre;
    }

    public void setChambreByIdChambre(ChambreEntity chambreByIdChambre) {
        this.chambreByIdChambre = chambreByIdChambre;
    }
}
