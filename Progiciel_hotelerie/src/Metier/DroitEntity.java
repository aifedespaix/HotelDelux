package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "droit", schema = "base_definitive", catalog = "")
public class DroitEntity {
    private int id;
    private String code;
    private String description;
    private Boolean visible;
    private Boolean modifiable;
    private Collection<DroitRoleAssocEntity> droitRoleAssocsById;

    
    public DroitEntity(int id, String code, String description, Boolean visible, Boolean modifiable,
			Collection<DroitRoleAssocEntity> droitRoleAssocsById) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.visible = visible;
		this.modifiable = modifiable;
		this.droitRoleAssocsById = droitRoleAssocsById;
	}
    
	public DroitEntity(String code, String description, Boolean visible, Boolean modifiable,
			Collection<DroitRoleAssocEntity> droitRoleAssocsById) {
		super();
		this.code = code;
		this.description = description;
		this.visible = visible;
		this.modifiable = modifiable;
		this.droitRoleAssocsById = droitRoleAssocsById;
	}

	public DroitEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DroitEntity [id=" + id + ", code=" + code + ", description=" + description + ", visible=" + visible
				+ ", modifiable=" + modifiable + ", droitRoleAssocsById=" + droitRoleAssocsById + "]";
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
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Basic
    @Column(name = "modifiable", nullable = false)
    public Boolean getModifiable() {
        return modifiable;
    }

    public void setModifiable(Boolean modifiable) {
        this.modifiable = modifiable;
    }

    @OneToMany(mappedBy = "droitByIdDroit")
    public Collection<DroitRoleAssocEntity> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssocEntity> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }
}
