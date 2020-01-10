package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Etat;

public interface IEtatService {

	public void saveEtat(Etat etat);

	public void updateEtat(Etat etat);

	public Etat getEtatById(long id);

	public List<Etat> getAllEtat();

	public void delEtat(long id);
}
