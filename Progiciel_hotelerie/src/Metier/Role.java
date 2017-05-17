package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Role {
    private int id;
    private String libelle;
    private Collection<DroitRoleAssoc> droitRoleAssocsById;
    private Collection<Utilisateur> utilisateursById;

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
    @Column(name = "libelle", nullable = false, length = 250)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<DroitRoleAssoc> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssoc> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<Utilisateur> getUtilisateursById() {
        return utilisateursById;
    }

    public void setUtilisateursById(Collection<Utilisateur> utilisateursById) {
        this.utilisateursById = utilisateursById;
    }
}
