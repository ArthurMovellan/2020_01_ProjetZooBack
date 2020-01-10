package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_personne")
public class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	private String login;
	private String mdp;
	private Role role;
	private Zone zone;
	
	//Consturcteurs
	public Personne(String nom, String login, String mdp, Role role, Zone zone) {
		super();
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
		this.role = role;
		this.zone = zone;
	}

	public Personne() {
		super();
	}

	//getters and setters
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	
	@ManyToOne
	@JoinColumn(name="id_role")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name="id_zone")
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", login=" + login + ", mdp=" + mdp + ", role=" + role
				+ ", zone=" + zone + "]";
	}

	
	
	
}
