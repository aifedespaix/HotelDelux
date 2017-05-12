package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "facture", schema = "base_definitive", catalog = "")
public class FactureEntity {
    private int id;
    private String fichier;
    private Boolean payee;
    private Collection<FacturationAssocEntity> facturationAssocsById;

    
    public FactureEntity(int id, String fichier, Boolean payee, Collection<FacturationAssocEntity> facturationAssocsById) {
		super();
		this.id = id;
		this.fichier = fichier;
		this.payee = payee;
		this.facturationAssocsById = facturationAssocsById;
	}

	public FactureEntity(String fichier, Boolean payee, Collection<FacturationAssocEntity> facturationAssocsById) {
		super();
		this.fichier = fichier;
		this.payee = payee;
		this.facturationAssocsById = facturationAssocsById;
	}

	public FactureEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FactureEntity [id=" + id + ", fichier=" + fichier + ", payee=" + payee + ", facturationAssocsById="
				+ facturationAssocsById + "]";
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
    @Column(name = "fichier", nullable = false, length = 250)
    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    @Basic
    @Column(name = "payee", nullable = false)
    public Boolean getPayee() {
        return payee;
    }

    public void setPayee(Boolean payee) {
        this.payee = payee;
    }


    @OneToMany(mappedBy = "factureByIdFacture")
    public Collection<FacturationAssocEntity> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssocEntity> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }
}
