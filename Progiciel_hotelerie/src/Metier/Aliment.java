package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Aliment {
    private int id;
    private String libelle;
    private double prix;
    private Collection<AlimentCommandeAssoc> alimentCommandeAssocsById;
    private Collection<PlatAlimentAssoc> platAlimentAssocsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
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

    @OneToMany(mappedBy = "alimentByIdAliment")
    public Collection<AlimentCommandeAssoc> getAlimentCommandeAssocsById() {
        return alimentCommandeAssocsById;
    }

    public void setAlimentCommandeAssocsById(Collection<AlimentCommandeAssoc> alimentCommandeAssocsById) {
        this.alimentCommandeAssocsById = alimentCommandeAssocsById;
    }

    @OneToMany(mappedBy = "alimentByIdAliment")
    public Collection<PlatAlimentAssoc> getPlatAlimentAssocsById() {
        return platAlimentAssocsById;
    }

    public void setPlatAlimentAssocsById(Collection<PlatAlimentAssoc> platAlimentAssocsById) {
        this.platAlimentAssocsById = platAlimentAssocsById;
    }
}