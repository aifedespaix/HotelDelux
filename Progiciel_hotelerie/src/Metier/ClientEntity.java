package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "client", schema = "base_definitive", catalog = "")
public class ClientEntity {
    private int id;
    private String nom;
    private String prenom;
    private String adresseRue;
    private String adresseVille;
    private int codePostal;
    private int telephone;
    private String allergies;
    private Collection<ClientAgenceAssocEntity> clientAgenceAssocsById;
    private Collection<FacturationAssocEntity> facturationAssocsById;

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
    @Column(name = "prenom", nullable = false, length = 250)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "adresse_rue", nullable = false, length = 250)
    public String getAdresseRue() {
        return adresseRue;
    }

    public void setAdresseRue(String adresseRue) {
        this.adresseRue = adresseRue;
    }

    @Basic
    @Column(name = "adresse_ville", nullable = false, length = 250)
    public String getAdresseVille() {
        return adresseVille;
    }

    public void setAdresseVille(String adresseVille) {
        this.adresseVille = adresseVille;
    }

    @Basic
    @Column(name = "code_postal", nullable = false)
    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
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
    @Column(name = "allergies", nullable = false, length = 250)
    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id != that.id) return false;
        if (codePostal != that.codePostal) return false;
        if (telephone != that.telephone) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (adresseRue != null ? !adresseRue.equals(that.adresseRue) : that.adresseRue != null) return false;
        if (adresseVille != null ? !adresseVille.equals(that.adresseVille) : that.adresseVille != null) return false;
        if (allergies != null ? !allergies.equals(that.allergies) : that.allergies != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (adresseRue != null ? adresseRue.hashCode() : 0);
        result = 31 * result + (adresseVille != null ? adresseVille.hashCode() : 0);
        result = 31 * result + codePostal;
        result = 31 * result + telephone;
        result = 31 * result + (allergies != null ? allergies.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByIdClient")
    public Collection<ClientAgenceAssocEntity> getClientAgenceAssocsById() {
        return clientAgenceAssocsById;
    }

    public void setClientAgenceAssocsById(Collection<ClientAgenceAssocEntity> clientAgenceAssocsById) {
        this.clientAgenceAssocsById = clientAgenceAssocsById;
    }

    @OneToMany(mappedBy = "clientByIdClient")
    public Collection<FacturationAssocEntity> getFacturationAssocsById() {
        return facturationAssocsById;
    }

    public void setFacturationAssocsById(Collection<FacturationAssocEntity> facturationAssocsById) {
        this.facturationAssocsById = facturationAssocsById;
    }
}
