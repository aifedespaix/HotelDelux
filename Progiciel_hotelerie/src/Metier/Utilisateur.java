package Metier;

//import org.hibernate.annotations.Columns;
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

import javax.persistence.*;
@Entity
@Table (name="utilisateur")

public class Utilisateur {

	@Id
	@Column (name="id")
	private int idUtilisateur;
	
	@Column (name="login")
	private String login;
	
	@Column (name="mdp")
	private String mdp;
	
	
	public Utilisateur(int idUtilisateur, String login, String mdp) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	
	public Utilisateur(){
		super();
	}
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", mdp=" + mdp + "]";
	}	
	
}
