package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_role")
public class Role implements Serializable{

	//Attributs
	private static final long serialVersionUID = 1L;
	private long id;
	private String libelle;

	
	//constructeurs
	public Role(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Role() {
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

	@Override
	public String toString() {
		return "Role [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
