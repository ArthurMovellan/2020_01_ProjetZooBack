package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Zone;
import fr.adaming.repositories.IZoneRepository;

@Service
public class ZoneService implements IZoneService{

	@Autowired
	IZoneRepository zoneRepo;
	
	@Override
	public void saveZone(Zone zone) {
		zoneRepo.save(zone);
	}

	@Override
	public void updateZone(Zone zone) {
		zoneRepo.save(zone);
	}

	@Override
	public Zone getZoneById(long id) {
		return zoneRepo.findById(id).get();
	}

	@Override
	public List<Zone> getAllZone() {
		return zoneRepo.findAll();
	}

	@Override
	public void delZone(long id) {
		zoneRepo.deleteById(id);
	}

	@Override
	public Zone getZoneByNom(String nom) {
		return zoneRepo.findByNom(nom);
	}

}
