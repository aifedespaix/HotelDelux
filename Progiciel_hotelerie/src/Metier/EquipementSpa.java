package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "equipement_spa", schema = "hotel", catalog = "")
public class EquipementSpa {
    private int id;
    private String libelle;
    private String description;
    private String photo;
    private Collection<DemandeIntervention> demandeInterventionsById;
    private Spa spaByIdSpa;
    private Collection<CommandeAssoc> commandeAssocsById;

    public EquipementSpa(int id, String libelle, String description, String photo,
			Collection<DemandeIntervention> demandeInterventionsById, Spa spaByIdSpa,
			Collection<CommandeAssoc> commandeAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.spaByIdSpa = spaByIdSpa;
		this.commandeAssocsById = commandeAssocsById;
	}

	public EquipementSpa(String libelle, String description, String photo,
			Collection<DemandeIntervention> demandeInterventionsById, Spa spaByIdSpa,
			Collection<CommandeAssoc> commandeAssocsById) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.spaByIdSpa = spaByIdSpa;
		this.commandeAssocsById = commandeAssocsById;
	}

	public EquipementSpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EquipementSpa [id=" + id + ", libelle=" + libelle + ", description=" + description + ", photo=" + photo
				+ ", demandeInterventionsById=" + demandeInterventionsById + ", spaByIdSpa=" + spaByIdSpa
				+ ", commandeAssocsById=" + commandeAssocsById + "]";
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

    @OneToMany(mappedBy = "equipementSpaByIdEquipementSpa")
    public Collection<DemandeIntervention> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeIntervention> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_spa", referencedColumnName = "id", nullable = false)
    public Spa getSpaByIdSpa() {
        return spaByIdSpa;
    }

    public void setSpaByIdSpa(Spa spaByIdSpa) {
        this.spaByIdSpa = spaByIdSpa;
    }

    @OneToMany(mappedBy = "equipementSpaByIdEquipementSpa")
    public Collection<CommandeAssoc> getCommandeAssocsById() {
        return commandeAssocsById;
    }

    public void setCommandeAssocsById(Collection<CommandeAssoc> commandeAssocsById) {
        this.commandeAssocsById = commandeAssocsById;
    }
}
