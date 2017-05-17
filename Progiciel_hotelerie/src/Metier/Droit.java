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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Droit droit = (Droit) o;

        if (id != droit.id) return false;
        if (visible != droit.visible) return false;
        if (modifiable != droit.modifiable) return false;
        if (code != null ? !code.equals(droit.code) : droit.code != null) return false;
        if (description != null ? !description.equals(droit.description) : droit.description != null) return false;

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
    public Collection<DroitRoleAssoc> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssoc> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }
}
