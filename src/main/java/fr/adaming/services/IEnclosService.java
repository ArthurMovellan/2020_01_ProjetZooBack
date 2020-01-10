package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Enclos;

public interface IEnclosService {

	public void saveEnclos(Enclos enclos);

	public void updateEnclos(Enclos enclos);

	public Enclos getEnclosById(long id);

	public List<Enclos> getAllEnclos();

	public void delEnclos(long id);
	
	public List<Enclos> getAllEnclosByZone(String nomZ);
	
	public void affecterNbAnimalEnclos(long idE, int nbAnimal);
}
