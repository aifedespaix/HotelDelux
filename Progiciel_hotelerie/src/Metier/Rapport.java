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

    public Rapport(int id, Date dateDebut, Date dateFin, String description,
			DemandeIntervention demandeInterventionByIdDemandeIntervention) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
	}

	public Rapport(Date dateDebut, Date dateFin, String description,
			DemandeIntervention demandeInterventionByIdDemandeIntervention) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
	}

	public Rapport() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Rapport [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description="
				+ description + ", demandeInterventionByIdDemandeIntervention="
				+ demandeInterventionByIdDemandeIntervention + "]";
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
