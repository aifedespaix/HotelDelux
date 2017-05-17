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
    private Droit droitByIdDroit;
    private Role roleByIdRole;

    public DroitRoleAssoc(int id, Droit droitByIdDroit, Role roleByIdRole) {
		super();
		this.id = id;
		this.droitByIdDroit = droitByIdDroit;
		this.roleByIdRole = roleByIdRole;
	}

	public DroitRoleAssoc(Droit droitByIdDroit, Role roleByIdRole) {
		super();
		this.droitByIdDroit = droitByIdDroit;
		this.roleByIdRole = roleByIdRole;
	}

	public DroitRoleAssoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DroitRoleAssoc [id=" + id + ", droitByIdDroit=" + droitByIdDroit + ", roleByIdRole=" + roleByIdRole
				+ "]";
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
