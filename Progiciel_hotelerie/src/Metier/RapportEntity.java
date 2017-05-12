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
    private int idDemandeIntervention;
    private DemandeInterventionEntity demandeInterventionByIdDemandeIntervention;

    
    
    public RapportEntity(int id, Date dateDebut, Date dateFin, String description, int idDemandeIntervention,
			DemandeInterventionEntity demandeInterventionByIdDemandeIntervention) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.idDemandeIntervention = idDemandeIntervention;
		this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
	}

    
	public RapportEntity(Date dateDebut, Date dateFin, String description, int idDemandeIntervention,
			DemandeInterventionEntity demandeInterventionByIdDemandeIntervention) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.idDemandeIntervention = idDemandeIntervention;
		this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
	}


	public RapportEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "RapportEntity [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description="
				+ description + ", idDemandeIntervention=" + idDemandeIntervention
				+ ", demandeInterventionByIdDemandeIntervention=" + demandeInterventionByIdDemandeIntervention + "]";
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

        RapportEntity that = (RapportEntity) o;

        if (id != that.id) return false;
        if (idDemandeIntervention != that.idDemandeIntervention) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

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
    public DemandeInterventionEntity getDemandeInterventionByIdDemandeIntervention() {
        return demandeInterventionByIdDemandeIntervention;
    }

    public void setDemandeInterventionByIdDemandeIntervention(DemandeInterventionEntity demandeInterventionByIdDemandeIntervention) {
        this.demandeInterventionByIdDemandeIntervention = demandeInterventionByIdDemandeIntervention;
    }
}
