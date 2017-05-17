package src.Metier;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@Table(name = "restaurant_assoc", schema = "hotel", catalog = "")
public class RestaurantAssoc {
    private int id;
    private Menu menuByIdMenu;
    private Boisson boissonByIdBoisson;
    private Plat platByIdPlat;
    private ReservationRestaurant reservationRestaurantByIdReservationRestaurant;

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
    @JoinColumn(name = "id_menu", referencedColumnName = "id")
    public Menu getMenuByIdMenu() {
        return menuByIdMenu;
    }

    public void setMenuByIdMenu(Menu menuByIdMenu) {
        this.menuByIdMenu = menuByIdMenu;
    }

    @ManyToOne
    @JoinColumn(name = "id_boisson", referencedColumnName = "id")
    public Boisson getBoissonByIdBoisson() {
        return boissonByIdBoisson;
    }

    public void setBoissonByIdBoisson(Boisson boissonByIdBoisson) {
        this.boissonByIdBoisson = boissonByIdBoisson;
    }

    @ManyToOne
    @JoinColumn(name = "id_plat", referencedColumnName = "id")
    public Plat getPlatByIdPlat() {
        return platByIdPlat;
    }

    public void setPlatByIdPlat(Plat platByIdPlat) {
        this.platByIdPlat = platByIdPlat;
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
