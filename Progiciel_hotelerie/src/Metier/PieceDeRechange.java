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

    public PieceDeRechange(int id, String libelle, double prix, int quantite,
			Collection<CommandePieceAssoc> commandePieceAssocsById,
			Collection<DemandeIntervention> demandeInterventionsById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.quantite = quantite;
		this.commandePieceAssocsById = commandePieceAssocsById;
		this.demandeInterventionsById = demandeInterventionsById;
	}

	public PieceDeRechange(String libelle, double prix, int quantite,
			Collection<CommandePieceAssoc> commandePieceAssocsById,
			Collection<DemandeIntervention> demandeInterventionsById) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.quantite = quantite;
		this.commandePieceAssocsById = commandePieceAssocsById;
		this.demandeInterventionsById = demandeInterventionsById;
	}

	public PieceDeRechange() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PieceDeRechange [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", quantite=" + quantite
				+ ", commandePieceAssocsById=" + commandePieceAssocsById + ", demandeInterventionsById="
				+ demandeInterventionsById + "]";
	}

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
