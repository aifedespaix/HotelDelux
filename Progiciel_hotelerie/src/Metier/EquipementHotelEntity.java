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
    private int idChambre;
    private Collection<DemandeInterventionEntity> demandeInterventionsById;
    private ChambreEntity chambreByIdChambre;

    
    public EquipementHotelEntity(int id, String libelle, String description, String photo, int idChambre,
			Collection<DemandeInterventionEntity> demandeInterventionsById, ChambreEntity chambreByIdChambre) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.idChambre = idChambre;
		this.demandeInterventionsById = demandeInterventionsById;
		this.chambreByIdChambre = chambreByIdChambre;
	}
    
    

	public EquipementHotelEntity(String libelle, String description, String photo, int idChambre,
			Collection<DemandeInterventionEntity> demandeInterventionsById, ChambreEntity chambreByIdChambre) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.idChambre = idChambre;
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
				+ photo + ", idChambre=" + idChambre + ", demandeInterventionsById=" + demandeInterventionsById
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

    @Basic
    @Column(name = "id_chambre", nullable = false)
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

        EquipementHotelEntity that = (EquipementHotelEntity) o;

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
