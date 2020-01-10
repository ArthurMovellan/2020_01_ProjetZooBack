package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Personne;
import fr.adaming.model.Token;
import fr.adaming.services.IPersonneService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@RestController
@RequestMapping("personne")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneController {
	
	Key cle = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	@Autowired
	IPersonneService personneServ;

	@PostMapping()
	public boolean addPersonne(@RequestBody Personne personne) {
		try {
			personneServ.savePersonne(personne);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updatePersonne(@RequestBody Personne personne, @PathVariable long id) {
		try {
			personne.setId(id);
			personneServ.savePersonne(personne);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Personne getPersonneById(@PathVariable long id) {
		return personneServ.getPersonneById(id);
	}

	@GetMapping()
	public List<Personne> getAllPersonne() {
		return personneServ.getAllPersonne();
	}

	@DeleteMapping("/{id}")
	public boolean deletePersonne(@PathVariable long id) {
		try {
			personneServ.delPersonne(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("/login")
	public Token findByLoginAndMdp(@RequestBody Personne personne) {
		Personne p = personneServ.findByLoginAndMdp(personne.getLogin(), personne.getMdp());
		if (p.getId()!=0) {
			p.setMdp("");
			String tok = Jwts.builder()
					.setSubject("id : " + p.getId() + ", login : " + p.getLogin() + ", nom : " + p.getNom() + ", role : " + p.getRole().getLibelle() + ", zone : " + p.getZone().getNom()) //mettre le contenu
					.signWith(cle)//mettre la clé pour le decodage
					.compact();//fermer le token pour le construire
			Token token = new Token();
			token.setToken(tok);
			return token;
		}
		return null;
	}
	
	@GetMapping("/login/{login}")
	public Personne getPersonneByLogin(@PathVariable String login) {
		return personneServ.getPersonneByLogin(login);
	}
	
	@GetMapping("/zone/{nomZ}")
	public List<Personne> getAllPersonneByZone(@PathVariable String nomZ){
		return personneServ.getAllPersonneByZone(nomZ);
	}
}
