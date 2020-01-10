package fr.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Enclos;
import fr.adaming.model.Zone;

public interface IEnclosRepository extends JpaRepository<Enclos, Long>{

	public List<Enclos> getAllEnclosByZone(Zone zone);
}
