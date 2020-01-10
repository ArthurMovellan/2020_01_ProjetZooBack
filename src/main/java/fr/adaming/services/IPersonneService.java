package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Personne;

public interface IPersonneService {

	public void savePersonne(Personne personne);

	public void updatePersonne(Personne personne);

	public Personne getPersonneById(long id);

	public List<Personne> getAllPersonne();

	public void delPersonne(long id);
	
	public Personne findByLoginAndMdp(String login, String mdp);
	
	public Personne getPersonneByLogin(String login);
	
	public List<Personne> getAllPersonneByZone(String nomZ);
}
