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

import fr.adaming.model.Etat;
import fr.adaming.services.IEtatService;

@RestController
@RequestMapping("etat")
@CrossOrigin(origins = "http://localhost:4200")
public class EtatController {

	@Autowired
	IEtatService etatServ;

	@PostMapping()
	public boolean addEtat(@RequestBody Etat etat) {
		try {
			etatServ.saveEtat(etat);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updateEtat(@RequestBody Etat etat, @PathVariable long id) {
		try {
			etat.setId(id);
			etatServ.saveEtat(etat);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Etat getEtatById(@PathVariable long id) {
		return etatServ.getEtatById(id);
	}

	@GetMapping()
	public List<Etat> getAllEtat() {
		return etatServ.getAllEtat();
	}

	@DeleteMapping("/{id}")
	public boolean deleteEtat(@PathVariable long id) {
		try {
			etatServ.delEtat(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
