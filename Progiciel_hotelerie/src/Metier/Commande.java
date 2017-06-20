package src.Metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Commande {
    private int id;
    private Date dateCommande;
    private double prixTotal;
    private Collection<AlimentCommandeAssoc> alimentCommandeAssocsById;
    private Collection<CommandeAssoc> commandeAssocsById;
    private Collection<CommandePieceAssoc> commandePieceAssocsById;

    public Commande(int id, Date dateCommande, double prixTotal,
			Collection<AlimentCommandeAssoc> alimentCommandeAssocsById, Collection<CommandeAssoc> commandeAssocsById,
			Collection<CommandePieceAssoc> commandePieceAssocsById) {
		super();
		this.id = id;
		this.dateCommande = dateCommande;
		this.prixTotal = prixTotal;
		this.alimentCommandeAssocsById = alimentCommandeAssocsById;
		this.commandeAssocsById = commandeAssocsById;
		this.commandePieceAssocsById = commandePieceAssocsById;
	}

	public Commande(Date dateCommande, double prixTotal, Collection<AlimentCommandeAssoc> alimentCommandeAssocsById,
			Collection<CommandeAssoc> commandeAssocsById, Collection<CommandePieceAssoc> commandePieceAssocsById) {
		super();
		this.dateCommande = dateCommande;
		this.prixTotal = prixTotal;
		this.alimentCommandeAssocsById = alimentCommandeAssocsById;
		this.commandeAssocsById = commandeAssocsById;
		this.commandePieceAssocsById = commandePieceAssocsById;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCommande=" + dateCommande + ", prixTotal=" + prixTotal
				+ ", alimentCommandeAssocsById=" + alimentCommandeAssocsById + ", commandeAssocsById="
				+ commandeAssocsById + ", commandePieceAssocsById=" + commandePieceAssocsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
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
    @Column(name = "date_commande", nullable = false)
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Basic
    @Column(name = "prix_total", nullable = false, precision = 0)
    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    @OneToMany(mappedBy = "commandeByIdCommande")
    public Collection<AlimentCommandeAssoc> getAlimentCommandeAssocsById() {
        return alimentCommandeAssocsById;
    }

    public void setAlimentCommandeAssocsById(Collection<AlimentCommandeAssoc> alimentCommandeAssocsById) {
        this.alimentCommandeAssocsById = alimentCommandeAssocsById;
    }

    @OneToMany(mappedBy = "commandeByIdCommande")
    public Collection<CommandeAssoc> getCommandeAssocsById() {
        return commandeAssocsById;
    }

    public void setCommandeAssocsById(Collection<CommandeAssoc> commandeAssocsById) {
        this.commandeAssocsById = commandeAssocsById;
    }

    @OneToMany(mappedBy = "commandeByIdCommande")
    public Collection<CommandePieceAssoc> getCommandePieceAssocsById() {
        return commandePieceAssocsById;
    }

    public void setCommandePieceAssocsById(Collection<CommandePieceAssoc> commandePieceAssocsById) {
        this.commandePieceAssocsById = commandePieceAssocsById;
    }
}
