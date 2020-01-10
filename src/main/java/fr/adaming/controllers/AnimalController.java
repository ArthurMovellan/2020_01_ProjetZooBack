package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Animal;
import fr.adaming.services.IAnimalService;

@RestController
@RequestMapping("animal")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalController {

	@Autowired
	IAnimalService animalServ;

	@PostMapping()
	public boolean addAnimal(@RequestBody Animal animal) {
		try {
			animalServ.saveAnimal(animal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updateAnimal(@RequestBody Animal animal, @PathVariable long id) {
		try {
			animal.setId(id);
			animalServ.saveAnimal(animal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Animal getAnimalById(@PathVariable long id) {
		return animalServ.getAnimalById(id);
	}

	@GetMapping()
	public List<Animal> getAllAnimal() {
		return animalServ.getAllAnimal();
	}

	@DeleteMapping("/{id}")
	public boolean deleteAnimal(@PathVariable long id) {
		try {
			animalServ.delAnimal(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/zone/{nomZ}")
	public List<Animal> getAllAnimalByZone(@PathVariable String nomZ) {
		return animalServ.getAllAnimalByZone(nomZ);
	}

	@PutMapping("/id:{id}/nbAnimal:{nbAnimal}")
	public boolean affecterNbAnimalAnimal(@PathVariable long id, @PathVariable int nbAnimal) {
		try {
			animalServ.affecterNbAnimalAnimal(id, nbAnimal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
