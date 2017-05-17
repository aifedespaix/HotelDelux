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
    private Collection<DemandeIntervention> demandeInterventionsById;
    private Table tableByIdTable;
    private Collection<CommandeAssoc> commandeAssocsById;

    public EquipementRestaurant(int id, String libelle, String description, String photo,
			Collection<DemandeIntervention> demandeInterventionsById, Table tableByIdTable,
			Collection<CommandeAssoc> commandeAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.tableByIdTable = tableByIdTable;
		this.commandeAssocsById = commandeAssocsById;
	}

	public EquipementRestaurant(String libelle, String description, String photo,
			Collection<DemandeIntervention> demandeInterventionsById, Table tableByIdTable,
			Collection<CommandeAssoc> commandeAssocsById) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.tableByIdTable = tableByIdTable;
		this.commandeAssocsById = commandeAssocsById;
	}

	public EquipementRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EquipementRestaurant [id=" + id + ", libelle=" + libelle + ", description=" + description + ", photo="
				+ photo + ", demandeInterventionsById=" + demandeInterventionsById + ", tableByIdTable="
				+ tableByIdTable + ", commandeAssocsById=" + commandeAssocsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
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

    @OneToMany(mappedBy = "equipementRestaurantByIdEquipementRestaurant")
    public Collection<CommandeAssoc> getCommandeAssocsById() {
        return commandeAssocsById;
    }

    public void setCommandeAssocsById(Collection<CommandeAssoc> commandeAssocsById) {
        this.commandeAssocsById = commandeAssocsById;
    }
}
