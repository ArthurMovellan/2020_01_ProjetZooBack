package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_tache")
public class Tache implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String libelle;
	private Date dateDebut;
	private Date dateFin;
	private Personne personne;
	private Personne createur;
	private Etat etat;
	
	//Constructeurs	
	public Tache() {
		super();
	}

	public Tache(String libelle, Date dateDebut, Date dateFin, Personne personne, Personne createur, Etat etat) {
		super();
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.personne = personne;
		this.createur = createur;
		this.etat = etat;
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
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Temporal(TemporalType.TIMESTAMP)	
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.TIMESTAMP)	
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@ManyToOne
	@JoinColumn(name="id_personne")
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	@ManyToOne
	@JoinColumn(name="id_createur")
	public Personne getCreateur() {
		return createur;
	}
	public void setCreateur(Personne createur) {
		this.createur = createur;
	}
	
	@ManyToOne
	@JoinColumn(name="id_etat")
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	//toString
	@Override
	public String toString() {
		return "Tache [id=" + id + ", libelle=" + libelle + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", personne=" + personne + ", createur=" + createur + ", etat=" + etat + "]";
	}

}
