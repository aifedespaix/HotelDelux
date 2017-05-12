package src.Metier;

import javax.persistence.*;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "spa", schema = "base_definitive", catalog = "")
public class SpaEntity {
    private int id;
    private int numero;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numero")
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
}
