package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Etat;
import fr.adaming.repositories.IEtatRepository;

@Service
public class EtatService implements IEtatService{

	@Autowired
	IEtatRepository etatRepo;
	
	@Override
	public void saveEtat(Etat etat) {
		etatRepo.save(etat);
	}

	@Override
	public void updateEtat(Etat etat) {
		etatRepo.save(etat);
	}

	@Override
	public Etat getEtatById(long id) {
		return etatRepo.findById(id).get();
	}

	@Override
	public List<Etat> getAllEtat() {
		return etatRepo.findAll();
	}

	@Override
	public void delEtat(long id) {
		etatRepo.deleteById(id);
	}

}
