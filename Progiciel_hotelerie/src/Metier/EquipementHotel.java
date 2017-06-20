package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "equipement_hotel")
public class EquipementHotel {
    private int id;
    private String libelle;
    private String description;
    private String photo;
    private Boolean estEquipementJardin;
    private Chambre chambreByIdChambre;

    public EquipementHotel(int id, String libelle, String description, String photo, Boolean estEquipementJardin,Chambre chambreByIdChambre) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.estEquipementJardin = estEquipementJardin;
		this.chambreByIdChambre = chambreByIdChambre;
	}

	public EquipementHotel(String libelle, String description, String photo,Boolean estEquipementJardin,Chambre chambreByIdChambre) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.estEquipementJardin = estEquipementJardin;
		this.chambreByIdChambre = chambreByIdChambre;
	}

	public EquipementHotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EquipementHotel [id=" + id + ", libelle=" + libelle + ", description=" + description + ", photo="
				+ photo + ", chambreByIdChambre=" + chambreByIdChambre + "]";
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
    
    @Basic
    @Column(name = "est_equipement_jardin")
    public Boolean getEstEquipementJardin() {
		return estEquipementJardin;
	}

	public void setEstEquipementJardin(Boolean estEquipementJardin) {
		this.estEquipementJardin = estEquipementJardin;
	}

    @ManyToOne
    @JoinColumn(name = "id_chambre", referencedColumnName = "id", nullable = false)
    public Chambre getChambreByIdChambre() {
        return chambreByIdChambre;
    }

    public void setChambreByIdChambre(Chambre chambreByIdChambre) {
        this.chambreByIdChambre = chambreByIdChambre;
    }
}
