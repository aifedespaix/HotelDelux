package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Droit {
    private int id;
    private String code;
    private String description;
    private boolean visible;
    private boolean modifiable;
    private Collection<DroitRoleAssoc> droitRoleAssocsById;

    public Droit(int id, String code, String description, boolean visible, boolean modifiable,
			Collection<DroitRoleAssoc> droitRoleAssocsById) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.visible = visible;
		this.modifiable = modifiable;
		this.droitRoleAssocsById = droitRoleAssocsById;
	}

	public Droit(String code, String description, boolean visible, boolean modifiable,
			Collection<DroitRoleAssoc> droitRoleAssocsById) {
		super();
		this.code = code;
		this.description = description;
		this.visible = visible;
		this.modifiable = modifiable;
		this.droitRoleAssocsById = droitRoleAssocsById;
	}

	public Droit() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Droit [id=" + id + ", code=" + code + ", description=" + description + ", visible=" + visible
				+ ", modifiable=" + modifiable + ", droitRoleAssocsById=" + droitRoleAssocsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Basic
    @Column(name = "modifiable", nullable = false)
    public boolean getModifiable() {
        return modifiable;
    }
    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
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
    @Column(name = "code", nullable = false, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "visible", nullable = false)
    public boolean getVisible() {
        return visible;
    }

    @OneToMany(mappedBy = "droitByIdDroit")
    public Collection<DroitRoleAssoc> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssoc> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }
}
