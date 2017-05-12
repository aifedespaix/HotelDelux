package src.Metier;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "criticite", schema = "base_definitive", catalog = "")
public class CriticiteEntity {
    private int id;
    private String libelle;
    private Time tempsMaximum;
    private Collection<DemandeInterventionEntity> demandeInterventionsById;

    
    public CriticiteEntity(int id, String libelle, Time tempsMaximum,
			Collection<DemandeInterventionEntity> demandeInterventionsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.tempsMaximum = tempsMaximum;
		this.demandeInterventionsById = demandeInterventionsById;
	}

	public CriticiteEntity(String libelle, Time tempsMaximum,
			Collection<DemandeInterventionEntity> demandeInterventionsById) {
		super();
		this.libelle = libelle;
		this.tempsMaximum = tempsMaximum;
		this.demandeInterventionsById = demandeInterventionsById;
	}

	public CriticiteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CriticiteEntity [id=" + id + ", libelle=" + libelle + ", tempsMaximum=" + tempsMaximum
				+ ", demandeInterventionsById=" + demandeInterventionsById + "]";
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
    @Column(name = "temps_maximum", nullable = false)
    public Time getTempsMaximum() {
        return tempsMaximum;
    }

    public void setTempsMaximum(Time tempsMaximum) {
        this.tempsMaximum = tempsMaximum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriticiteEntity that = (CriticiteEntity) o;

        if (id != that.id) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        if (tempsMaximum != null ? !tempsMaximum.equals(that.tempsMaximum) : that.tempsMaximum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (tempsMaximum != null ? tempsMaximum.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "criticiteByIdCriticite")
    public Collection<DemandeInterventionEntity> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeInterventionEntity> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }
}
