package src.Metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@javax.persistence.Table(name = "reservation_restaurant", schema = "hotel", catalog = "")
public class ReservationRestaurant {
    private int id;
    private Date dateArrivee;
    private Date dateDepart;
    private Tva tvaByIdTva;
    private Table tableByIdTable;
    private Collection<FacturationAssoc> facturationAssocsById;
    private Collection<RestaurantAssoc> restaurantAssocsById;

    public ReservationRestaurant(int id, Date dateArrivee, Date dateDepart, Tva tvaByIdTva, Table tableByIdTable,
			Collection<FacturationAssoc> facturationAssocsById, Collection<RestaurantAssoc> restaurantAssocsById) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.tvaByIdTva = tvaByIdTva;
		this.tableByIdTable = tableByIdTable;
		this.facturationAssocsById = facturationAssocsById;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public ReservationRestaurant(Date dateArrivee, Date dateDepart, Tva tvaByIdTva, Table tableByIdTable,
			Collection<FacturationAssoc> facturationAssocsById, Collection<RestaurantAssoc> restaurantAssocsById) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.tvaByIdTva = tvaByIdTva;
		this.tableByIdTable = tableByIdTable;
		this.facturationAssocsById = facturationAssocsById;
		this.restaurantAssocsById = restaurantAssocsById;
	}

	public ReservationRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReservationRestaurant [id=" + id + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart
				+ ", tvaByIdTva=" + tvaByIdTva + ", tableByIdTable=" + tableByIdTable + ", facturationAssocsById="
				+ facturationAssocsById + ", restaurantAssocsById=" + restaurantAssocsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_arrivee", nullable = false)
    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    @Basic
    @Column(name = "date_depart", nullable = false)
    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    @ManyToOne
    @JoinColumn(name = "id_tva", referencedColumnName = "id", nullable = false)
    public Tva getTvaByIdTva() {
        return tvaByIdTva;
    }

    public void setTvaByIdTva(Tva tvaByIdTva) {
        this.tvaByIdTva = tvaByIdTva;
    }

    @ManyToOne
    @JoinColumn(name = "id_table", referencedColumnName = "id", nullable = false)
    public Table getTableByIdTable() {
        return tableByIdTable;
    }

    public void setTableByIdTable(Table tableByIdTable) {
        this.tableByIdTable = tableByIdTable;
    }

    @OneToMany(mappedBy = "reservationRestaurantByIdReservationRestaurant")
    public Collection<FacturationAssoc> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssoc> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }

    @OneToMany(mappedBy = "reservationRestaurantByIdReservationRestaurant")
    public Collection<RestaurantAssoc> getRestaurantAssocsById() {
        return restaurantAssocsById;
    }

    public void setRestaurantAssocsById(Collection<RestaurantAssoc> restaurantAssocsById) {
        this.restaurantAssocsById = restaurantAssocsById;
    }
}
