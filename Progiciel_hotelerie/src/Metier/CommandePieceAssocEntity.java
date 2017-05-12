package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "commande_piece_assoc", schema = "base_definitive", catalog = "")
public class CommandePieceAssocEntity {
    private int id;
    private double quantite;
    private CommandeEntity commandeByIdCommande;
    private PieceDeRechangeEntity pieceDeRechangeByIdPiece;

    public CommandePieceAssocEntity(int id, double quantite,
			CommandeEntity commandeByIdCommande, PieceDeRechangeEntity pieceDeRechangeByIdPiece) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.commandeByIdCommande = commandeByIdCommande;
		this.pieceDeRechangeByIdPiece = pieceDeRechangeByIdPiece;
	}

	public CommandePieceAssocEntity(double quantite, CommandeEntity commandeByIdCommande,
			PieceDeRechangeEntity pieceDeRechangeByIdPiece) {
		super();
		this.quantite = quantite;
		this.commandeByIdCommande = commandeByIdCommande;
		this.pieceDeRechangeByIdPiece = pieceDeRechangeByIdPiece;
	}

	public CommandePieceAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommandePieceAssocEntity [id=" + id + ", idCommande=" + ", idPiece="
				+ ", quantite=" + quantite + ", commandeByIdCommande=" + commandeByIdCommande
				+ ", pieceDeRechangeByIdPiece=" + pieceDeRechangeByIdPiece + "]";
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
    @JoinColumn(name = "id_commande", referencedColumnName = "id", nullable = false)
    public CommandeEntity getCommandeByIdCommande() {
        return commandeByIdCommande;
    }

    public void setCommandeByIdCommande(CommandeEntity commandeByIdCommande) {
        this.commandeByIdCommande = commandeByIdCommande;
    }

    @ManyToOne
    @JoinColumn(name = "id_piece", referencedColumnName = "id", nullable = false)
    public PieceDeRechangeEntity getPieceDeRechangeByIdPiece() {
        return pieceDeRechangeByIdPiece;
    }

    public void setPieceDeRechangeByIdPiece(PieceDeRechangeEntity pieceDeRechangeByIdPiece) {
        this.pieceDeRechangeByIdPiece = pieceDeRechangeByIdPiece;
    }
}
