package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "facture", schema = "base_definitive", catalog = "")
public class FactureEntity {
    private int id;
    private String fichier;
    private byte payee;
    private Collection<FacturationAssocEntity> facturationAssocsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fichier", nullable = false, length = 250)
    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    @Basic
    @Column(name = "payee", nullable = false)
    public byte getPayee() {
        return payee;
    }

    public void setPayee(byte payee) {
        this.payee = payee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactureEntity that = (FactureEntity) o;

        if (id != that.id) return false;
        if (payee != that.payee) return false;
        if (fichier != null ? !fichier.equals(that.fichier) : that.fichier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fichier != null ? fichier.hashCode() : 0);
        result = 31 * result + (int) payee;
        return result;
    }

    @OneToMany(mappedBy = "factureByIdFacture")
    public Collection<FacturationAssocEntity> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssocEntity> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }
}
