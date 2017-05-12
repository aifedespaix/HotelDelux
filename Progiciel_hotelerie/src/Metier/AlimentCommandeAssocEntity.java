package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "aliment_commande_assoc", schema = "base_definitive", catalog = "")
public class AlimentCommandeAssocEntity {
    private int id;
    private int idAliment;
    private int idCommande;
    private double quantite;
    private AlimentEntity alimentByIdAliment;
    private CommandeEntity commandeByIdCommande;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlimentCommandeAssocEntity that = (AlimentCommandeAssocEntity) o;

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
