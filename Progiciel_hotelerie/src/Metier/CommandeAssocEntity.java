package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "commande_assoc", schema = "base_definitive", catalog = "")
public class CommandeAssocEntity {
    private int id;
    private int idEquipement;
    private double quantite;
    private CommandeEntity commandeByIdCommande;

    public CommandeAssocEntity(int id, int idEquipement, double quantite,
			CommandeEntity commandeByIdCommande) {
		super();
		this.id = id;
		this.idEquipement = idEquipement;
		this.quantite = quantite;
		this.commandeByIdCommande = commandeByIdCommande;
	}

	public CommandeAssocEntity(int idEquipement, double quantite, CommandeEntity commandeByIdCommande) {
		super();
		this.idEquipement = idEquipement;
		this.quantite = quantite;
		this.commandeByIdCommande = commandeByIdCommande;
	}

	public CommandeAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommandeAssocEntity [id=" + id + ", idCommande=" + ", idEquipement=" + idEquipement
				+ ", quantite=" + quantite + ", commandeByIdCommande=" + commandeByIdCommande + "]";
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
    @Column(name = "id_equipement", nullable = false)
    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    @Basic
    @Column(name = "quantite", nullable = false, precision = 0)
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @ManyToOne
    @JoinColumn(name = "id_commande", referencedColumnName = "id", nullable = false)
    public CommandeEntity getCommandeByIdCommande() {
        return commandeByIdCommande;
    }

    public void setCommandeByIdCommande(CommandeEntity commandeByIdCommande) {
        this.commandeByIdCommande = commandeByIdCommande;
    }
}
