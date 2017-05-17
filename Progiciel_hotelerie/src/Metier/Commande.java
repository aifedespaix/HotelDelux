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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (id != commande.id) return false;
        if (Double.compare(commande.prixTotal, prixTotal) != 0) return false;
        if (dateCommande != null ? !dateCommande.equals(commande.dateCommande) : commande.dateCommande != null)
            return false;

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
}
