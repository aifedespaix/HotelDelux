package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "equipement_hotel", schema = "hotel", catalog = "")
public class EquipementHotel {
    private int id;
    private String libelle;
    private String description;
    private String photo;
    private int idChambre;
    private Collection<DemandeIntervention> demandeInterventionsById;
    private Chambre chambreByIdChambre;
    private Collection<CommandeAssoc> commandeAssocsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdChambre(Integer idChambre) {
        this.idChambre = idChambre;
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
    @Column(name = "id_chambre", nullable = false, updatable = false,insertable = false)
    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipementHotel that = (EquipementHotel) o;

        if (id != that.id) return false;
        if (idChambre != that.idChambre) return false;
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
        result = 31 * result + idChambre;
        return result;
    }

    @OneToMany(mappedBy = "equipementHotelByIdEquipementHotel")
    public Collection<DemandeIntervention> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeIntervention> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_chambre", referencedColumnName = "id", nullable = false)
    public Chambre getChambreByIdChambre() {
        return chambreByIdChambre;
    }

    public void setChambreByIdChambre(Chambre chambreByIdChambre) {
        this.chambreByIdChambre = chambreByIdChambre;
    }

    @OneToMany(mappedBy = "equipementHotelByIdEquipementHotel")
    public Collection<CommandeAssoc> getCommandeAssocsById() {
        return commandeAssocsById;
    }

    public void setCommandeAssocsById(Collection<CommandeAssoc> commandeAssocsById) {
        this.commandeAssocsById = commandeAssocsById;
    }
}
