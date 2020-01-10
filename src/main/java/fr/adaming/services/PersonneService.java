package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Personne;
import fr.adaming.model.Zone;
import fr.adaming.repositories.IPersonneRepository;
import fr.adaming.repositories.IZoneRepository;

@Service
public class PersonneService implements IPersonneService{

	@Autowired
	IPersonneRepository personneRepo;
	
	@Autowired
	IZoneRepository zoneRepo;
	
	@Override
	public void savePersonne(Personne personne) {
		personneRepo.save(personne);
	}

	@Override
	public void updatePersonne(Personne personne) {
		personneRepo.save(personne);
	}

	@Override
	public Personne getPersonneById(long id) {
		return personneRepo.findById(id).get();
	}

	@Override
	public List<Personne> getAllPersonne() {
		return personneRepo.findAll();
	}

	@Override
	public void delPersonne(long id) {
		personneRepo.deleteById(id);
	}

	@Override
	public Personne findByLoginAndMdp(String login, String mdp) {
		Personne personne = personneRepo.findByLoginAndMdp(login, mdp);
		if (personne!= null) {
			personne.setMdp("");
			return personne;
		}else {
			return new Personne();
		}
	}

	@Override
	public Personne getPersonneByLogin(String login) {
		Personne personne = personneRepo.getPersonneByLogin(login);
		if (personne!= null) {
			personne.setMdp("");
			return personne;
		}else {
			return null;
		}
	}

	@Override
	public List<Personne> getAllPersonneByZone(String nomZ) {
		Zone z = zoneRepo.findByNom(nomZ);
		return personneRepo.getAllPersonneByZone(z);
	}

}
