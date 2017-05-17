package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "demande_utilisateur", schema = "base_definitive", catalog = "")
public class DemandeUtilisateurEntity {
    private int id;
    private UtilisateurEntity utilisateurByIdUtilisateur;
    private DemandeInterventionEntity demandeInterventionByIdDemande;

    
    public DemandeUtilisateurEntity(int id,
			UtilisateurEntity utilisateurByIdUtilisateur, DemandeInterventionEntity demandeInterventionByIdDemande) {
		super();
		this.id = id;
		this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
		this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
	}

	public DemandeUtilisateurEntity(UtilisateurEntity utilisateurByIdUtilisateur,
			DemandeInterventionEntity demandeInterventionByIdDemande) {
		super();
		this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
		this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
	}

	public DemandeUtilisateurEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DemandeUtilisateurEntity [id=" + id + ", idUtilisateur=" + ", idDemande="
				+ ", utilisateurByIdUtilisateur=" + utilisateurByIdUtilisateur + ", demandeInterventionByIdDemande="
				+ demandeInterventionByIdDemande + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
