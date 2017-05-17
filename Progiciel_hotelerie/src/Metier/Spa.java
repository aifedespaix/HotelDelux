package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Spa {
    private int id;
    private int numero;
    private Collection<EquipementSpa> equipementSpasById;
    private Collection<ReservationSpa> reservationSpasById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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
    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @OneToMany(mappedBy = "spaByIdSpa")
    public Collection<EquipementSpa> getEquipementSpasById() {
        return equipementSpasById;
    }

    public void setEquipementSpasById(Collection<EquipementSpa> equipementSpasById) {
        this.equipementSpasById = equipementSpasById;
    }

    @OneToMany(mappedBy = "spaByIdSpa")
    public Collection<ReservationSpa> getReservationSpasById() {
        return reservationSpasById;
    }

    public void setReservationSpasById(Collection<ReservationSpa> reservationSpasById) {
        this.reservationSpasById = reservationSpasById;
    }
}
