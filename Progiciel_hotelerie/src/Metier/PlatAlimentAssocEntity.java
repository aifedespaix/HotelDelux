package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "plat_aliment_assoc", schema = "base_definitive", catalog = "")
public class PlatAlimentAssocEntity {
    private int id;
    private double quantite;
    private PlatEntity platByIdPlat;
    private AlimentEntity alimentByIdAliment;

    
    public PlatAlimentAssocEntity(int id,double quantite, PlatEntity platByIdPlat,
			AlimentEntity alimentByIdAliment) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.platByIdPlat = platByIdPlat;
		this.alimentByIdAliment = alimentByIdAliment;
	}

    
	public PlatAlimentAssocEntity(double quantite, PlatEntity platByIdPlat,
			AlimentEntity alimentByIdAliment) {
		super();
		this.quantite = quantite;
		this.platByIdPlat = platByIdPlat;
		this.alimentByIdAliment = alimentByIdAliment;
	}


	public PlatAlimentAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public String toString() {
		return "PlatAlimentAssocEntity [id=" + id +", quantite="
				+ quantite + ", platByIdPlat=" + platByIdPlat + ", alimentByIdAliment=" + alimentByIdAliment + "]";
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
    public PlatEntity getPlatByIdPlat() {
        return platByIdPlat;
    }

    public void setPlatByIdPlat(PlatEntity platByIdPlat) {
        this.platByIdPlat = platByIdPlat;
    }

    @ManyToOne
    @JoinColumn(name = "id_aliment", referencedColumnName = "id", nullable = false)
    public AlimentEntity getAlimentByIdAliment() {
        return alimentByIdAliment;
    }

    public void setAlimentByIdAliment(AlimentEntity alimentByIdAliment) {
        this.alimentByIdAliment = alimentByIdAliment;
    }
}
