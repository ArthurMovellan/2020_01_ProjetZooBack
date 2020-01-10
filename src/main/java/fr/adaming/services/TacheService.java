package fr.adaming.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Etat;
import fr.adaming.model.Personne;
import fr.adaming.model.Tache;
import fr.adaming.model.Zone;
import fr.adaming.repositories.IEtatRepository;
import fr.adaming.repositories.IPersonneRepository;
import fr.adaming.repositories.ITacheRepository;
import fr.adaming.repositories.IZoneRepository;

@Service
public class TacheService implements ITacheService{

	@Autowired
	ITacheRepository tacheRepo;
	
	@Autowired
	IZoneRepository zoneRepo;
	
	@Autowired
	IPersonneRepository personneRepo;
	
	@Autowired
	IEtatRepository etatRepo;
	
	@Override
	public void saveTache(Tache tache) {
		tacheRepo.save(tache);
	}

	@Override
	public void updateTache(Tache tache) {
		tacheRepo.save(tache);
	}

	@Override
	public Tache getTacheById(long id) {
		return tacheRepo.findById(id).get();
	}

	@Override
	public List<Tache> getAllTache() {
		return tacheRepo.findAll();
	}

	@Override
	public void delTache(long id) {
		tacheRepo.deleteById(id);
	}

	@Override
	public List<Tache> getAllTacheByZone(String nomZ) {
		Zone z = zoneRepo.findByNom(nomZ);
		List<Personne> listPersonne = personneRepo.getAllPersonneByZone(z);
		List<Tache> listTache = new ArrayList<Tache>();
		for (Personne p : listPersonne) {
			listTache.addAll(tacheRepo.getAllTacheByPersonne(p));
		}
		return listTache;
	}

	@Override
	public List<Tache> getAllTacheByPersonne(long idP) {
		Personne p = personneRepo.findById(idP).get();
		return tacheRepo.getAllTacheByPersonne(p);
	}

	@Override
	public void affecterEtatTache(long idT, long idE) {
		Tache t = tacheRepo.findById(idT).get();
		Etat e = etatRepo.findById(idE).get();
		t.setEtat(e);
		tacheRepo.save(t);
	}

	@Override
	public List<Tache> getAllTacheByEtat(long idE) {
		Etat e = etatRepo.findById(idE).get();
		return tacheRepo.getAllTacheByEtat(e);
	}

	@Override
	public List<Tache> getAllTacheByPersonneByEtat(long idP, long idE) {
		Personne p = personneRepo.findById(idP).get();
		Etat e = etatRepo.findById(idE).get();
		List<Tache> listPers = tacheRepo.getAllTacheByPersonne(p);
		List<Tache> listEtat = tacheRepo.getAllTacheByEtat(e);
		listPers.retainAll(listEtat);
		return listPers;
	}
	

}
