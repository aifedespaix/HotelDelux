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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_utilisateur")
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "id_demande")
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
}
