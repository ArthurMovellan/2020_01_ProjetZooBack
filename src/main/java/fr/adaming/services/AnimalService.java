package fr.adaming.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Animal;
import fr.adaming.model.Enclos;
import fr.adaming.model.Zone;
import fr.adaming.repositories.IAnimalRepository;
import fr.adaming.repositories.IEnclosRepository;
import fr.adaming.repositories.IZoneRepository;

@Service
public class AnimalService implements IAnimalService{

	@Autowired
	IAnimalRepository animalRepo;
	
	@Autowired
	IZoneRepository zoneRepo;
	
	@Autowired
	IEnclosRepository enclosRepo;
	
	@Override
	public void saveAnimal(Animal animal) {
		animalRepo.save(animal);
	}

	@Override
	public void updateAnimal(Animal animal) {
		animalRepo.save(animal);
	}

	@Override
	public Animal getAnimalById(long id) {
		return animalRepo.findById(id).get();
	}

	@Override
	public List<Animal> getAllAnimal() {
		return animalRepo.findAll();
	}

	@Override
	public void delAnimal(long id) {
		animalRepo.deleteById(id);
	}
	
	@Override
	public List<Animal> getAllAnimalByZone(String nomZ) {
		Zone z = zoneRepo.findByNom(nomZ);
		List<Enclos> listEnclos = enclosRepo.getAllEnclosByZone(z);
		List<Animal> listAnimal = new ArrayList<Animal>();
		for (Enclos e : listEnclos) {
			listAnimal.addAll(animalRepo.getAllAnimalByEnclos(e));
		}
		return listAnimal;
	}

	@Override
	public void affecterNbAnimalAnimal(long idA, int nbAnimal) {
		Animal animal = animalRepo.findById(idA).get();
		animal.setNbAnimal(nbAnimal);
		animalRepo.save(animal);
	}

}
