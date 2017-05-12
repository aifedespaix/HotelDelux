package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "spa", schema = "base_definitive", catalog = "")
public class SpaEntity {
    private int id;
    private int numero;
    private Collection<EquipementSpaEntity> equipementSpasById;
    private Collection<ReservationSpaEntity> reservationSpasById;

    
    public SpaEntity(int id, int numero, Collection<EquipementSpaEntity> equipementSpasById,
			Collection<ReservationSpaEntity> reservationSpasById) {
		super();
		this.id = id;
		this.numero = numero;
		this.equipementSpasById = equipementSpasById;
		this.reservationSpasById = reservationSpasById;
	}
    
    

	public SpaEntity(int numero, Collection<EquipementSpaEntity> equipementSpasById,
			Collection<ReservationSpaEntity> reservationSpasById) {
		super();
		this.numero = numero;
		this.equipementSpasById = equipementSpasById;
		this.reservationSpasById = reservationSpasById;
	}



	@Override
	public String toString() {
		return "SpaEntity [id=" + id + ", numero=" + numero + ", equipementSpasById=" + equipementSpasById
				+ ", reservationSpasById=" + reservationSpasById + "]";
	}



	public SpaEntity() {
		super();
		// TODO Auto-generated constructor stub
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpaEntity spaEntity = (SpaEntity) o;

        if (id != spaEntity.id) return false;
        if (numero != spaEntity.numero) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + numero;
        return result;
    }

    @OneToMany(mappedBy = "spaByIdSpa")
    public Collection<EquipementSpaEntity> getEquipementSpasById() {
        return equipementSpasById;
    }

    public void setEquipementSpasById(Collection<EquipementSpaEntity> equipementSpasById) {
        this.equipementSpasById = equipementSpasById;
    }

    @OneToMany(mappedBy = "spaByIdSpa")
    public Collection<ReservationSpaEntity> getReservationSpasById() {
        return reservationSpasById;
    }

    public void setReservationSpasById(Collection<ReservationSpaEntity> reservationSpasById) {
        this.reservationSpasById = reservationSpasById;
    }
}
