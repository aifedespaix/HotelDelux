package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "droit_role_assoc", schema = "base_definitive", catalog = "")
public class DroitRoleAssocEntity {
    private int id;
    private DroitEntity droitByIdDroit;
    private RoleEntity roleByIdRole;

    
    public DroitRoleAssocEntity(int id, DroitEntity droitByIdDroit, RoleEntity roleByIdRole) {
		super();
		this.id = id;
		this.droitByIdDroit = droitByIdDroit;
		this.roleByIdRole = roleByIdRole;
	}
    
    

	public DroitRoleAssocEntity(DroitEntity droitByIdDroit, RoleEntity roleByIdRole) {
		super();
		this.droitByIdDroit = droitByIdDroit;
		this.roleByIdRole = roleByIdRole;
	}



	public DroitRoleAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	@Override
	public String toString() {
		return "DroitRoleAssocEntity [id=" + id + ", idDroit=" + ", idRole=" + ", droitByIdDroit="
				+ droitByIdDroit + ", roleByIdRole=" + roleByIdRole + "]";
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
