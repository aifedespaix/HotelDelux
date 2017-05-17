package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Facture {
    private int id;
    private String fichier;
    private boolean payee;
    private Collection<FacturationAssoc> facturationAssocsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPayee(boolean payee) {
        this.payee = payee;
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
    @Column(name = "fichier", nullable = false, length = 250)
    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    @Basic
    @Column(name = "payee", nullable = false)
    public boolean getPayee() {
        return payee;
    }

    @OneToMany(mappedBy = "factureByIdFacture")
    public Collection<FacturationAssoc> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssoc> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }
}
