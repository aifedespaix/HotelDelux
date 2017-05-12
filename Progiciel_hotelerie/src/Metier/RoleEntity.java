package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "role", schema = "base_definitive", catalog = "")
public class RoleEntity {
    private int id;
    private String libelle;
    private Collection<DroitRoleAssocEntity> droitRoleAssocsById;
    private Collection<UtilisateurEntity> utilisateursById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<DroitRoleAssocEntity> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssocEntity> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<UtilisateurEntity> getUtilisateursById() {
        return utilisateursById;
    }

    public void setUtilisateursById(Collection<UtilisateurEntity> utilisateursById) {
        this.utilisateursById = utilisateursById;
    }
}
