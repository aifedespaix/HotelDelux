package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "agence", schema = "base_definitive", catalog = "")
public class AgenceEntity {
    private int id;
    private String nom;
    private int telephone;
    private String email;
    private Collection<ClientAgenceAssocEntity> clientAgenceAssocsById;

    public AgenceEntity(int id, String nom, int telephone, String email,
			Collection<ClientAgenceAssocEntity> clientAgenceAssocsById) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.clientAgenceAssocsById = clientAgenceAssocsById;
	}
    
    

	public AgenceEntity(String nom, int telephone, String email,
			Collection<ClientAgenceAssocEntity> clientAgenceAssocsById) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.clientAgenceAssocsById = clientAgenceAssocsById;
	}



	public AgenceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AgenceEntity [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", email=" + email
				+ ", clientAgenceAssocsById=" + clientAgenceAssocsById + "]";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgenceEntity that = (AgenceEntity) o;

        if (id != that.id) return false;
        if (telephone != that.telephone) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

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

    @OneToMany(mappedBy = "agenceByIdAgence")
    public Collection<ClientAgenceAssocEntity> getClientAgenceAssocsById() {
        return clientAgenceAssocsById;
    }

    public void setClientAgenceAssocsById(Collection<ClientAgenceAssocEntity> clientAgenceAssocsById) {
        this.clientAgenceAssocsById = clientAgenceAssocsById;
    }
}
