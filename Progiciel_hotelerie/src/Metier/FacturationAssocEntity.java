package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "facturation_assoc", schema = "base_definitive", catalog = "")
public class FacturationAssocEntity {
    private int id;
    //private int idReservation;
    private ReservationHotelEntity reservationHotelByIdReservationHotel;
    private ReservationRestaurantEntity reservationRestaurantByIdReservationRestaurant;
    private ReservationSpaEntity reservationSpaByIdReservationSpa;
    private ClientEntity clientByIdClient;
    private FactureEntity factureByIdFacture;

    

	public FacturationAssocEntity(int id, ReservationHotelEntity reservationHotelByIdReservationHotel,
			ReservationRestaurantEntity reservationRestaurantByIdReservationRestaurant,
			ReservationSpaEntity reservationSpaByIdReservationSpa, ClientEntity clientByIdClient,
			FactureEntity factureByIdFacture) {
		super();
		this.id = id;
		this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
		this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
		this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
		this.clientByIdClient = clientByIdClient;
		this.factureByIdFacture = factureByIdFacture;
	}
	
	

	public FacturationAssocEntity(ReservationHotelEntity reservationHotelByIdReservationHotel,
			ReservationRestaurantEntity reservationRestaurantByIdReservationRestaurant,
			ReservationSpaEntity reservationSpaByIdReservationSpa, ClientEntity clientByIdClient,
			FactureEntity factureByIdFacture) {
		super();
		this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
		this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
		this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
		this.clientByIdClient = clientByIdClient;
		this.factureByIdFacture = factureByIdFacture;
	}



	public FacturationAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FacturationAssocEntity [id=" + id + ", reservationHotelByIdReservationHotel="
				+ reservationHotelByIdReservationHotel + ", reservationRestaurantByIdReservationRestaurant="
				+ reservationRestaurantByIdReservationRestaurant + ", reservationSpaByIdReservationSpa="
				+ reservationSpaByIdReservationSpa + ", clientByIdClient=" + clientByIdClient + ", factureByIdFacture="
				+ factureByIdFacture + "]";
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
    @JoinColumn(name = "id_reservation_hotel", referencedColumnName = "id", nullable = false)
    public ReservationHotelEntity getReservationHotelByIdReservationHotel() {
		return reservationHotelByIdReservationHotel;
	}



	public void setReservationHotelByIdReservationHotel(ReservationHotelEntity reservationHotelByIdReservationHotel) {
		this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
	}


	@ManyToOne
    @JoinColumn(name = "id_reservation_restaurant", referencedColumnName = "id", nullable = false)
	public ReservationRestaurantEntity getReservationRestaurantByIdReservationRestaurant() {
		return reservationRestaurantByIdReservationRestaurant;
	}



	public void setReservationRestaurantByIdReservationRestaurant(
			ReservationRestaurantEntity reservationRestaurantByIdReservationRestaurant) {
		this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
	}


	@ManyToOne
    @JoinColumn(name = "id_reservation_spa", referencedColumnName = "id", nullable = false)
	public ReservationSpaEntity getReservationSpaByIdReservationSpa() {
		return reservationSpaByIdReservationSpa;
	}



	public void setReservationSpaByIdReservationSpa(ReservationSpaEntity reservationSpaByIdReservationSpa) {
		this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
	}



	@ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(name = "id_facture", referencedColumnName = "id", nullable = false)
    public FactureEntity getFactureByIdFacture() {
        return factureByIdFacture;
    }

    public void setFactureByIdFacture(FactureEntity factureByIdFacture) {
        this.factureByIdFacture = factureByIdFacture;
    }
}
