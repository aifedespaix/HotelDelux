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
    private Spa spaByIdSpa;

    public EquipementSpa(int id, String libelle, String description, String photo,Spa spaByIdSpa) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.spaByIdSpa = spaByIdSpa;
	}

	public EquipementSpa(String libelle, String description, String photo, Spa spaByIdSpa) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.photo = photo;
		this.spaByIdSpa = spaByIdSpa;
	}

	public EquipementSpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EquipementSpa [id=" + id + ", libelle=" + libelle + ", description=" + description + ", photo=" + photo
				+ ", spaByIdSpa=" + spaByIdSpa + "]";
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

    @ManyToOne
    @JoinColumn(name = "id_spa", referencedColumnName = "id", nullable = false)
    public Spa getSpaByIdSpa() {
        return spaByIdSpa;
    }

    public void setSpaByIdSpa(Spa spaByIdSpa) {
        this.spaByIdSpa = spaByIdSpa;
    }
}
