package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "aliment_commande_assoc", schema = "base_definitive", catalog = "")
public class AlimentCommandeAssocEntity {
    private int id;
    private double quantite;
    private AlimentEntity alimentByIdAliment;
    private CommandeEntity commandeByIdCommande;

    public AlimentCommandeAssocEntity(int id,double quantite,
			AlimentEntity alimentByIdAliment, CommandeEntity commandeByIdCommande) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.alimentByIdAliment = alimentByIdAliment;
		this.commandeByIdCommande = commandeByIdCommande;
	}

    
	public AlimentCommandeAssocEntity(double quantite, AlimentEntity alimentByIdAliment,
			CommandeEntity commandeByIdCommande) {
		super();
		this.quantite = quantite;
		this.alimentByIdAliment = alimentByIdAliment;
		this.commandeByIdCommande = commandeByIdCommande;
	}


	public AlimentCommandeAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AlimentCommandeAssocEntity [id=" + id + ", idAliment=" + ", idCommande="
				+ ", quantite=" + quantite + ", alimentByIdAliment=" + alimentByIdAliment + ", commandeByIdCommande="
				+ commandeByIdCommande + "]";
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
    @Column(name = "quantite", nullable = false, precision = 0)
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @ManyToOne
    @JoinColumn(name = "id_aliment", referencedColumnName = "id", nullable = false)
    public AlimentEntity getAlimentByIdAliment() {
        return alimentByIdAliment;
    }

    public void setAlimentByIdAliment(AlimentEntity alimentByIdAliment) {
        this.alimentByIdAliment = alimentByIdAliment;
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
