package src.Metier;

import javax.persistence.*;

import src.Metier.RoleEntity;

import java.util.Collection;

/**
 * Created by ledze on 12/05/2017.
 */
@Entity
@Table(name = "utilisateur", schema = "base_definitive", catalog = "")
public class UtilisateurEntity {
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private int idRole;
    private Collection<DemandeUtilisateurEntity> demandeUtilisateursById;
    private RoleEntity roleByIdRole;

    
    
    public UtilisateurEntity(String nom, String prenom, String login, String password, int idRole,
			Collection<DemandeUtilisateurEntity> demandeUtilisateursById, Metier.RoleEntity roleByIdRole) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.idRole = idRole;
		this.demandeUtilisateursById = demandeUtilisateursById;
		this.roleByIdRole = roleByIdRole;
	}

	public UtilisateurEntity(String nom, String prenom, String login, String password, int idRole,
			Collection<DemandeUtilisateurEntity> demandeUtilisateursById, Metier.RoleEntity roleByIdRole) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.idRole = idRole;
		this.demandeUtilisateursById = demandeUtilisateursById;
		this.roleByIdRole = roleByIdRole;
	}

	public UtilisateurEntity() {
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

    @Basic
    @Column(name = "id_role", nullable = false)
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

 
    @OneToMany(mappedBy = "utilisateurByIdUtilisateur")
    public Collection<DemandeUtilisateurEntity> getDemandeUtilisateursById() {
        return demandeUtilisateursById;
    }

    public void setDemandeUtilisateursById(Collection<DemandeUtilisateurEntity> demandeUtilisateursById) {
        this.demandeUtilisateursById = demandeUtilisateursById;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    public RoleEntity getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(RoleEntity roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }

	@Override
	public String toString() {
		return "UtilisateurEntity [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login
				+ ", password=" + password + ", idRole=" + idRole + ", demandeUtilisateursById="
				+ demandeUtilisateursById + ", roleByIdRole=" + roleByIdRole + "]";
	}
    
    
}
