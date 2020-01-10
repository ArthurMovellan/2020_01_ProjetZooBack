package fr.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Personne;
import fr.adaming.model.Zone;

public interface IPersonneRepository extends JpaRepository<Personne, Long>{

	public Personne findByLoginAndMdp(String login, String mdp);
	
	public Personne getPersonneByLogin(String login);
	
	public List<Personne> getAllPersonneByZone(Zone zone);
}
