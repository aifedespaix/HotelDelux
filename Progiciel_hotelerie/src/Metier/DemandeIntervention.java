package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mysql.jdbc.Util;

import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "demande_intervention", schema = "hotel", catalog = "")
public class DemandeIntervention extends RecursiveTreeObject<DemandeIntervention> {
    private int id;
    private Date dateCreation;
    private String objet;
    private String description;
    private boolean valide;
    private Criticite criticiteByIdCriticite;
    private EquipementSpa equipementSpaByIdEquipementSpa;
    private EquipementHotel equipementHotelByIdEquipementHotel;
    private EquipementRestaurant equipementRestaurantByIdEquipementRestaurant;
    private PieceDeRechange pieceDeRechangeByIdPieceRechange;
    private Collection<DemandeUtilisateur> demandeUtilisateursById;
    private Collection<Rapport> rapportsById;
    private Utilisateur demandeurById;
    private Etat etat;
    
    public DemandeIntervention(int id, Date dateCreation, String objet, String description, boolean valide,
			Criticite criticiteByIdCriticite, EquipementSpa equipementSpaByIdEquipementSpa,
			EquipementHotel equipementHotelByIdEquipementHotel,
			EquipementRestaurant equipementRestaurantByIdEquipementRestaurant,
			PieceDeRechange pieceDeRechangeByIdPieceRechange, Collection<DemandeUtilisateur> demandeUtilisateursById,
			Collection<Rapport> rapportsById, Utilisateur demandeurById, Etat etat) {
		super();
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
		this.demandeurById = demandeurById;
		this.etat = etat;
	}

	public DemandeIntervention(Date dateCreation, String objet, String description, boolean valide,
			Criticite criticiteByIdCriticite, EquipementSpa equipementSpaByIdEquipementSpa,
			EquipementHotel equipementHotelByIdEquipementHotel,
			EquipementRestaurant equipementRestaurantByIdEquipementRestaurant,
			PieceDeRechange pieceDeRechangeByIdPieceRechange, Collection<DemandeUtilisateur> demandeUtilisateursById,
			Collection<Rapport> rapportsById, Utilisateur demandeurById, Etat etat) {
		super();
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
		this.demandeurById = demandeurById;
		this.etat = etat;
	}

	public DemandeIntervention() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DemandeIntervention [id=" + id + ", dateCreation=" + dateCreation + ", objet=" + objet
				+ ", description=" + description + ", valide=" + valide + ", criticiteByIdCriticite="
				+ criticiteByIdCriticite + ", equipementSpaByIdEquipementSpa=" + equipementSpaByIdEquipementSpa
				+ ", equipementHotelByIdEquipementHotel=" + equipementHotelByIdEquipementHotel
				+ ", equipementRestaurantByIdEquipementRestaurant=" + equipementRestaurantByIdEquipementRestaurant
				+ ", pieceDeRechangeByIdPieceRechange=" + pieceDeRechangeByIdPieceRechange
				+ ", demandeUtilisateursById=" + demandeUtilisateursById + ", rapportsById=" + rapportsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
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
    public boolean getValide() {
        return valide;
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
    
    @ManyToOne
    @JoinColumn(name = "id_demandeur", referencedColumnName = "id", nullable = false)
	public Utilisateur getDemandeurById() {
		return demandeurById;
	}

	public void setDemandeurById(Utilisateur demandeurById) {
		this.demandeurById = demandeurById;
	}

	@ManyToOne
    @JoinColumn(name = "id_etat", referencedColumnName = "id", nullable = false)
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
}
