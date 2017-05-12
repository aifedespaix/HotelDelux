package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "equipement_hotel", schema = "base_definitive", catalog = "")
public class EquipementHotelEntity {
    private int id;
    private String libelle;
    private String description;
    private String photo;
    private Collection<DemandeInterventionEntity> demandeInterventionsById;
    private ChambreEntity chambreByIdChambre;

    
    public EquipementHotelEntity(int id, String libelle, String description, String photo,
			Collection<DemandeInterventionEntity> demandeInterventionsById, ChambreEntity chambreByIdChambre) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.chambreByIdChambre = chambreByIdChambre;
	}
    
    

	public EquipementHotelEntity(String libelle, String description, String photo,
			Collection<DemandeInterventionEntity> demandeInterventionsById, ChambreEntity chambreByIdChambre) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.demandeInterventionsById = demandeInterventionsById;
		this.chambreByIdChambre = chambreByIdChambre;
	}



	public EquipementHotelEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EquipementHotelEntity [id=" + id + ", libelle=" + libelle + ", description=" + description + ", photo="
				+ photo + ", idChambre=" + ", demandeInterventionsById=" + demandeInterventionsById
				+ ", chambreByIdChambre=" + chambreByIdChambre + "]";
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


    @OneToMany(mappedBy = "equipementHotelByIdEquipementHotel")
    public Collection<DemandeInterventionEntity> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeInterventionEntity> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_chambre", referencedColumnName = "id", nullable = false)
    public ChambreEntity getChambreByIdChambre() {
        return chambreByIdChambre;
    }

    public void setChambreByIdChambre(ChambreEntity chambreByIdChambre) {
        this.chambreByIdChambre = chambreByIdChambre;
    }
}
