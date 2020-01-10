package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Nourriture;
import fr.adaming.repositories.INourritureRepository;

@Service
public class NourritureService implements INourritureService{

	@Autowired
	INourritureRepository nourritureRepo;
	
	@Override
	public void saveNourriture(Nourriture nourriture) {
		nourritureRepo.save(nourriture);
	}

	@Override
	public void updateNourriture(Nourriture nourriture) {
		nourritureRepo.save(nourriture);
	}

	@Override
	public Nourriture getNourritureById(long id) {
		return nourritureRepo.findById(id).get();
	}

	@Override
	public List<Nourriture> getAllNourriture() {
		return nourritureRepo.findAll();
	}

	@Override
	public void delNourriture(long id) {
		nourritureRepo.deleteById(id);
	}

	@Override
	public void affecterStockNourriture(long idN, int stock) {
		Nourriture nour = nourritureRepo.findById(idN).get();
		nour.setStock(stock);
		nourritureRepo.save(nour);
	}
	
	

	
}
