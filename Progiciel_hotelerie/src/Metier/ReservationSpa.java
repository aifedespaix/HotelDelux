package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "reservation_spa", schema = "hotel", catalog = "")
public class ReservationSpa {
    private int id;
    private Date dateDebut;
    private Date dateArrivee;
    private Tva tvaByIdTva;
    private Spa spaByIdSpa;
    private Collection<FacturationAssoc> facturationAssocsById;

    public ReservationSpa(int id, Date dateDebut, Date dateArrivee, Tva tvaByIdTva, Spa spaByIdSpa,
			Collection<FacturationAssoc> facturationAssocsById) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateArrivee = dateArrivee;
		this.tvaByIdTva = tvaByIdTva;
		this.spaByIdSpa = spaByIdSpa;
		this.facturationAssocsById = facturationAssocsById;
	}

	public ReservationSpa(Date dateDebut, Date dateArrivee, Tva tvaByIdTva, Spa spaByIdSpa,
			Collection<FacturationAssoc> facturationAssocsById) {
		super();
		this.dateDebut = dateDebut;
		this.dateArrivee = dateArrivee;
		this.tvaByIdTva = tvaByIdTva;
		this.spaByIdSpa = spaByIdSpa;
		this.facturationAssocsById = facturationAssocsById;
	}

	public ReservationSpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReservationSpa [id=" + id + ", dateDebut=" + dateDebut + ", dateArrivee=" + dateArrivee
				+ ", tvaByIdTva=" + tvaByIdTva + ", spaByIdSpa=" + spaByIdSpa + ", facturationAssocsById="
				+ facturationAssocsById + "]";
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
    public Tva getTvaByIdTva() {
        return tvaByIdTva;
    }

    public void setTvaByIdTva(Tva tvaByIdTva) {
        this.tvaByIdTva = tvaByIdTva;
    }

    @ManyToOne
    @JoinColumn(name = "id_spa", referencedColumnName = "id", nullable = false)
    public Spa getSpaByIdSpa() {
        return spaByIdSpa;
    }

    public void setSpaByIdSpa(Spa spaByIdSpa) {
        this.spaByIdSpa = spaByIdSpa;
    }

    @OneToMany(mappedBy = "reservationSpaByIdReservationSpa")
    public Collection<FacturationAssoc> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssoc> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }
}
