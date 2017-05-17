package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "demande_utilisateur", schema = "hotel", catalog = "")
public class DemandeUtilisateur {
    private int id;
    private Utilisateur utilisateurByIdUtilisateur;
    private DemandeIntervention demandeInterventionByIdDemande;

    public DemandeUtilisateur(int id, Utilisateur utilisateurByIdUtilisateur,
			DemandeIntervention demandeInterventionByIdDemande) {
		super();
		this.id = id;
		this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
		this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
	}

	public DemandeUtilisateur(Utilisateur utilisateurByIdUtilisateur,
			DemandeIntervention demandeInterventionByIdDemande) {
		super();
		this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
		this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
	}

	public DemandeUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DemandeUtilisateur [id=" + id + ", utilisateurByIdUtilisateur=" + utilisateurByIdUtilisateur
				+ ", demandeInterventionByIdDemande=" + demandeInterventionByIdDemande + "]";
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

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id", nullable = false)
    public Utilisateur getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(Utilisateur utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }

    @ManyToOne
    @JoinColumn(name = "id_demande", referencedColumnName = "id", nullable = false)
    public DemandeIntervention getDemandeInterventionByIdDemande() {
        return demandeInterventionByIdDemande;
    }

    public void setDemandeInterventionByIdDemande(DemandeIntervention demandeInterventionByIdDemande) {
        this.demandeInterventionByIdDemande = demandeInterventionByIdDemande;
    }
}
