package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_etat")
public class Etat implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String libelle;
	
	//Constrcuteurs
	public Etat(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public Etat() {
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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	//tostringg
	@Override
	public String toString() {
		return "Etat [id=" + id + ", libelle=" + libelle + "]";
	}
	
	

}
