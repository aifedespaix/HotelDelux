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
    private int idTva;
    private int idSpa;
    private TvaEntity tvaByIdTva;
    private SpaEntity spaByIdSpa;

    
    
    public ReservationSpaEntity(int id, Date dateDebut, Date dateArrivee, int idTva, int idSpa, TvaEntity tvaByIdTva,
			SpaEntity spaByIdSpa) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateArrivee = dateArrivee;
		this.idTva = idTva;
		this.idSpa = idSpa;
		this.tvaByIdTva = tvaByIdTva;
		this.spaByIdSpa = spaByIdSpa;
	}
    
    

	public ReservationSpaEntity(Date dateDebut, Date dateArrivee, int idTva, int idSpa, TvaEntity tvaByIdTva,
			SpaEntity spaByIdSpa) {
		super();
		this.dateDebut = dateDebut;
		this.dateArrivee = dateArrivee;
		this.idTva = idTva;
		this.idSpa = idSpa;
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
				+ ", idTva=" + idTva + ", idSpa=" + idSpa + ", tvaByIdTva=" + tvaByIdTva + ", spaByIdSpa=" + spaByIdSpa
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

    @Basic
    @Column(name = "id_tva", nullable = false)
    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    @Basic
    @Column(name = "id_spa", nullable = false)
    public int getIdSpa() {
        return idSpa;
    }

    public void setIdSpa(int idSpa) {
        this.idSpa = idSpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationSpaEntity that = (ReservationSpaEntity) o;

        if (id != that.id) return false;
        if (idTva != that.idTva) return false;
        if (idSpa != that.idSpa) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateArrivee != null ? !dateArrivee.equals(that.dateArrivee) : that.dateArrivee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateArrivee != null ? dateArrivee.hashCode() : 0);
        result = 31 * result + idTva;
        result = 31 * result + idSpa;
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
    @JoinColumn(name = "id_spa", referencedColumnName = "id", nullable = false)
    public SpaEntity getSpaByIdSpa() {
        return spaByIdSpa;
    }

    public void setSpaByIdSpa(SpaEntity spaByIdSpa) {
        this.spaByIdSpa = spaByIdSpa;
    }
}
