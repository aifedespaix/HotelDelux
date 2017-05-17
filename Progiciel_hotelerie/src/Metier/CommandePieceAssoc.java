package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "commande_piece_assoc", schema = "base_definitive", catalog = "")
public class CommandePieceAssoc {
    private int id;
    private int idCommande;
    private int idPiece;
    private double quantite;
    private Commande commandeByIdCommande;
    private PieceDeRechange pieceDeRechangeByIdPiece;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public void setIdPiece(Integer idPiece) {
        this.idPiece = idPiece;
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

    @ManyToOne
    @JoinColumn(name = "id_commande", referencedColumnName = "id", nullable = false)
    public Commande getCommandeByIdCommande() {
        return commandeByIdCommande;
    }

    public void setCommandeByIdCommande(Commande commandeByIdCommande) {
        this.commandeByIdCommande = commandeByIdCommande;
    }

    @ManyToOne
    @JoinColumn(name = "id_piece", referencedColumnName = "id", nullable = false)
    public PieceDeRechange getPieceDeRechangeByIdPiece() {
        return pieceDeRechangeByIdPiece;
    }

    public void setPieceDeRechangeByIdPiece(PieceDeRechange pieceDeRechangeByIdPiece) {
        this.pieceDeRechangeByIdPiece = pieceDeRechangeByIdPiece;
    }
}
