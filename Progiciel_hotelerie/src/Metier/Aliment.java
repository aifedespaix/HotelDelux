package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Aliment {
    private int id;
    private String libelle;
    private double prix;
    private Collection<AlimentCommandeAssoc> alimentCommandeAssocsById;
    private Collection<PlatAlimentAssoc> platAlimentAssocsById;

    public Aliment(int id, String libelle, double prix, Collection<AlimentCommandeAssoc> alimentCommandeAssocsById,
			Collection<PlatAlimentAssoc> platAlimentAssocsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.alimentCommandeAssocsById = alimentCommandeAssocsById;
		this.platAlimentAssocsById = platAlimentAssocsById;
	}

	public Aliment(String libelle, double prix, Collection<AlimentCommandeAssoc> alimentCommandeAssocsById,
			Collection<PlatAlimentAssoc> platAlimentAssocsById) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.alimentCommandeAssocsById = alimentCommandeAssocsById;
		this.platAlimentAssocsById = platAlimentAssocsById;
	}

	public Aliment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Aliment [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", alimentCommandeAssocsById="
				+ alimentCommandeAssocsById + ", platAlimentAssocsById=" + platAlimentAssocsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
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
    @Column(name = "prix", nullable = false, precision = 0)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @OneToMany(mappedBy = "alimentByIdAliment")
    public Collection<AlimentCommandeAssoc> getAlimentCommandeAssocsById() {
        return alimentCommandeAssocsById;
    }

    public void setAlimentCommandeAssocsById(Collection<AlimentCommandeAssoc> alimentCommandeAssocsById) {
        this.alimentCommandeAssocsById = alimentCommandeAssocsById;
    }

    @OneToMany(mappedBy = "alimentByIdAliment")
    public Collection<PlatAlimentAssoc> getPlatAlimentAssocsById() {
        return platAlimentAssocsById;
    }

    public void setPlatAlimentAssocsById(Collection<PlatAlimentAssoc> platAlimentAssocsById) {
        this.platAlimentAssocsById = platAlimentAssocsById;
    }
}
