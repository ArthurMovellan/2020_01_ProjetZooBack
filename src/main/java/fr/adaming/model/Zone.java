package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_zone")
public class Zone implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	
	//Constructeurs
	public Zone(String nom) {
		super();
		this.nom = nom;
	}
	
	public Zone() {
		super();
	}

	//Getters and setters
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
	
	//tostring
	@Override
	public String toString() {
		return "Zone [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
