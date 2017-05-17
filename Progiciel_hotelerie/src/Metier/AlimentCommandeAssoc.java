package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "aliment_commande_assoc", schema = "base_definitive", catalog = "")
public class AlimentCommandeAssoc {
    private int id;
    private int idAliment;
    private int idCommande;
    private double quantite;
    private Aliment alimentByIdAliment;
    private Commande commandeByIdCommande;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdAliment(Integer idAliment) {
        this.idAliment = idAliment;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
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
    @Column(name = "id_aliment", nullable = false)
    public int getIdAliment() {
        return idAliment;
    }

    public void setIdAliment(int idAliment) {
        this.idAliment = idAliment;
    }

    @Basic
    @Column(name = "id_commande", nullable = false)
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
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
    public Aliment getAlimentByIdAliment() {
        return alimentByIdAliment;
    }

    public void setAlimentByIdAliment(Aliment alimentByIdAliment) {
        this.alimentByIdAliment = alimentByIdAliment;
    }

    @ManyToOne
    @JoinColumn(name = "id_commande", referencedColumnName = "id", nullable = false)
    public Commande getCommandeByIdCommande() {
        return commandeByIdCommande;
    }

    public void setCommandeByIdCommande(Commande commandeByIdCommande) {
        this.commandeByIdCommande = commandeByIdCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlimentCommandeAssoc that = (AlimentCommandeAssoc) o;

        if (id != that.id) return false;
        if (idAliment != that.idAliment) return false;
        if (idCommande != that.idCommande) return false;
        if (Double.compare(that.quantite, quantite) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + idAliment;
        result = 31 * result + idCommande;
        temp = Double.doubleToLongBits(quantite);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
