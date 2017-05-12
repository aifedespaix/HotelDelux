package src.Metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "reservation_spa", schema = "base_definitive", catalog = "")
public class ReservationSpaEntity {
    private int id;
    private Date dateDebut;
    private Date dateArrivee;
    private TvaEntity tvaByIdTva;
    private SpaEntity spaByIdSpa;

    
    
    public ReservationSpaEntity(int id, Date dateDebut, Date dateArrivee, TvaEntity tvaByIdTva,
			SpaEntity spaByIdSpa) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateArrivee = dateArrivee;
		this.tvaByIdTva = tvaByIdTva;
		this.spaByIdSpa = spaByIdSpa;
	}
    
    

	public ReservationSpaEntity(Date dateDebut, Date dateArrivee, TvaEntity tvaByIdTva,
			SpaEntity spaByIdSpa) {
		super();
		this.dateDebut = dateDebut;
		this.dateArrivee = dateArrivee;
		this.tvaByIdTva = tvaByIdTva;
		this.spaByIdSpa = spaByIdSpa;
	}



	public ReservationSpaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "ReservationSpaEntity [id=" + id + ", dateDebut=" + dateDebut + ", dateArrivee=" + dateArrivee
				+ ", tvaByIdTva=" + tvaByIdTva + ", spaByIdSpa=" + spaByIdSpa
				+ "]";
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
    @Column(name = "date_debut", nullable = false)
    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "date_arrivee", nullable = false)
    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
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
    @JoinColumn(name = "id_spa", referencedColumnName = "id", nullable = false)
    public SpaEntity getSpaByIdSpa() {
        return spaByIdSpa;
    }

    public void setSpaByIdSpa(SpaEntity spaByIdSpa) {
        this.spaByIdSpa = spaByIdSpa;
    }
}
