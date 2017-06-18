package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Chambre {
    private int id;
    private Integer numeroChambre;
    private double prix;
    private int capacite;
    private int etage;    
    private Collection<EquipementHotel> equipementHotelsById;
    private Collection<ReservationHotel> reservationHotelsById;

    public Chambre(int id,int numeroChambre, double prix, int capacite, int etage,
			Collection<EquipementHotel> equipementHotelsById, Collection<ReservationHotel> reservationHotelsById) {
		super();
		this.id = id;
		this.numeroChambre = numeroChambre;
		this.prix = prix;
		this.capacite = capacite;
		this.etage = etage;
		this.equipementHotelsById = equipementHotelsById;
		this.reservationHotelsById = reservationHotelsById;
	}

	public Chambre(int numeroChambre, double prix, int capacite, int etage,
			Collection<EquipementHotel> equipementHotelsById, Collection<ReservationHotel> reservationHotelsById) {
		super();
		this.numeroChambre = numeroChambre;
		this.prix = prix;
		this.capacite = capacite;
		this.etage = etage;
		this.equipementHotelsById = equipementHotelsById;
		this.reservationHotelsById = reservationHotelsById;
	}

	public Chambre() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return numeroChambre.toString();
	}

	public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setEtage(Integer etage) {
        this.etage = etage;
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
    @Column(name = "prix", nullable = false, precision = 0)
    public double getPrix() {
        return this.prix;
    }

    @Basic
    @Column(name = "numero_chambre", nullable = false)
    public int getNumeroChambre() {
        return this.numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }
    
    @Basic
    @Column(name = "etage", nullable = false)
    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    @OneToMany(mappedBy = "chambreByIdChambre")
    public Collection<EquipementHotel> getEquipementHotelsById() {
        return equipementHotelsById;
    }

    public void setEquipementHotelsById(Collection<EquipementHotel> equipementHotelsById) {
        this.equipementHotelsById = equipementHotelsById;
    }

    @OneToMany(mappedBy = "chambreByIdChambre")
    public Collection<ReservationHotel> getReservationHotelsById() {
        return reservationHotelsById;
    }

    public void setReservationHotelsById(Collection<ReservationHotel> reservationHotelsById) {
        this.reservationHotelsById = reservationHotelsById;
    }
}
