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
    private byte visible;
    private byte modifiable;
    private Collection<DroitRoleAssocEntity> droitRoleAssocsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DroitEntity that = (DroitEntity) o;

        if (id != that.id) return false;
        if (visible != that.visible) return false;
        if (modifiable != that.modifiable) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) visible;
        result = 31 * result + (int) modifiable;
        return result;
    }

    @OneToMany(mappedBy = "droitByIdDroit")
    public Collection<DroitRoleAssocEntity> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssocEntity> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }
}
