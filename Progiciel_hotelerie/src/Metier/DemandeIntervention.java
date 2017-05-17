package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "demande_intervention", schema = "base_definitive", catalog = "")
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

    @Basic
    @Column(name = "id_criticite", nullable = false)
    public int getIdCriticite() {
        return idCriticite;
    }

    public void setIdCriticite(int idCriticite) {
        this.idCriticite = idCriticite;
    }

    @Basic
    @Column(name = "id_equipement_spa", nullable = true)
    public Integer getIdEquipementSpa() {
        return idEquipementSpa;
    }

    public void setIdEquipementSpa(Integer idEquipementSpa) {
        this.idEquipementSpa = idEquipementSpa;
    }

    @Basic
    @Column(name = "id_equipement_hotel", nullable = true)
    public Integer getIdEquipementHotel() {
        return idEquipementHotel;
    }

    public void setIdEquipementHotel(Integer idEquipementHotel) {
        this.idEquipementHotel = idEquipementHotel;
    }

    @Basic
    @Column(name = "id_equipement_restaurant", nullable = true)
    public Integer getIdEquipementRestaurant() {
        return idEquipementRestaurant;
    }

    public void setIdEquipementRestaurant(Integer idEquipementRestaurant) {
        this.idEquipementRestaurant = idEquipementRestaurant;
    }

    @Basic
    @Column(name = "id_piece_rechange", nullable = true)
    public Integer getIdPieceRechange() {
        return idPieceRechange;
    }

    public void setIdPieceRechange(Integer idPieceRechange) {
        this.idPieceRechange = idPieceRechange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemandeIntervention that = (DemandeIntervention) o;

        if (id != that.id) return false;
        if (valide != that.valide) return false;
        if (idCriticite != that.idCriticite) return false;
        if (dateCreation != null ? !dateCreation.equals(that.dateCreation) : that.dateCreation != null) return false;
        if (objet != null ? !objet.equals(that.objet) : that.objet != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (idEquipementSpa != null ? !idEquipementSpa.equals(that.idEquipementSpa) : that.idEquipementSpa != null)
            return false;
        if (idEquipementHotel != null ? !idEquipementHotel.equals(that.idEquipementHotel) : that.idEquipementHotel != null)
            return false;
        if (idEquipementRestaurant != null ? !idEquipementRestaurant.equals(that.idEquipementRestaurant) : that.idEquipementRestaurant != null)
            return false;
        if (idPieceRechange != null ? !idPieceRechange.equals(that.idPieceRechange) : that.idPieceRechange != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        result = 31 * result + (objet != null ? objet.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) valide;
        result = 31 * result + idCriticite;
        result = 31 * result + (idEquipementSpa != null ? idEquipementSpa.hashCode() : 0);
        result = 31 * result + (idEquipementHotel != null ? idEquipementHotel.hashCode() : 0);
        result = 31 * result + (idEquipementRestaurant != null ? idEquipementRestaurant.hashCode() : 0);
        result = 31 * result + (idPieceRechange != null ? idPieceRechange.hashCode() : 0);
        return result;
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
