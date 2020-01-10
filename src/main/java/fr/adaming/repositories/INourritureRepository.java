package fr.adaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Nourriture;

public interface INourritureRepository extends JpaRepository<Nourriture, Long>{

}
