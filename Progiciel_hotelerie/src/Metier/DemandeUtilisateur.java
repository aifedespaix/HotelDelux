package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "demande_utilisateur", schema = "base_definitive", catalog = "")
public class DemandeUtilisateur {
    private int id;
    private int idUtilisateur;
    private int idDemande;
    private Utilisateur utilisateurByIdUtilisateur;
    private DemandeIntervention demandeInterventionByIdDemande;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
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

        DemandeUtilisateur that = (DemandeUtilisateur) o;

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
