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

import fr.adaming.model.Zone;
import fr.adaming.services.IZoneService;

@RestController
@RequestMapping("zone")
@CrossOrigin(origins = "http://localhost:4200")
public class ZoneController {

	@Autowired
	IZoneService zoneServ;

	@PostMapping()
	public boolean addZone(@RequestBody Zone zone) {
		try {
			zoneServ.saveZone(zone);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updateZone(@RequestBody Zone zone, @PathVariable long id) {
		try {
			zone.setId(id);
			zoneServ.saveZone(zone);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Zone getZoneById(@PathVariable long id) {
		return zoneServ.getZoneById(id);
	}

	@GetMapping()
	public List<Zone> getAllZone() {
		return zoneServ.getAllZone();
	}

	@DeleteMapping("/{id}")
	public boolean deleteZone(@PathVariable long id) {
		try {
			zoneServ.delZone(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("/nom{nom}")
	public Zone getZoneByNom(@PathVariable String nom) {
		return zoneServ.getZoneByNom(nom);
	}
}
