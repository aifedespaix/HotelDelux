package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Agence {
    private int id;
    private String nom;
    private int telephone;
    private String email;
    private Collection<ClientAgenceAssoc> clientAgenceAssocsById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
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
    @Column(name = "nom", nullable = false, length = 250)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "telephone", nullable = false)
    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 250)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "agenceByIdAgence")
    public Collection<ClientAgenceAssoc> getClientAgenceAssocsById() {
        return clientAgenceAssocsById;
    }

    public void setClientAgenceAssocsById(Collection<ClientAgenceAssoc> clientAgenceAssocsById) {
        this.clientAgenceAssocsById = clientAgenceAssocsById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agence agence = (Agence) o;

        if (id != agence.id) return false;
        if (telephone != agence.telephone) return false;
        if (nom != null ? !nom.equals(agence.nom) : agence.nom != null) return false;
        if (email != null ? !email.equals(agence.email) : agence.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + telephone;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
