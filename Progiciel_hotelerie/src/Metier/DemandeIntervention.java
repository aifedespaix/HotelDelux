package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "demande_intervention", schema = "hotel", catalog = "")
public class DemandeIntervention {
    private int id;
    private Date dateCreation;
    private String objet;
    private String description;
    private byte valide;
    private int idCriticite;
    private Integer idEquipementSpa;
    private Integer idEquipementHotel;
    private Integer idEquipementRestaurant;
    private Integer idPieceRechange;
    private Criticite criticiteByIdCriticite;
    private EquipementSpa equipementSpaByIdEquipementSpa;
    private EquipementHotel equipementHotelByIdEquipementHotel;
    private EquipementRestaurant equipementRestaurantByIdEquipementRestaurant;
    private PieceDeRechange pieceDeRechangeByIdPieceRechange;
    private Collection<DemandeUtilisateur> demandeUtilisateursById;
    private Collection<Rapport> rapportsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValide(Byte valide) {
        this.valide = valide;
    }

    public void setIdCriticite(Integer idCriticite) {
        this.idCriticite = idCriticite;
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
    @Column(name = "date_creation", nullable = false)
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Basic
    @Column(name = "objet", nullable = false, length = 250)
    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "valide", nullable = false)
    public byte getValide() {
        return valide;
    }

    public void setValide(byte valide) {
        this.valide = valide;
    }

    @ManyToOne
    @JoinColumn(name = "id_criticite", referencedColumnName = "id", nullable = false)
    public Criticite getCriticiteByIdCriticite() {
        return criticiteByIdCriticite;
    }

    public void setCriticiteByIdCriticite(Criticite criticiteByIdCriticite) {
        this.criticiteByIdCriticite = criticiteByIdCriticite;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_spa", referencedColumnName = "id")
    public EquipementSpa getEquipementSpaByIdEquipementSpa() {
        return equipementSpaByIdEquipementSpa;
    }

    public void setEquipementSpaByIdEquipementSpa(EquipementSpa equipementSpaByIdEquipementSpa) {
        this.equipementSpaByIdEquipementSpa = equipementSpaByIdEquipementSpa;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_hotel", referencedColumnName = "id")
    public EquipementHotel getEquipementHotelByIdEquipementHotel() {
        return equipementHotelByIdEquipementHotel;
    }

    public void setEquipementHotelByIdEquipementHotel(EquipementHotel equipementHotelByIdEquipementHotel) {
        this.equipementHotelByIdEquipementHotel = equipementHotelByIdEquipementHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_restaurant", referencedColumnName = "id")
    public EquipementRestaurant getEquipementRestaurantByIdEquipementRestaurant() {
        return equipementRestaurantByIdEquipementRestaurant;
    }

    public void setEquipementRestaurantByIdEquipementRestaurant(EquipementRestaurant equipementRestaurantByIdEquipementRestaurant) {
        this.equipementRestaurantByIdEquipementRestaurant = equipementRestaurantByIdEquipementRestaurant;
    }

    @ManyToOne
    @JoinColumn(name = "id_piece_rechange", referencedColumnName = "id")
    public PieceDeRechange getPieceDeRechangeByIdPieceRechange() {
        return pieceDeRechangeByIdPieceRechange;
    }

    public void setPieceDeRechangeByIdPieceRechange(PieceDeRechange pieceDeRechangeByIdPieceRechange) {
        this.pieceDeRechangeByIdPieceRechange = pieceDeRechangeByIdPieceRechange;
    }

    @OneToMany(mappedBy = "demandeInterventionByIdDemande")
    public Collection<DemandeUtilisateur> getDemandeUtilisateursById() {
        return demandeUtilisateursById;
    }

    public void setDemandeUtilisateursById(Collection<DemandeUtilisateur> demandeUtilisateursById) {
        this.demandeUtilisateursById = demandeUtilisateursById;
    }

    @OneToMany(mappedBy = "demandeInterventionByIdDemandeIntervention")
    public Collection<Rapport> getRapportsById() {
        return rapportsById;
    }

    public void setRapportsById(Collection<Rapport> rapportsById) {
        this.rapportsById = rapportsById;
    }
}
