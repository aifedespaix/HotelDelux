package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "restaurant_assoc", schema = "base_definitive", catalog = "")
public class RestaurantAssocEntity {
    private int id;
    private Integer idMenu;
    private Integer idBoisson;
    private Integer idPlat;
    private int idReservation;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_menu")
    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    @Basic
    @Column(name = "id_boisson")
    public Integer getIdBoisson() {
        return idBoisson;
    }

    public void setIdBoisson(Integer idBoisson) {
        this.idBoisson = idBoisson;
    }

    @Basic
    @Column(name = "id_plat")
    public Integer getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(Integer idPlat) {
        this.idPlat = idPlat;
    }

    @Basic
    @Column(name = "id_reservation")
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantAssocEntity that = (RestaurantAssocEntity) o;

        if (id != that.id) return false;
        if (idReservation != that.idReservation) return false;
        if (idMenu != null ? !idMenu.equals(that.idMenu) : that.idMenu != null) return false;
        if (idBoisson != null ? !idBoisson.equals(that.idBoisson) : that.idBoisson != null) return false;
        if (idPlat != null ? !idPlat.equals(that.idPlat) : that.idPlat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idMenu != null ? idMenu.hashCode() : 0);
        result = 31 * result + (idBoisson != null ? idBoisson.hashCode() : 0);
        result = 31 * result + (idPlat != null ? idPlat.hashCode() : 0);
        result = 31 * result + idReservation;
        return result;
    }
}
