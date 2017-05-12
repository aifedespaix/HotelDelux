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
    private int idTva;
    private int idTable;
    private TvaEntity tvaByIdTva;
    private TableEntity tableByIdTable;

    
    public ReservationRestaurantEntity(int id, Date dateArrivee, Date dateDepart, int idTva, int idTable,
			TvaEntity tvaByIdTva, TableEntity tableByIdTable) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.idTva = idTva;
		this.idTable = idTable;
		this.tvaByIdTva = tvaByIdTva;
		this.tableByIdTable = tableByIdTable;
	}
    

	public ReservationRestaurantEntity(Date dateArrivee, Date dateDepart, int idTva, int idTable, TvaEntity tvaByIdTva,
			TableEntity tableByIdTable) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.idTva = idTva;
		this.idTable = idTable;
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
				+ ", idTva=" + idTva + ", idTable=" + idTable + ", tvaByIdTva=" + tvaByIdTva + ", tableByIdTable="
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

    @Basic
    @Column(name = "id_tva", nullable = false)
    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    @Basic
    @Column(name = "id_table", nullable = false)
    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationRestaurantEntity that = (ReservationRestaurantEntity) o;

        if (id != that.id) return false;
        if (idTva != that.idTva) return false;
        if (idTable != that.idTable) return false;
        if (dateArrivee != null ? !dateArrivee.equals(that.dateArrivee) : that.dateArrivee != null) return false;
        if (dateDepart != null ? !dateDepart.equals(that.dateDepart) : that.dateDepart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateArrivee != null ? dateArrivee.hashCode() : 0);
        result = 31 * result + (dateDepart != null ? dateDepart.hashCode() : 0);
        result = 31 * result + idTva;
        result = 31 * result + idTable;
        return result;
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
