package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "piece_de_rechange", schema = "hotel", catalog = "")
public class PieceDeRechange {
    private int id;
    private String libelle;
    private double prix;
    private int quantite;
    private Collection<CommandePieceAssoc> commandePieceAssocsById;
    private Collection<DemandeIntervention> demandeInterventionsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setQuantite(Integer quantite) {
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
    @Column(name = "libelle", nullable = false, length = 250)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "prix", nullable = false, precision = 0)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "quantite", nullable = false)
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PieceDeRechange that = (PieceDeRechange) o;

        if (id != that.id) return false;
        if (Double.compare(that.prix, prix) != 0) return false;
        if (quantite != that.quantite) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantite;
        return result;
    }

    @OneToMany(mappedBy = "pieceDeRechangeByIdPiece")
    public Collection<CommandePieceAssoc> getCommandePieceAssocsById() {
        return commandePieceAssocsById;
    }

    public void setCommandePieceAssocsById(Collection<CommandePieceAssoc> commandePieceAssocsById) {
        this.commandePieceAssocsById = commandePieceAssocsById;
    }

    @OneToMany(mappedBy = "pieceDeRechangeByIdPieceRechange")
    public Collection<DemandeIntervention> getDemandeInterventionsById() {
        return demandeInterventionsById;
    }

    public void setDemandeInterventionsById(Collection<DemandeIntervention> demandeInterventionsById) {
        this.demandeInterventionsById = demandeInterventionsById;
    }
}
