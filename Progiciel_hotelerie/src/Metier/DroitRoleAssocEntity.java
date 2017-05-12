package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "droit_role_assoc", schema = "base_definitive", catalog = "")
public class DroitRoleAssocEntity {
    private int id;
    private int idDroit;
    private int idRole;
    private DroitEntity droitByIdDroit;
    private RoleEntity roleByIdRole;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_droit", nullable = false)
    public int getIdDroit() {
        return idDroit;
    }

    public void setIdDroit(int idDroit) {
        this.idDroit = idDroit;
    }

    @Basic
    @Column(name = "id_role", nullable = false)
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DroitRoleAssocEntity that = (DroitRoleAssocEntity) o;

        if (id != that.id) return false;
        if (idDroit != that.idDroit) return false;
        if (idRole != that.idRole) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idDroit;
        result = 31 * result + idRole;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_droit", referencedColumnName = "id", nullable = false)
    public DroitEntity getDroitByIdDroit() {
        return droitByIdDroit;
    }

    public void setDroitByIdDroit(DroitEntity droitByIdDroit) {
        this.droitByIdDroit = droitByIdDroit;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    public RoleEntity getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(RoleEntity roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }
}
