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
    private int idTva;
    private int idChambre;
    private TvaEntity tvaByIdTva;
    private ChambreEntity chambreByIdChambre;

    
    public ReservationHotelEntity(int id, Date dateArrivee, Date dateDebut, int idTva, int idChambre,
			TvaEntity tvaByIdTva, ChambreEntity chambreByIdChambre) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDebut = dateDebut;
		this.idTva = idTva;
		this.idChambre = idChambre;
		this.tvaByIdTva = tvaByIdTva;
		this.chambreByIdChambre = chambreByIdChambre;
	}

    
	public ReservationHotelEntity(Date dateArrivee, Date dateDebut, int idTva, int idChambre, TvaEntity tvaByIdTva,
			ChambreEntity chambreByIdChambre) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDebut = dateDebut;
		this.idTva = idTva;
		this.idChambre = idChambre;
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
				+ ", idTva=" + idTva + ", idChambre=" + idChambre + ", tvaByIdTva=" + tvaByIdTva
				+ ", chambreByIdChambre=" + chambreByIdChambre + "]";
	}


	@Basic
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

    @Basic
    @Column(name = "id_tva", nullable = false)
    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    @Basic
    @Column(name = "id_chambre", nullable = false)
    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationHotelEntity that = (ReservationHotelEntity) o;

        if (id != that.id) return false;
        if (idTva != that.idTva) return false;
        if (idChambre != that.idChambre) return false;
        if (dateArrivee != null ? !dateArrivee.equals(that.dateArrivee) : that.dateArrivee != null) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateArrivee != null ? dateArrivee.hashCode() : 0);
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + idTva;
        result = 31 * result + idChambre;
        return result;
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
