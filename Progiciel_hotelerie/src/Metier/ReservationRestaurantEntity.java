package src.Metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "reservation_restaurant", schema = "base_definitive", catalog = "")
public class ReservationRestaurantEntity {
    private int id;
    private Date dateArrivee;
    private Date dateDepart;
    private TvaEntity tvaByIdTva;
    private TableEntity tableByIdTable;

    
    public ReservationRestaurantEntity(int id, Date dateArrivee, Date dateDepart,
			TvaEntity tvaByIdTva, TableEntity tableByIdTable) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.tvaByIdTva = tvaByIdTva;
		this.tableByIdTable = tableByIdTable;
	}
    

	public ReservationRestaurantEntity(Date dateArrivee, Date dateDepart, TvaEntity tvaByIdTva,
			TableEntity tableByIdTable) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.tvaByIdTva = tvaByIdTva;
		this.tableByIdTable = tableByIdTable;
	}



	public ReservationRestaurantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "ReservationRestaurantEntity [id=" + id + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart
				+ ", idTable=" + ", tvaByIdTva=" + tvaByIdTva + ", tableByIdTable="
				+ tableByIdTable + "]";
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
    public TvaEntity getTvaByIdTva() {
        return tvaByIdTva;
    }

    public void setTvaByIdTva(TvaEntity tvaByIdTva) {
        this.tvaByIdTva = tvaByIdTva;
    }

    @ManyToOne
    @JoinColumn(name = "id_table", referencedColumnName = "id", nullable = false)
    public TableEntity getTableByIdTable() {
        return tableByIdTable;
    }

    public void setTableByIdTable(TableEntity tableByIdTable) {
        this.tableByIdTable = tableByIdTable;
    }
}
