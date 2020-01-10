package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Nourriture;

public interface INourritureService {

	public void saveNourriture(Nourriture nourriture);

	public void updateNourriture(Nourriture nourriture);

	public Nourriture getNourritureById(long id);

	public List<Nourriture> getAllNourriture();

	public void delNourriture(long id);
	
	public void affecterStockNourriture(long idN, int stock);
}
