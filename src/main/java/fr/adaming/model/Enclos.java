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
@Table(name="tb_enclos")
public class Enclos implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	private int capacite;
	private int nbAnimal;
	private Zone zone;
	
	//Constructeurs
	public Enclos(String nom, int capacite, int nbAnimal, Zone zone) {
		super();
		this.nom = nom;
		this.capacite = capacite;
		this.nbAnimal = nbAnimal;
		this.zone = zone;
	}

	public Enclos() {
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

	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public int getNbAnimal() {
		return nbAnimal;
	}

	public void setNbAnimal(int nbAnimal) {
		this.nbAnimal = nbAnimal;
	}

	@ManyToOne
	@JoinColumn(name="id_zone")
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

	//toString
	@Override
	public String toString() {
		return "Enclos [id=" + id + ", nom=" + nom + ", capacite=" + capacite + ", nbAnimal=" + nbAnimal + ", zone="
				+ zone + "]";
	}
	
	
	
	
	
}
