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
    private int idDemandeIntervention;
    private DemandeIntervention demandeInterventionByIdDemandeIntervention;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdDemandeIntervention(Integer idDemandeIntervention) {
        this.idDemandeIntervention = idDemandeIntervention;
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

    @Basic
    @Column(name = "id_demande_intervention", nullable = false)
    public int getIdDemandeIntervention() {
        return idDemandeIntervention;
    }

    public void setIdDemandeIntervention(int idDemandeIntervention) {
        this.idDemandeIntervention = idDemandeIntervention;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rapport rapport = (Rapport) o;

        if (id != rapport.id) return false;
        if (idDemandeIntervention != rapport.idDemandeIntervention) return false;
        if (dateDebut != null ? !dateDebut.equals(rapport.dateDebut) : rapport.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(rapport.dateFin) : rapport.dateFin != null) return false;
        if (description != null ? !description.equals(rapport.description) : rapport.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + idDemandeIntervention;
        return result;
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
