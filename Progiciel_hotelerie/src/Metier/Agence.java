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

    public Agence(int id, String nom, int telephone, String email,
			Collection<ClientAgenceAssoc> clientAgenceAssocsById) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.clientAgenceAssocsById = clientAgenceAssocsById;
	}

	public Agence(String nom, int telephone, String email, Collection<ClientAgenceAssoc> clientAgenceAssocsById) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.clientAgenceAssocsById = clientAgenceAssocsById;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", email=" + email
				+ ", clientAgenceAssocsById=" + clientAgenceAssocsById + "]";
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

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
}
