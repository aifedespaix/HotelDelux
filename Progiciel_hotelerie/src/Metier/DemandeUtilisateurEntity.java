package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "demande_utilisateur", schema = "base_definitive", catalog = "")
public class DemandeUtilisateurEntity {
    private int id;
    private int idUtilisateur;
    private int idDemande;
    private UtilisateurEntity utilisateurByIdUtilisateur;
    private DemandeInterventionEntity demandeInterventionByIdDemande;

    
    public DemandeUtilisateurEntity(int id, int idUtilisateur, int idDemande,
			UtilisateurEntity utilisateurByIdUtilisateur, DemandeInterventionEntity demandeInterventionByIdDemande) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		this.idDemande = idDemande;
		this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
		this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
	}

	public DemandeUtilisateurEntity(int idUtilisateur, int idDemande, UtilisateurEntity utilisateurByIdUtilisateur,
			DemandeInterventionEntity demandeInterventionByIdDemande) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.idDemande = idDemande;
		this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
		this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
	}

	public DemandeUtilisateurEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DemandeUtilisateurEntity [id=" + id + ", idUtilisateur=" + idUtilisateur + ", idDemande=" + idDemande
				+ ", utilisateurByIdUtilisateur=" + utilisateurByIdUtilisateur + ", demandeInterventionByIdDemande="
				+ demandeInterventionByIdDemande + "]";
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
    @Column(name = "id_utilisateur", nullable = false)
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "id_demande", nullable = false)
    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemandeUtilisateurEntity that = (DemandeUtilisateurEntity) o;

        if (id != that.id) return false;
        if (idUtilisateur != that.idUtilisateur) return false;
        if (idDemande != that.idDemande) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idUtilisateur;
        result = 31 * result + idDemande;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id", nullable = false)
    public UtilisateurEntity getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(UtilisateurEntity utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }

    @ManyToOne
    @JoinColumn(name = "id_demande", referencedColumnName = "id", nullable = false)
    public DemandeInterventionEntity getDemandeInterventionByIdDemande() {
        return demandeInterventionByIdDemande;
    }

    public void setDemandeInterventionByIdDemande(DemandeInterventionEntity demandeInterventionByIdDemande) {
        this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
    }
}
