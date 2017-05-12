package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "equipement_restaurant", schema = "base_definitive", catalog = "")
public class EquipementRestaurantEntity {
    private int id;
    private String libelle;
    private String description;
    private String photo;
    private int idTable;
    private Collection<DemandeInterventionEntity> demandeInterventionsById;
    private TableEntity tableByIdTable;
    private Collection<RestaurantAssocEntity> restaurantAssocsById;

    
    
    public EquipementRestaurantEntity(int id, String libelle, String description, String photo, int idTable,
			Collection<DemandeInterventionEntity> demandeInterventionsById, TableEntity tableByIdTable,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.idTable = idTable;
		this.demandeInterventionsById = demandeInterventionsById;
		this.tableByIdTable = tableByIdTable;
		this.restaurantAssocsById = restaurantAssocsById;
	}
    
    

	public EquipementRestaurantEntity(String libelle, String description, String photo, int idTable,
			Collection<DemandeInterventionEntity> demandeInterventionsById, TableEntity tableByIdTable,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.idTable = idTable;
		this.demandeInterventionsById = demandeInterventionsById;
		this.tableByIdTable = tableByIdTable;
		this.restaurantAssocsById = restaurantAssocsById;
	}



	public EquipementRestaurantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "EquipementRestaurantEntity [id=" + id + ", libelle=" + libelle + ", description=" + description
				+ ", photo=" + photo + ", idTable=" + idTable + ", demandeInterventionsById=" + demandeInterventionsById
				+ ", tableByIdTable=" + tableByIdTable + ", restaurantAssocsById=" + restaurantAssocsById + "]";
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
    @Column(name = "id_table", nullable = false)
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

        EquipementRestaurantEntity that = (EquipementRestaurantEntity) o;

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
    public Collection<DemandeInterventionEntity> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeInterventionEntity> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_table", referencedColumnName = "id", nullable = false)
    public TableEntity getTableByIdTable() {
        return tableByIdTable;
    }

    public void setTableByIdTable(TableEntity tableByIdTable) {
        this.tableByIdTable = tableByIdTable;
    }

    @OneToMany(mappedBy = "equipementRestaurantByIdReservation")
    public Collection<RestaurantAssocEntity> getRestaurantAssocsById() {
        return restaurantAssocsById;
    }

    public void setRestaurantAssocsById(Collection<RestaurantAssocEntity> restaurantAssocsById) {
        this.restaurantAssocsById = restaurantAssocsById;
    }
}
