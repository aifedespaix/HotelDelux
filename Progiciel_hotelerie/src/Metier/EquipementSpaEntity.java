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
    private Collection<DemandeInterventionEntity> demandeInterventionsById;
    private SpaEntity spaByIdSpa;

    
    public EquipementSpaEntity(int id, String libelle, String description, String photo,
			Collection<DemandeInterventionEntity> demandeInterventionsById, SpaEntity spaByIdSpa) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.spaByIdSpa = spaByIdSpa;
	}
    
    

	public EquipementSpaEntity(String libelle, String description, String photo,
			Collection<DemandeInterventionEntity> demandeInterventionsById, SpaEntity spaByIdSpa) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.spaByIdSpa = spaByIdSpa;
	}



	public EquipementSpaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	@Override
	public String toString() {
		return "EquipementSpaEntity [id=" + id + ", libelle=" + libelle + ", description=" + description + ", photo="
				+ photo + ", demandeInterventionsById=" + demandeInterventionsById
				+ ", spaByIdSpa=" + spaByIdSpa + "]";
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
