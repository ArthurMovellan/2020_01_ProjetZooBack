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

import fr.adaming.model.Tache;
import fr.adaming.services.ITacheService;

@RestController
@RequestMapping("tache")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheController {

	@Autowired
	ITacheService tacheServ;

	@PostMapping()
	public boolean addTache(@RequestBody Tache tache) {
		try {
			tacheServ.saveTache(tache);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updateTache(@RequestBody Tache tache, @PathVariable long id) {
		try {
			tache.setId(id);
			tacheServ.saveTache(tache);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Tache getTacheById(@PathVariable long id) {
		return tacheServ.getTacheById(id);
	}

	@GetMapping()
	public List<Tache> getAllTache() {
		return tacheServ.getAllTache();
	}

	@DeleteMapping("/{id}")
	public boolean deleteTache(@PathVariable long id) {
		try {
			tacheServ.delTache(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/zone/{nomZ}")
	public List<Tache> getAllTacheByZone(@PathVariable String nomZ) {
		return tacheServ.getAllTacheByZone(nomZ);
	}

	@GetMapping("/personne/{idP}")
	public List<Tache> getAllTacheByPersonne(@PathVariable long idP) {
		return tacheServ.getAllTacheByPersonne(idP);
	}

	@PutMapping("/id:{idT}/etat:{idE}")
	public boolean affecterEtatTache(@PathVariable long idT, @PathVariable long idE) {
		try {
			tacheServ.affecterEtatTache(idT, idE);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("/etat/{idE}")
	public List<Tache> getAllTacheByEtat(@PathVariable long idE){
		return tacheServ.getAllTacheByEtat(idE);
	}
	
	@GetMapping("/personne/{idP}/etat/{idE}")
	public List<Tache> getAllTacheByPersonneByEtat(@PathVariable long idP, @PathVariable long idE){
		return tacheServ.getAllTacheByPersonneByEtat(idP, idE);
	}
}
