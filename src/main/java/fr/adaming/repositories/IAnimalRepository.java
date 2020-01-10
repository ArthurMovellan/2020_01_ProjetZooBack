package fr.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Animal;
import fr.adaming.model.Enclos;

public interface IAnimalRepository extends JpaRepository<Animal, Long>{

	public List<Animal> getAllAnimalByEnclos(Enclos enclos);
}
