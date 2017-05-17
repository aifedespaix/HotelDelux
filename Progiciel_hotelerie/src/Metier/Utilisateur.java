package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private Collection<DemandeUtilisateur> demandeUtilisateursById;
    private Role roleByIdRole;

    
    public Utilisateur(int id, String nom, String prenom, String login, String password,
			Collection<DemandeUtilisateur> demandeUtilisateursById, Role roleByIdRole) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.demandeUtilisateursById = demandeUtilisateursById;
		this.roleByIdRole = roleByIdRole;
	}

	public Utilisateur(String nom, String prenom, String login, String password,
			Collection<DemandeUtilisateur> demandeUtilisateursById, Role roleByIdRole) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.demandeUtilisateursById = demandeUtilisateursById;
		this.roleByIdRole = roleByIdRole;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password="
				+ password + ", demandeUtilisateursById=" + demandeUtilisateursById + ", roleByIdRole=" + roleByIdRole
				+ "]";
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
    @Column(name = "login", nullable = false, length = 250)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 250)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @OneToMany(mappedBy = "utilisateurByIdUtilisateur")
    public Collection<DemandeUtilisateur> getDemandeUtilisateursById() {
        return demandeUtilisateursById;
    }

    public void setDemandeUtilisateursById(Collection<DemandeUtilisateur> demandeUtilisateursById) {
        this.demandeUtilisateursById = demandeUtilisateursById;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    public Role getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(Role roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }
}
