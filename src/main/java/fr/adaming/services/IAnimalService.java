package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Animal;

public interface IAnimalService {

	public void saveAnimal(Animal animal);
	
	public void updateAnimal(Animal animal);
	
	public Animal getAnimalById(long id);
	
	public List<Animal> getAllAnimal();
	
	public void delAnimal(long id);
	
	public List<Animal> getAllAnimalByZone(String nomZ);
	
	public void affecterNbAnimalAnimal(long idA, int nbAnimal);
}
