package src.Metier;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "criticite", schema = "base_definitive", catalog = "")
public class CriticiteEntity {
    private int id;
    private String libelle;
    private Time tempsMaximum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "temps_maximum")
    public Time getTempsMaximum() {
        return tempsMaximum;
    }

    public void setTempsMaximum(Time tempsMaximum) {
        this.tempsMaximum = tempsMaximum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriticiteEntity that = (CriticiteEntity) o;

        if (id != that.id) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        if (tempsMaximum != null ? !tempsMaximum.equals(that.tempsMaximum) : that.tempsMaximum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (tempsMaximum != null ? tempsMaximum.hashCode() : 0);
        return result;
    }
}
