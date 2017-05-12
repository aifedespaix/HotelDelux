package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "aliment", schema = "base_definitive", catalog = "")
public class AlimentEntity {
    private int id;
    private String libelle;
    private double prix;
    private Collection<AlimentCommandeAssocEntity> alimentCommandeAssocsById;
    private Collection<PlatAlimentAssocEntity> platAlimentAssocsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle", nullable = false, length = 250)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "prix", nullable = false, precision = 0)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlimentEntity that = (AlimentEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.prix, prix) != 0) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "alimentByIdAliment")
    public Collection<AlimentCommandeAssocEntity> getAlimentCommandeAssocsById() {
        return alimentCommandeAssocsById;
    }

    public void setAlimentCommandeAssocsById(Collection<AlimentCommandeAssocEntity> alimentCommandeAssocsById) {
        this.alimentCommandeAssocsById = alimentCommandeAssocsById;
    }

    @OneToMany(mappedBy = "alimentByIdAliment")
    public Collection<PlatAlimentAssocEntity> getPlatAlimentAssocsById() {
        return platAlimentAssocsById;
    }

    public void setPlatAlimentAssocsById(Collection<PlatAlimentAssocEntity> platAlimentAssocsById) {
        this.platAlimentAssocsById = platAlimentAssocsById;
    }
}
