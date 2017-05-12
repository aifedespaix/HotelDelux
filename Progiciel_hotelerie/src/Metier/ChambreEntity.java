package src.Metier;

import javax.persistence.*;

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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prix_adulte")
    public double getPrixAdulte() {
        return prixAdulte;
    }

    public void setPrixAdulte(double prixAdulte) {
        this.prixAdulte = prixAdulte;
    }

    @Basic
    @Column(name = "prix_enfant")
    public double getPrixEnfant() {
        return prixEnfant;
    }

    public void setPrixEnfant(double prixEnfant) {
        this.prixEnfant = prixEnfant;
    }

    @Basic
    @Column(name = "capacite")
    public double getCapacite() {
        return capacite;
    }

    public void setCapacite(double capacite) {
        this.capacite = capacite;
    }

    @Basic
    @Column(name = "etage")
    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChambreEntity that = (ChambreEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.prixAdulte, prixAdulte) != 0) return false;
        if (Double.compare(that.prixEnfant, prixEnfant) != 0) return false;
        if (Double.compare(that.capacite, capacite) != 0) return false;
        if (etage != that.etage) return false;

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
