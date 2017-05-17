package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "droit_role_assoc", schema = "hotel", catalog = "")
public class DroitRoleAssoc {
    private int id;
    private int idDroit;
    private int idRole;
    private Droit droitByIdDroit;
    private Role roleByIdRole;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdDroit(Integer idDroit) {
        this.idDroit = idDroit;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
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
    @JoinColumn(name = "id_droit", referencedColumnName = "id", nullable = false)
    public Droit getDroitByIdDroit() {
        return droitByIdDroit;
    }

    public void setDroitByIdDroit(Droit droitByIdDroit) {
        this.droitByIdDroit = droitByIdDroit;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    public Role getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(Role roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }
}
