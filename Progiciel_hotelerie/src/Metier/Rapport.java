package src.Metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Rapport {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private DemandeIntervention demandeInterventionByIdDemandeIntervention;

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
    @Column(name = "date_fin", nullable = false)
    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_demande_intervention", referencedColumnName = "id", nullable = false)
    public DemandeIntervention getDemandeInterventionByIdDemandeIntervention() {
        return demandeInterventionByIdDemandeIntervention;
    }

    public void setDemandeInterventionByIdDemandeIntervention(DemandeIntervention demandeInterventionByIdDemandeIntervention) {
        this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
    }
}
