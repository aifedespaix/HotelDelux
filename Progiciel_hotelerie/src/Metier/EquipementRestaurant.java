package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@javax.persistence.Table(name = "equipement_restaurant", schema = "hotel", catalog = "")
public class EquipementRestaurant {
    private int id;
    private String libelle;
    private String description;
    private String photo;
    private int idTable;
    private Collection<DemandeIntervention> demandeInterventionsById;
    private Table tableByIdTable;
    private Collection<RestaurantAssoc> restaurantAssocsById;
    private Collection<CommandeAssoc> commandeAssocsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdTable(Integer idTable) {
        this.idTable = idTable;
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
    @Column(name = "id_table", nullable = false, updatable = false,insertable = false)
    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipementRestaurant that = (EquipementRestaurant) o;

        if (id != that.id) return false;
        if (idTable != that.idTable) return false;
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
        result = 31 * result + idTable;
        return result;
    }

    @OneToMany(mappedBy = "equipementRestaurantByIdEquipementRestaurant")
    public Collection<DemandeIntervention> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeIntervention> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_table", referencedColumnName = "id", nullable = false, updatable = false,insertable = false)
    public Table getTableByIdTable() {
        return tableByIdTable;
    }

    public void setTableByIdTable(Table tableByIdTable) {
        this.tableByIdTable = tableByIdTable;
    }

    @OneToMany(mappedBy = "equipementRestaurantByIdReservation")
    public Collection<RestaurantAssoc> getRestaurantAssocsById() {
        return restaurantAssocsById;
    }

    public void setRestaurantAssocsById(Collection<RestaurantAssoc> restaurantAssocsById) {
        this.restaurantAssocsById = restaurantAssocsById;
    }

    @OneToMany(mappedBy = "equipementRestaurantByIdEquipementRestaurant")
    public Collection<CommandeAssoc> getCommandeAssocsById() {
        return commandeAssocsById;
    }

    public void setCommandeAssocsById(Collection<CommandeAssoc> commandeAssocsById) {
        this.commandeAssocsById = commandeAssocsById;
    }
}
