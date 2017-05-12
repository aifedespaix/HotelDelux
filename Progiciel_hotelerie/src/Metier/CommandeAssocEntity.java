package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "commande_assoc", schema = "base_definitive", catalog = "")
public class CommandeAssocEntity {
    private int id;
    private int idCommande;
    private int idEquipement;
    private double quantite;
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
    @Column(name = "id_commande", nullable = false)
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandeAssocEntity that = (CommandeAssocEntity) o;

        if (id != that.id) return false;
        if (idCommande != that.idCommande) return false;
        if (idEquipement != that.idEquipement) return false;
        if (Double.compare(that.quantite, quantite) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + idCommande;
        result = 31 * result + idEquipement;
        temp = Double.doubleToLongBits(quantite);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
