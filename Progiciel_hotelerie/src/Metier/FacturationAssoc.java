package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "facturation_assoc", schema = "hotel", catalog = "")
public class FacturationAssoc {
    private int id;
    private Client clientByIdClient;
    private Facture factureByIdFacture;
    private ReservationSpa reservationSpaByIdReservationSpa;
    private ReservationHotel reservationHotelByIdReservationHotel;
    private ReservationRestaurant reservationRestaurantByIdReservationRestaurant;

    public FacturationAssoc(int id, Client clientByIdClient, Facture factureByIdFacture,
			ReservationSpa reservationSpaByIdReservationSpa, ReservationHotel reservationHotelByIdReservationHotel,
			ReservationRestaurant reservationRestaurantByIdReservationRestaurant) {
		super();
		this.id = id;
		this.clientByIdClient = clientByIdClient;
		this.factureByIdFacture = factureByIdFacture;
		this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
		this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
		this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
	}

	public FacturationAssoc(Client clientByIdClient, Facture factureByIdFacture,
			ReservationSpa reservationSpaByIdReservationSpa, ReservationHotel reservationHotelByIdReservationHotel,
			ReservationRestaurant reservationRestaurantByIdReservationRestaurant) {
		super();
		this.clientByIdClient = clientByIdClient;
		this.factureByIdFacture = factureByIdFacture;
		this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
		this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
		this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
	}

	public FacturationAssoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FacturationAssoc [id=" + id + ", clientByIdClient=" + clientByIdClient + ", factureByIdFacture="
				+ factureByIdFacture + ", reservationSpaByIdReservationSpa=" + reservationSpaByIdReservationSpa
				+ ", reservationHotelByIdReservationHotel=" + reservationHotelByIdReservationHotel
				+ ", reservationRestaurantByIdReservationRestaurant=" + reservationRestaurantByIdReservationRestaurant
				+ "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    public Client getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(Client clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(name = "id_facture", referencedColumnName = "id", nullable = false)
    public Facture getFactureByIdFacture() {
        return factureByIdFacture;
    }

    public void setFactureByIdFacture(Facture factureByIdFacture) {
        this.factureByIdFacture = factureByIdFacture;
    }

    @ManyToOne
    @JoinColumn(name = "id_reservation_spa", referencedColumnName = "id")
    public ReservationSpa getReservationSpaByIdReservationSpa() {
        return reservationSpaByIdReservationSpa;
    }

    public void setReservationSpaByIdReservationSpa(ReservationSpa reservationSpaByIdReservationSpa) {
        this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
    }

    @ManyToOne
    @JoinColumn(name = "id_reservation_hotel", referencedColumnName = "id")
    public ReservationHotel getReservationHotelByIdReservationHotel() {
        return reservationHotelByIdReservationHotel;
    }

    public void setReservationHotelByIdReservationHotel(ReservationHotel reservationHotelByIdReservationHotel) {
        this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_reservation_restaurant", referencedColumnName = "id")
    public ReservationRestaurant getReservationRestaurantByIdReservationRestaurant() {
        return reservationRestaurantByIdReservationRestaurant;
    }

    public void setReservationRestaurantByIdReservationRestaurant(ReservationRestaurant reservationRestaurantByIdReservationRestaurant) {
        this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
    }
}
