package src.Metier;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Criticite {
    private int id;
    private String libelle;
    private Time tempsMaximum;

    public Criticite(int id, String libelle, Time tempsMaximum) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.tempsMaximum = tempsMaximum;
	}

	public Criticite(String libelle, Time tempsMaximum) {
		super();
		this.libelle = libelle;
		this.tempsMaximum = tempsMaximum;
	}

	public Criticite() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return libelle;
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
    @Column(name = "temps_maximum", nullable = false)
    public Time getTempsMaximum() {
        return tempsMaximum;
    }

    public void setTempsMaximum(Time tempsMaximum) {
        this.tempsMaximum = tempsMaximum;
    }
}
