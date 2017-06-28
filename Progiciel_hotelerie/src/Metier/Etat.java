package src.Metier;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Etat {

	private int id;
    private String libelle;
    
    public Etat() {
    	super();
    }
    
    public Etat(int id) {
    	this.id = id;
    }
    
    public Etat(String libelle) {
    	this.libelle = libelle;
    }
    
    public Etat(int id, String libelle) {
    	this.id = id;
    	this.libelle = libelle;
    }
    
    @Override
	public String toString() {
		return libelle;
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
    @Column(name = "libelle", nullable = false, length = 30)
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
