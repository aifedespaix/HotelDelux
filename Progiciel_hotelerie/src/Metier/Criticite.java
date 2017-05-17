package src.Metier;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Criticite {
    private int id;
    private String libelle;
    private Time tempsMaximum;
    private Collection<DemandeIntervention> demandeInterventionsById;

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
    @Column(name = "libelle", nullable = false, length = 250)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "temps_maximum", nullable = false)
    public Time getTempsMaximum() {
        return tempsMaximum;
    }

    public void setTempsMaximum(Time tempsMaximum) {
        this.tempsMaximum = tempsMaximum;
    }

    @OneToMany(mappedBy = "criticiteByIdCriticite")
    public Collection<DemandeIntervention> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeIntervention> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }
}
