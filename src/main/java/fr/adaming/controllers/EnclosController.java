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

import fr.adaming.model.Enclos;
import fr.adaming.services.IEnclosService;

@RestController
@RequestMapping("enclos")
@CrossOrigin(origins = "http://localhost:4200")
public class EnclosController {

	@Autowired
	IEnclosService enclosServ;

	@PostMapping()
	public boolean addEnclos(@RequestBody Enclos enclos) {
		try {
			enclosServ.saveEnclos(enclos);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updateEnclos(@RequestBody Enclos enclos, @PathVariable long id) {
		try {
			enclos.setId(id);
			enclosServ.saveEnclos(enclos);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Enclos getEnclosById(@PathVariable long id) {
		return enclosServ.getEnclosById(id);
	}

	@GetMapping()
	public List<Enclos> getAllEnclos() {
		return enclosServ.getAllEnclos();
	}

	@DeleteMapping("/{id}")
	public boolean deleteEnclos(@PathVariable long id) {
		try {
			enclosServ.delEnclos(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/zone/{nomZ}")
	public List<Enclos> getAllEnclosByZone(@PathVariable String nomZ) {
		return enclosServ.getAllEnclosByZone(nomZ);
	}

	@PutMapping("/id:{id}/nbAnimal:{nbAnimal}")
	public int affecterNbAnimalEnclos(@PathVariable long id, @PathVariable int nbAnimal) {
		try {
			Enclos e = enclosServ.getEnclosById(id);
			if(e.getCapacite()<nbAnimal) {
				return 1;
			}else {
				enclosServ.affecterNbAnimalEnclos(id, nbAnimal);
				return 2;
			}
		}catch(Exception e) {
			return 0;
		}
	}
}
