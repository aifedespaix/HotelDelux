package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "equipement_spa", schema = "base_definitive", catalog = "")
public class EquipementSpaEntity {
    private int id;
    private String libelle;
    private String description;
    private String photo;
    private int idSpa;
    private Collection<DemandeInterventionEntity> demandeInterventionsById;
    private SpaEntity spaByIdSpa;

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

    @Basic
    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo", nullable = false, length = 250)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "id_spa", nullable = false)
    public int getIdSpa() {
        return idSpa;
    }

    public void setIdSpa(int idSpa) {
        this.idSpa = idSpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipementSpaEntity that = (EquipementSpaEntity) o;

        if (id != that.id) return false;
        if (idSpa != that.idSpa) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + idSpa;
        return result;
    }

    @OneToMany(mappedBy = "equipementSpaByIdEquipementSpa")
    public Collection<DemandeInterventionEntity> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeInterventionEntity> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_spa", referencedColumnName = "id", nullable = false)
    public SpaEntity getSpaByIdSpa() {
        return spaByIdSpa;
    }

    public void setSpaByIdSpa(SpaEntity spaByIdSpa) {
        this.spaByIdSpa = spaByIdSpa;
    }
}
