package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "chambre", schema = "base_definitive", catalog = "")
public class ChambreEntity {
    private int id;
    private double prixAdulte;
    private double prixEnfant;
    private double capacite;
    private int etage;
    private Collection<EquipementHotelEntity> equipementHotelsById;
    private Collection<ReservationHotelEntity> reservationHotelsById;

    public ChambreEntity(int id, double prixAdulte, double prixEnfant, double capacite, int etage,
			Collection<EquipementHotelEntity> equipementHotelsById,
			Collection<ReservationHotelEntity> reservationHotelsById) {
		super();
		this.id = id;
		this.prixAdulte = prixAdulte;
		this.prixEnfant = prixEnfant;
		this.capacite = capacite;
		this.etage = etage;
		this.equipementHotelsById = equipementHotelsById;
		this.reservationHotelsById = reservationHotelsById;
	}

	public ChambreEntity(double prixAdulte, double prixEnfant, double capacite, int etage,
			Collection<EquipementHotelEntity> equipementHotelsById,
			Collection<ReservationHotelEntity> reservationHotelsById) {
		super();
		this.prixAdulte = prixAdulte;
		this.prixEnfant = prixEnfant;
		this.capacite = capacite;
		this.etage = etage;
		this.equipementHotelsById = equipementHotelsById;
		this.reservationHotelsById = reservationHotelsById;
	}

	public ChambreEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ChambreEntity [id=" + id + ", prixAdulte=" + prixAdulte + ", prixEnfant=" + prixEnfant + ", capacite="
				+ capacite + ", etage=" + etage + ", equipementHotelsById=" + equipementHotelsById
				+ ", reservationHotelsById=" + reservationHotelsById + "]";
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
    @Column(name = "prix_adulte", nullable = false, precision = 0)
    public double getPrixAdulte() {
        return prixAdulte;
    }

    public void setPrixAdulte(double prixAdulte) {
        this.prixAdulte = prixAdulte;
    }

    @Basic
    @Column(name = "prix_enfant", nullable = false, precision = 0)
    public double getPrixEnfant() {
        return prixEnfant;
    }

    public void setPrixEnfant(double prixEnfant) {
        this.prixEnfant = prixEnfant;
    }

    @Basic
    @Column(name = "capacite", nullable = false, precision = 0)
    public double getCapacite() {
        return capacite;
    }

    public void setCapacite(double capacite) {
        this.capacite = capacite;
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
    public Collection<EquipementHotelEntity> getEquipementHotelsById() {
        return equipementHotelsById;
    }

    public void setEquipementHotelsById(Collection<EquipementHotelEntity> equipementHotelsById) {
        this.equipementHotelsById = equipementHotelsById;
    }

    @OneToMany(mappedBy = "chambreByIdChambre")
    public Collection<ReservationHotelEntity> getReservationHotelsById() {
        return reservationHotelsById;
    }

    public void setReservationHotelsById(Collection<ReservationHotelEntity> reservationHotelsById) {
        this.reservationHotelsById = reservationHotelsById;
    }
}