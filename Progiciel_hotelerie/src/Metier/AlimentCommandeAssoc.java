package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "aliment_commande_assoc", schema = "hotel", catalog = "")
public class AlimentCommandeAssoc {
    private int id;
    private double quantite;
    private Aliment alimentByIdAliment;
    private Commande commandeByIdCommande;

    public AlimentCommandeAssoc(int id, double quantite, Aliment alimentByIdAliment, Commande commandeByIdCommande) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.alimentByIdAliment = alimentByIdAliment;
		this.commandeByIdCommande = commandeByIdCommande;
	}

	public AlimentCommandeAssoc(double quantite, Aliment alimentByIdAliment, Commande commandeByIdCommande) {
		super();
		this.quantite = quantite;
		this.alimentByIdAliment = alimentByIdAliment;
		this.commandeByIdCommande = commandeByIdCommande;
	}

	public AlimentCommandeAssoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AlimentCommandeAssoc [id=" + id + ", quantite=" + quantite + ", alimentByIdAliment="
				+ alimentByIdAliment + ", commandeByIdCommande=" + commandeByIdCommande + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
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
    @JoinColumn(name = "id_aliment", referencedColumnName = "id", nullable = false, updatable = false,insertable = false)
    public Aliment getAlimentByIdAliment() {
        return alimentByIdAliment;
    }

    public void setAlimentByIdAliment(Aliment alimentByIdAliment) {
        this.alimentByIdAliment = alimentByIdAliment;
    }

    @ManyToOne
    @JoinColumn(name = "id_commande", referencedColumnName = "id", nullable = false, updatable = false,insertable = false)
    public Commande getCommandeByIdCommande() {
        return commandeByIdCommande;
    }

    public void setCommandeByIdCommande(Commande commandeByIdCommande) {
        this.commandeByIdCommande = commandeByIdCommande;
    }

}
