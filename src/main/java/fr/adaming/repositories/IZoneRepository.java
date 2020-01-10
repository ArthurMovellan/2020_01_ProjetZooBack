package fr.adaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Zone;

public interface IZoneRepository extends JpaRepository<Zone, Long>{

	public Zone findByNom(String nom);
}
