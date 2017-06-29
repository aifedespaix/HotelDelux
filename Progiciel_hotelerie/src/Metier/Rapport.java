package src.Metier;

import javax.persistence.*;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.sql.Date;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Rapport extends RecursiveTreeObject<Rapport> {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private DemandeIntervention demandeIntervention;
    private Utilisateur technicien;

    public Rapport(int id, Date dateDebut, Date dateFin, String description,
			DemandeIntervention demandeItervention, Utilisateur technicien) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.demandeIntervention = demandeItervention;
		this.technicien = technicien;
	}

	public Rapport(Date dateDebut, Date dateFin, String description,
			DemandeIntervention demandeIntervention, Utilisateur technicien) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.demandeIntervention = demandeIntervention;
		this.technicien = technicien;
	}

	public Rapport() {
		super();
	}

	@Override
	public String toString() {
		return "Rapport [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description="
				+ description + ", demandeIntervention="
				+ demandeIntervention + "]";
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
    
    @OneToOne
    @JoinColumn(name = "id_demande_intervention", referencedColumnName = "id", nullable = false)
    public DemandeIntervention getDemandeIntervention() {
        return demandeIntervention;
    }

    public void setDemandeIntervention(DemandeIntervention demandeIntervention) {
        this.demandeIntervention = demandeIntervention;
    }

    @ManyToOne
    @JoinColumn(name = "id_technicien", referencedColumnName = "id")
	public Utilisateur getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Utilisateur technicien) {
		this.technicien = technicien;
	}
}
