package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Role;
import fr.adaming.repositories.IRoleRepository;

@Service
public class RoleService implements IRoleService{

	@Autowired
	IRoleRepository roleRepo;
	
	@Override
	public void saveRole(Role role) {
		roleRepo.save(role);
	}

	@Override
	public void updateRole(Role role) {
		roleRepo.save(role);
	}

	@Override
	public Role getRoleById(long id) {
		return roleRepo.findById(id).get();
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepo.findAll();
	}

	@Override
	public void delRole(long id) {
		roleRepo.deleteById(id);
	}

	
	
}
