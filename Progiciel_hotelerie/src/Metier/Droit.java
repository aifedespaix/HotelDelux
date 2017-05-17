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
    private byte visible;
    private byte modifiable;
    private Collection<DroitRoleAssoc> droitRoleAssocsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVisible(Byte visible) {
        this.visible = visible;
    }

    public void setModifiable(Byte modifiable) {
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
    public byte getVisible() {
        return visible;
    }

    public void setVisible(byte visible) {
        this.visible = visible;
    }

    @Basic
    @Column(name = "modifiable", nullable = false)
    public byte getModifiable() {
        return modifiable;
    }

    public void setModifiable(byte modifiable) {
        this.modifiable = modifiable;
    }

    @OneToMany(mappedBy = "droitByIdDroit")
    public Collection<DroitRoleAssoc> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssoc> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }
}
