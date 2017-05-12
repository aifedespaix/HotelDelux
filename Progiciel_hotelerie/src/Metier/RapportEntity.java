package src.Metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "rapport", schema = "base_definitive", catalog = "")
public class RapportEntity {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private DemandeInterventionEntity demandeInterventionByIdDemandeIntervention;

    
    
    public RapportEntity(int id, Date dateDebut, Date dateFin, String description,
			DemandeInterventionEntity demandeInterventionByIdDemandeIntervention) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
	}

    
	public RapportEntity(Date dateDebut, Date dateFin, String description,
			DemandeInterventionEntity demandeInterventionByIdDemandeIntervention) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
	}


	public RapportEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "RapportEntity [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description="
				+ description + ", demandeInterventionByIdDemandeIntervention=" + demandeInterventionByIdDemandeIntervention + "]";
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
    public DemandeInterventionEntity getDemandeInterventionByIdDemandeIntervention() {
        return demandeInterventionByIdDemandeIntervention;
    }

    public void setDemandeInterventionByIdDemandeIntervention(DemandeInterventionEntity demandeInterventionByIdDemandeIntervention) {
        this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
    }
}
