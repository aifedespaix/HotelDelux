package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Role {
    private int id;
    private String libelle;
    private Collection<DroitRoleAssoc> droitRoleAssocsById;
    private Collection<Utilisateur> utilisateursById;

    public Role(int id, String libelle, Collection<DroitRoleAssoc> droitRoleAssocsById,
			Collection<Utilisateur> utilisateursById) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.droitRoleAssocsById = droitRoleAssocsById;
		this.utilisateursById = utilisateursById;
	}

	public Role(String libelle, Collection<DroitRoleAssoc> droitRoleAssocsById,
			Collection<Utilisateur> utilisateursById) {
		super();
		this.libelle = libelle;
		this.droitRoleAssocsById = droitRoleAssocsById;
		this.utilisateursById = utilisateursById;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return libelle;
	}

	public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "libelle", nullable = false, length = 250)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<DroitRoleAssoc> getDroitRoleAssocsById() {
        return droitRoleAssocsById;
    }

    public void setDroitRoleAssocsById(Collection<DroitRoleAssoc> droitRoleAssocsById) {
        this.droitRoleAssocsById = droitRoleAssocsById;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<Utilisateur> getUtilisateursById() {
        return utilisateursById;
    }

    public void setUtilisateursById(Collection<Utilisateur> utilisateursById) {
        this.utilisateursById = utilisateursById;
    }
}
