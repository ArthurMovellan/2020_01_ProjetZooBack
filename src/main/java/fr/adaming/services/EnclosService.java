package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Enclos;
import fr.adaming.model.Zone;
import fr.adaming.repositories.IEnclosRepository;
import fr.adaming.repositories.IZoneRepository;

@Service
public class EnclosService implements IEnclosService{

	@Autowired
	IEnclosRepository enclosRepo;
	
	@Autowired
	IZoneRepository zoneRepo;
	
	@Override
	public void saveEnclos(Enclos enclos) {
		enclosRepo.save(enclos);
	}

	@Override
	public void updateEnclos(Enclos enclos) {
		enclosRepo.save(enclos);
	}

	@Override
	public Enclos getEnclosById(long id) {
		return enclosRepo.findById(id).get();
	}

	@Override
	public List<Enclos> getAllEnclos() {
		return enclosRepo.findAll();
	}

	@Override
	public void delEnclos(long id) {
		enclosRepo.deleteById(id);
	}

	@Override
	public List<Enclos> getAllEnclosByZone(String nomZ) {
		Zone z = zoneRepo.findByNom(nomZ);
		return enclosRepo.getAllEnclosByZone(z);
	}

	@Override
	public void affecterNbAnimalEnclos(long idE, int nbAnimal) {
		Enclos e = enclosRepo.findById(idE).get();
		e.setNbAnimal(nbAnimal);
		enclosRepo.save(e);
	}

}
