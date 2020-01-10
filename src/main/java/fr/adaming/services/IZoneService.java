package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Zone;

public interface IZoneService {

	public void saveZone(Zone zone);

	public void updateZone(Zone zone);

	public Zone getZoneById(long id);

	public List<Zone> getAllZone();

	public void delZone(long id);
	
	public Zone getZoneByNom(String nom);
}
