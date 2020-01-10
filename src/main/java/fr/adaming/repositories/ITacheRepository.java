package fr.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Etat;
import fr.adaming.model.Personne;
import fr.adaming.model.Tache;

public interface ITacheRepository extends JpaRepository<Tache, Long>{

	public List<Tache> getAllTacheByPersonne(Personne personne);
	
	public List<Tache> getAllTacheByEtat(Etat etat);
	
}
