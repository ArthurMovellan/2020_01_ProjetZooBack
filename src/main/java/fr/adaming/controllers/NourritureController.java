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

import fr.adaming.model.Nourriture;
import fr.adaming.services.INourritureService;

@RestController
@RequestMapping("nourriture")
@CrossOrigin(origins = "http://localhost:4200")
public class NourritureController {

	@Autowired
	INourritureService nourritureServ;

	@PostMapping()
	public boolean addNourriture(@RequestBody Nourriture nourriture) {
		try {
			nourritureServ.saveNourriture(nourriture);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updateNourriture(@RequestBody Nourriture nourriture, @PathVariable long id) {
		try {
			nourriture.setId(id);
			nourritureServ.saveNourriture(nourriture);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Nourriture getNourritureById(@PathVariable long id) {
		return nourritureServ.getNourritureById(id);
	}

	@GetMapping()
	public List<Nourriture> getAllNourriture() {
		return nourritureServ.getAllNourriture();
	}

	@DeleteMapping("/{id}")
	public boolean deleteNourriture(@PathVariable long id) {
		try {
			nourritureServ.delNourriture(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("/id:{id}/stock:{stock}")
	public boolean affecterStockNourriture(@PathVariable long id, @PathVariable int stock) {
		try {
			nourritureServ.affecterStockNourriture(id, stock);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
