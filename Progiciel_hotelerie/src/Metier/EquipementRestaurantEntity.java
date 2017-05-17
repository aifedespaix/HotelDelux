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
    private Collection<DemandeInterventionEntity> demandeInterventionsById;
    private TableEntity tableByIdTable;
    private Collection<RestaurantAssocEntity> restaurantAssocsById;

    
    
    public EquipementRestaurantEntity(int id, String libelle, String description, String photo,
			Collection<DemandeInterventionEntity> demandeInterventionsById, TableEntity tableByIdTable,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.tableByIdTable = tableByIdTable;
		this.restaurantAssocsById = restaurantAssocsById;
	}
    
    

	public EquipementRestaurantEntity(String libelle, String description, String photo,
			Collection<DemandeInterventionEntity> demandeInterventionsById, TableEntity tableByIdTable,
			Collection<RestaurantAssocEntity> restaurantAssocsById) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
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
				+ ", photo=" + photo + ", idTable=" + ", demandeInterventionsById=" + demandeInterventionsById
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

    @OneToMany(mappedBy = "equipementRestaurantByIdEquipementRestaurant")
    //@OneToMany(mappedBy = "id_equipement_restaurant")
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
