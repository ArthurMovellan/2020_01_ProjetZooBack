package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Tache;

public interface ITacheService {

	public void saveTache(Tache tache);

	public void updateTache(Tache tache);

	public Tache getTacheById(long id);

	public List<Tache> getAllTache();

	public void delTache(long id);
	
	public List<Tache> getAllTacheByZone(String nomZ);
	
	public List<Tache> getAllTacheByPersonne(long idP);
	
	public List<Tache> getAllTacheByEtat(long idE);
	
	public void affecterEtatTache(long idT, long idE);
	
	public List<Tache> getAllTacheByPersonneByEtat(long idP, long idE);
}
