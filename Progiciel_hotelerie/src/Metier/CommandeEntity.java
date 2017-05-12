package src.Metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "commande", schema = "base_definitive", catalog = "")
public class CommandeEntity {
    private int id;
    private Date dateCommande;
    private double prixTotal;
    private Collection<AlimentCommandeAssocEntity> alimentCommandeAssocsById;
    private Collection<CommandeAssocEntity> commandeAssocsById;
    private Collection<CommandePieceAssocEntity> commandePieceAssocsById;

    public CommandeEntity(int id, Date dateCommande, double prixTotal,
			Collection<AlimentCommandeAssocEntity> alimentCommandeAssocsById,
			Collection<CommandeAssocEntity> commandeAssocsById,
			Collection<CommandePieceAssocEntity> commandePieceAssocsById) {
		super();
		this.id = id;
		this.dateCommande = dateCommande;
		this.prixTotal = prixTotal;
		this.alimentCommandeAssocsById = alimentCommandeAssocsById;
		this.commandeAssocsById = commandeAssocsById;
		this.commandePieceAssocsById = commandePieceAssocsById;
	}

	public CommandeEntity(Date dateCommande, double prixTotal,
			Collection<AlimentCommandeAssocEntity> alimentCommandeAssocsById,
			Collection<CommandeAssocEntity> commandeAssocsById,
			Collection<CommandePieceAssocEntity> commandePieceAssocsById) {
		super();
		this.dateCommande = dateCommande;
		this.prixTotal = prixTotal;
		this.alimentCommandeAssocsById = alimentCommandeAssocsById;
		this.commandeAssocsById = commandeAssocsById;
		this.commandePieceAssocsById = commandePieceAssocsById;
	}

	public CommandeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommandeEntity [id=" + id + ", dateCommande=" + dateCommande + ", prixTotal=" + prixTotal
				+ ", alimentCommandeAssocsById=" + alimentCommandeAssocsById + ", commandeAssocsById="
				+ commandeAssocsById + ", commandePieceAssocsById=" + commandePieceAssocsById + "]";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandeEntity that = (CommandeEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.prixTotal, prixTotal) != 0) return false;
        if (dateCommande != null ? !dateCommande.equals(that.dateCommande) : that.dateCommande != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (dateCommande != null ? dateCommande.hashCode() : 0);
        temp = Double.doubleToLongBits(prixTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "commandeByIdCommande")
    public Collection<AlimentCommandeAssocEntity> getAlimentCommandeAssocsById() {
        return alimentCommandeAssocsById;
    }

    public void setAlimentCommandeAssocsById(Collection<AlimentCommandeAssocEntity> alimentCommandeAssocsById) {
        this.alimentCommandeAssocsById = alimentCommandeAssocsById;
    }

    @OneToMany(mappedBy = "commandeByIdCommande")
    public Collection<CommandeAssocEntity> getCommandeAssocsById() {
        return commandeAssocsById;
    }

    public void setCommandeAssocsById(Collection<CommandeAssocEntity> commandeAssocsById) {
        this.commandeAssocsById = commandeAssocsById;
    }

    @OneToMany(mappedBy = "commandeByIdCommande")
    public Collection<CommandePieceAssocEntity> getCommandePieceAssocsById() {
        return commandePieceAssocsById;
    }

    public void setCommandePieceAssocsById(Collection<CommandePieceAssocEntity> commandePieceAssocsById) {
        this.commandePieceAssocsById = commandePieceAssocsById;
    }
}
