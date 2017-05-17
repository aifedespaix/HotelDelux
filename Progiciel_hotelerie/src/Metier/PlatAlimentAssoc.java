package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "plat_aliment_assoc", schema = "hotel", catalog = "")
public class PlatAlimentAssoc {
    private int id;
    private double quantite;
    private Plat platByIdPlat;
    private Aliment alimentByIdAliment;

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
