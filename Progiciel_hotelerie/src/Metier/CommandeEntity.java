package src.Metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "commande", schema = "base_definitive", catalog = "")
public class CommandeEntity {
    private int id;
    private Date dateCommande;
    private double prixTotal;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_commande")
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Basic
    @Column(name = "prix_total")
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
}
