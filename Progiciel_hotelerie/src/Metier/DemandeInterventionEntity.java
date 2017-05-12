package src.Metier;

import javax.persistence.*;
import java.sql.Date;

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
    private byte valide;
    private int idCriticite;
    private Integer idEquipementSpa;
    private Integer idEquipementHotel;
    private Integer idEquipementRestaurant;
    private Integer idPieceRechange;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_creation")
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Basic
    @Column(name = "objet")
    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "valide")
    public byte getValide() {
        return valide;
    }

    public void setValide(byte valide) {
        this.valide = valide;
    }

    @Basic
    @Column(name = "id_criticite")
    public int getIdCriticite() {
        return idCriticite;
    }

    public void setIdCriticite(int idCriticite) {
        this.idCriticite = idCriticite;
    }

    @Basic
    @Column(name = "id_equipement_spa")
    public Integer getIdEquipementSpa() {
        return idEquipementSpa;
    }

    public void setIdEquipementSpa(Integer idEquipementSpa) {
        this.idEquipementSpa = idEquipementSpa;
    }

    @Basic
    @Column(name = "id_equipement_hotel")
    public Integer getIdEquipementHotel() {
        return idEquipementHotel;
    }

    public void setIdEquipementHotel(Integer idEquipementHotel) {
        this.idEquipementHotel = idEquipementHotel;
    }

    @Basic
    @Column(name = "id_equipement_restaurant")
    public Integer getIdEquipementRestaurant() {
        return idEquipementRestaurant;
    }

    public void setIdEquipementRestaurant(Integer idEquipementRestaurant) {
        this.idEquipementRestaurant = idEquipementRestaurant;
    }

    @Basic
    @Column(name = "id_piece_rechange")
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

        DemandeInterventionEntity that = (DemandeInterventionEntity) o;

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
}
