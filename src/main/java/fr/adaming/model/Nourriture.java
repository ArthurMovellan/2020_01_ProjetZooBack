package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_nourriture")
public class Nourriture implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	private int stock;
	
	//COnstructeurs
	public Nourriture(String nom, int stock) {
		super();
		this.nom = nom;
		this.stock = stock;
	}
	
	public Nourriture() {
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Nourriture [id=" + id + ", nom=" + nom + ", stock=" + stock + "]";
	}
	
	

}
