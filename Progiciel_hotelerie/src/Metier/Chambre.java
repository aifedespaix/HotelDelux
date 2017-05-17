package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Chambre {
    private int id;
    private double prixAdulte;
    private double prixEnfant;
    private double capacite;
    private int etage;
    private Collection<EquipementHotel> equipementHotelsById;
    private Collection<ReservationHotel> reservationHotelsById;

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrixAdulte(Double prixAdulte) {
        this.prixAdulte = prixAdulte;
    }

    public void setPrixEnfant(Double prixEnfant) {
        this.prixEnfant = prixEnfant;
    }

    public void setCapacite(Double capacite) {
        this.capacite = capacite;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chambre chambre = (Chambre) o;

        if (id != chambre.id) return false;
        if (Double.compare(chambre.prixAdulte, prixAdulte) != 0) return false;
        if (Double.compare(chambre.prixEnfant, prixEnfant) != 0) return false;
        if (Double.compare(chambre.capacite, capacite) != 0) return false;
        if (etage != chambre.etage) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(prixAdulte);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(prixEnfant);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(capacite);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + etage;
        return result;
    }
}
