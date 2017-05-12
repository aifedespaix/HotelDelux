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
    private EquipementRestaurantEntity equipementRestaurantByIdReservation;

    
    
    public RestaurantAssocEntity(int id,
			MenuEntity menuByIdMenu, BoissonEntity boissonByIdBoisson, PlatEntity platByIdPlat,
			EquipementRestaurantEntity equipementRestaurantByIdReservation) {
		super();
		this.id = id;
		this.menuByIdMenu = menuByIdMenu;
		this.boissonByIdBoisson = boissonByIdBoisson;
		this.platByIdPlat = platByIdPlat;
		this.equipementRestaurantByIdReservation = equipementRestaurantByIdReservation;
	}
    
    
    

	public RestaurantAssocEntity(MenuEntity menuByIdMenu, BoissonEntity boissonByIdBoisson, PlatEntity platByIdPlat,
			EquipementRestaurantEntity equipementRestaurantByIdReservation) {
		super();
		this.menuByIdMenu = menuByIdMenu;
		this.boissonByIdBoisson = boissonByIdBoisson;
		this.platByIdPlat = platByIdPlat;
		this.equipementRestaurantByIdReservation = equipementRestaurantByIdReservation;
	}




	public RestaurantAssocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "RestaurantAssocEntity [id=" + id + ", menuByIdMenu=" + menuByIdMenu
				+ ", boissonByIdBoisson=" + boissonByIdBoisson + ", platByIdPlat=" + platByIdPlat
				+ ", equipementRestaurantByIdReservation=" + equipementRestaurantByIdReservation + "]";
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
    @JoinColumn(name = "id_reservation", referencedColumnName = "id", nullable = false)
    public EquipementRestaurantEntity getEquipementRestaurantByIdReservation() {
        return equipementRestaurantByIdReservation;
    }

    public void setEquipementRestaurantByIdReservation(EquipementRestaurantEntity equipementRestaurantByIdReservation) {
        this.equipementRestaurantByIdReservation = equipementRestaurantByIdReservation;
    }
}
