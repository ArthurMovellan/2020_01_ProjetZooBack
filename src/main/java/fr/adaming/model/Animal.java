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
@Table(name="tb_animal")
public class Animal implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String espece;
	private Enclos enclos;
	private Nourriture nourriture;
	private int nbAnimal;
	
	//Constrcuteurs

	public Animal() {
		super();
	}

	public Animal(String espece, Enclos enclos, Nourriture nourriture, int nbAnimal) {
		super();
		this.espece = espece;
		this.enclos = enclos;
		this.nourriture = nourriture;
		this.nbAnimal = nbAnimal;
	}

	//getters and settrers
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	
	@ManyToOne
	@JoinColumn(name="id_enclos")
	public Enclos getEnclos() {
		return enclos;
	}
	public void setEnclos(Enclos enclos) {
		this.enclos = enclos;
	}
	
	@ManyToOne
	@JoinColumn(name="id_nourriture")
	public Nourriture getNourriture() {
		return nourriture;
	}
	
	public void setNourriture(Nourriture nourriture) {
		this.nourriture = nourriture;
	}
	
	public int getNbAnimal() {
		return nbAnimal;
	}

	public void setNbAnimal(int nbAnimal) {
		this.nbAnimal = nbAnimal;
	}

	//tostring
	@Override
	public String toString() {
		return "Animal [id=" + id + ", espece=" + espece + ", enclos=" + enclos + ", nourriture=" + nourriture
				+ ", nbAnimal=" + nbAnimal + "]";
	}

	

	
	
}
