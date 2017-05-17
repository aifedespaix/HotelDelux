package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "plat_aliment_assoc", schema = "base_definitive", catalog = "")
public class PlatAlimentAssoc {
    private int id;
    private int idPlat;
    private int idAliment;
    private double quantite;
    private Plat platByIdPlat;
    private Aliment alimentByIdAliment;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdPlat(Integer idPlat) {
        this.idPlat = idPlat;
    }

    public void setIdAliment(Integer idAliment) {
        this.idAliment = idAliment;
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
    @Column(name = "id_plat", nullable = false)
    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
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

        PlatAlimentAssoc that = (PlatAlimentAssoc) o;

        if (id != that.id) return false;
        if (idPlat != that.idPlat) return false;
        if (idAliment != that.idAliment) return false;
        if (Double.compare(that.quantite, quantite) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + idPlat;
        result = 31 * result + idAliment;
        temp = Double.doubleToLongBits(quantite);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_plat", referencedColumnName = "id", nullable = false)
    public Plat getPlatByIdPlat() {
        return platByIdPlat;
    }

    public void setPlatByIdPlat(Plat platByIdPlat) {
        this.platByIdPlat = platByIdPlat;
    }

    @ManyToOne
    @JoinColumn(name = "id_aliment", referencedColumnName = "id", nullable = false)
    public Aliment getAlimentByIdAliment() {
        return alimentByIdAliment;
    }

    public void setAlimentByIdAliment(Aliment alimentByIdAliment) {
        this.alimentByIdAliment = alimentByIdAliment;
    }
}
