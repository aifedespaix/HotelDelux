package src.Metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "demande_intervention", schema = "base_definitive", catalog = "")
public class DemandeInterventionEntity {
    private int id;
    private Date dateCreation;
    private String objet;
    private String description;
    private Boolean valide;
    private CriticiteEntity criticiteByIdCriticite;
    private EquipementSpaEntity equipementSpaByIdEquipementSpa;
    private EquipementHotelEntity equipementHotelByIdEquipementHotel;
    private EquipementRestaurantEntity equipementRestaurantByIdEquipementRestaurant;
    private PieceDeRechangeEntity pieceDeRechangeByIdPieceRechange;
    private Collection<DemandeUtilisateurEntity> demandeUtilisateursById;
    private Collection<RapportEntity> rapportsById;


    public DemandeInterventionEntity(int id, Date dateCreation, String objet, String description, Boolean valide, CriticiteEntity criticiteByIdCriticite, EquipementSpaEntity equipementSpaByIdEquipementSpa, EquipementHotelEntity equipementHotelByIdEquipementHotel, EquipementRestaurantEntity equipementRestaurantByIdEquipementRestaurant, PieceDeRechangeEntity pieceDeRechangeByIdPieceRechange, Collection<DemandeUtilisateurEntity> demandeUtilisateursById, Collection<RapportEntity> rapportsById) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.objet = objet;
        this.description = description;
        this.valide = valide;
        this.criticiteByIdCriticite = criticiteByIdCriticite;
        this.equipementSpaByIdEquipementSpa = equipementSpaByIdEquipementSpa;
        this.equipementHotelByIdEquipementHotel = equipementHotelByIdEquipementHotel;
        this.equipementRestaurantByIdEquipementRestaurant = equipementRestaurantByIdEquipementRestaurant;
        this.pieceDeRechangeByIdPieceRechange = pieceDeRechangeByIdPieceRechange;
        this.demandeUtilisateursById = demandeUtilisateursById;
        this.rapportsById = rapportsById;
    }

    public DemandeInterventionEntity(Date dateCreation, String objet, String description, Boolean valide, CriticiteEntity criticiteByIdCriticite, EquipementSpaEntity equipementSpaByIdEquipementSpa, EquipementHotelEntity equipementHotelByIdEquipementHotel, EquipementRestaurantEntity equipementRestaurantByIdEquipementRestaurant, PieceDeRechangeEntity pieceDeRechangeByIdPieceRechange, Collection<DemandeUtilisateurEntity> demandeUtilisateursById, Collection<RapportEntity> rapportsById) {
        this.dateCreation = dateCreation;
        this.objet = objet;
        this.description = description;
        this.valide = valide;
        this.criticiteByIdCriticite = criticiteByIdCriticite;
        this.equipementSpaByIdEquipementSpa = equipementSpaByIdEquipementSpa;
        this.equipementHotelByIdEquipementHotel = equipementHotelByIdEquipementHotel;
        this.equipementRestaurantByIdEquipementRestaurant = equipementRestaurantByIdEquipementRestaurant;
        this.pieceDeRechangeByIdPieceRechange = pieceDeRechangeByIdPieceRechange;
        this.demandeUtilisateursById = demandeUtilisateursById;
        this.rapportsById = rapportsById;
    }

    public DemandeInterventionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

    @Override
    public String toString() {
        return "DemandeInterventionEntity{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", objet='" + objet + '\'' +
                ", description='" + description + '\'' +
                ", valide=" + valide +
                ", criticiteByIdCriticite=" + criticiteByIdCriticite +
                ", equipementSpaByIdEquipementSpa=" + equipementSpaByIdEquipementSpa +
                ", equipementHotelByIdEquipementHotel=" + equipementHotelByIdEquipementHotel +
                ", equipementRestaurantByIdEquipementRestaurant=" + equipementRestaurantByIdEquipementRestaurant +
                ", pieceDeRechangeByIdPieceRechange=" + pieceDeRechangeByIdPieceRechange +
                ", demandeUtilisateursById=" + demandeUtilisateursById +
                ", rapportsById=" + rapportsById +
                '}';
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
    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    @ManyToOne
    @JoinColumn(name = "id_criticite", referencedColumnName = "id", nullable = false)
    public CriticiteEntity getCriticiteByIdCriticite() {
        return criticiteByIdCriticite;
    }

    public void setCriticiteByIdCriticite(CriticiteEntity criticiteByIdCriticite) {
        this.criticiteByIdCriticite = criticiteByIdCriticite;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_spa", referencedColumnName = "id")
    public EquipementSpaEntity getEquipementSpaByIdEquipementSpa() {
        return equipementSpaByIdEquipementSpa;
    }

    public void setEquipementSpaByIdEquipementSpa(EquipementSpaEntity equipementSpaByIdEquipementSpa) {
        this.equipementSpaByIdEquipementSpa = equipementSpaByIdEquipementSpa;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_hotel", referencedColumnName = "id")
    public EquipementHotelEntity getEquipementHotelByIdEquipementHotel() {
        return equipementHotelByIdEquipementHotel;
    }

    public void setEquipementHotelByIdEquipementHotel(EquipementHotelEntity equipementHotelByIdEquipementHotel) {
        this.equipementHotelByIdEquipementHotel = equipementHotelByIdEquipementHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipement_restaurant", referencedColumnName = "id")
    public EquipementRestaurantEntity getEquipementRestaurantByIdEquipementRestaurant() {
        return equipementRestaurantByIdEquipementRestaurant;
    }

    public void setEquipementRestaurantByIdEquipementRestaurant(EquipementRestaurantEntity equipementRestaurantByIdEquipementRestaurant) {
        this.equipementRestaurantByIdEquipementRestaurant = equipementRestaurantByIdEquipementRestaurant;
    }

    @ManyToOne
    @JoinColumn(name = "id_piece_rechange", referencedColumnName = "id")
    public PieceDeRechangeEntity getPieceDeRechangeByIdPieceRechange() {
        return pieceDeRechangeByIdPieceRechange;
    }

    public void setPieceDeRechangeByIdPieceRechange(PieceDeRechangeEntity pieceDeRechangeByIdPieceRechange) {
        this.pieceDeRechangeByIdPieceRechange = pieceDeRechangeByIdPieceRechange;
    }

    @OneToMany(mappedBy = "demandeInterventionByIdDemande")
    public Collection<DemandeUtilisateurEntity> getDemandeUtilisateursById() {
        return demandeUtilisateursById;
    }

    public void setDemandeUtilisateursById(Collection<DemandeUtilisateurEntity> demandeUtilisateursById) {
        this.demandeUtilisateursById = demandeUtilisateursById;
    }

    @OneToMany(mappedBy = "demandeInterventionByIdDemandeIntervention")
    public Collection<RapportEntity> getRapportsById() {
        return rapportsById;
    }

    public void setRapportsById(Collection<RapportEntity> rapportsById) {
        this.rapportsById = rapportsById;
    }
}
