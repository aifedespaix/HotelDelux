package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "restaurant_assoc", schema = "base_definitive", catalog = "")
public class RestaurantAssocEntity {
    private int id;
    private MenuEntity menuByIdMenu;
    private BoissonEntity boissonByIdBoisson;
    private PlatEntity platByIdPlat;
    private ReservationHotelEntity reservationHotelByIdReservationHotel;
    private ReservationRestaurantEntity reservationRestaurantByIdReservationRestaurant;
    private ReservationSpaEntity reservationSpaByIdReservationSpa;


	public RestaurantAssocEntity(int id, MenuEntity menuByIdMenu, BoissonEntity boissonByIdBoisson,
			PlatEntity platByIdPlat, ReservationHotelEntity reservationHotelByIdReservationHotel,
			ReservationRestaurantEntity reservationRestaurantByIdReservationRestaurant,
			ReservationSpaEntity reservationSpaByIdReservationSpa) {
		super();
		this.id = id;
		this.menuByIdMenu = menuByIdMenu;
		this.boissonByIdBoisson = boissonByIdBoisson;
		this.platByIdPlat = platByIdPlat;
		this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
		this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
		this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
	}


	public RestaurantAssocEntity(MenuEntity menuByIdMenu, BoissonEntity boissonByIdBoisson, PlatEntity platByIdPlat,
			ReservationHotelEntity reservationHotelByIdReservationHotel,
			ReservationRestaurantEntity reservationRestaurantByIdReservationRestaurant,
			ReservationSpaEntity reservationSpaByIdReservationSpa) {
		super();
		this.menuByIdMenu = menuByIdMenu;
		this.boissonByIdBoisson = boissonByIdBoisson;
		this.platByIdPlat = platByIdPlat;
		this.reservationHotelByIdReservationHotel = reservationHotelByIdReservationHotel;
		this.reservationRestaurantByIdReservationRestaurant = reservationRestaurantByIdReservationRestaurant;
		this.reservationSpaByIdReservationSpa = reservationSpaByIdReservationSpa;
	}




	public RestaurantAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "RestaurantAssocEntity [id=" + id + ", menuByIdMenu=" + menuByIdMenu + ", boissonByIdBoisson="
				+ boissonByIdBoisson + ", platByIdPlat=" + platByIdPlat + ", reservationHotelByIdReservationHotel="
				+ reservationHotelByIdReservationHotel + ", reservationRestaurantByIdReservationRestaurant="
				+ reservationRestaurantByIdReservationRestaurant + ", reservationSpaByIdReservationSpa="
				+ reservationSpaByIdReservationSpa + "]";
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
    @JoinColumn(name = "id_menu", referencedColumnName = "id")
    public MenuEntity getMenuByIdMenu() {
        return menuByIdMenu;
    }

    public void setMenuByIdMenu(MenuEntity menuByIdMenu) {
        this.menuByIdMenu = menuByIdMenu;
    }

    @ManyToOne
    @JoinColumn(name = "id_boisson", referencedColumnName = "id")
    public BoissonEntity getBoissonByIdBoisson() {
        return boissonByIdBoisson;
    }

    public void setBoissonByIdBoisson(BoissonEntity boissonByIdBoisson) {
        this.boissonByIdBoisson = boissonByIdBoisson;
    }

    @ManyToOne
    @JoinColumn(name = "id_plat", referencedColumnName = "id")
    public PlatEntity getPlatByIdPlat() {
        return platByIdPlat;
    }

    public void setPlatByIdPlat(PlatEntity platByIdPlat) {
        this.platByIdPlat = platByIdPlat;
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
    
    
    
}
