package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "commande_piece_assoc", schema = "base_definitive", catalog = "")
public class CommandePieceAssocEntity {
    private int id;
    private int idCommande;
    private int idPiece;
    private double quantite;
    private CommandeEntity commandeByIdCommande;
    private PieceDeRechangeEntity pieceDeRechangeByIdPiece;

    public CommandePieceAssocEntity(int id, int idCommande, int idPiece, double quantite,
			CommandeEntity commandeByIdCommande, PieceDeRechangeEntity pieceDeRechangeByIdPiece) {
		super();
		this.id = id;
		this.idCommande = idCommande;
		this.idPiece = idPiece;
		this.quantite = quantite;
		this.commandeByIdCommande = commandeByIdCommande;
		this.pieceDeRechangeByIdPiece = pieceDeRechangeByIdPiece;
	}

	public CommandePieceAssocEntity(int idCommande, int idPiece, double quantite, CommandeEntity commandeByIdCommande,
			PieceDeRechangeEntity pieceDeRechangeByIdPiece) {
		super();
		this.idCommande = idCommande;
		this.idPiece = idPiece;
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
		return "CommandePieceAssocEntity [id=" + id + ", idCommande=" + idCommande + ", idPiece=" + idPiece
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
    @Column(name = "id_commande", nullable = false)
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Basic
    @Column(name = "id_piece", nullable = false)
    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
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

        CommandePieceAssocEntity that = (CommandePieceAssocEntity) o;

        if (id != that.id) return false;
        if (idCommande != that.idCommande) return false;
        if (idPiece != that.idPiece) return false;
        if (Double.compare(that.quantite, quantite) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + idCommande;
        result = 31 * result + idPiece;
        temp = Double.doubleToLongBits(quantite);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
