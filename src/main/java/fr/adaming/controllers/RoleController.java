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

import fr.adaming.model.Role;
import fr.adaming.services.IRoleService;

@RestController
@RequestMapping("role")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {

	@Autowired
	IRoleService roleServ;

	@PostMapping()
	public boolean addRole(@RequestBody Role role) {
		try {
			roleServ.saveRole(role);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	public boolean updateRole(@RequestBody Role role, @PathVariable long id) {
		try {
			role.setId(id);
			roleServ.saveRole(role);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/{id}")
	public Role getRoleById(@PathVariable long id) {
		return roleServ.getRoleById(id);
	}

	@GetMapping()
	public List<Role> getAllRole() {
		return roleServ.getAllRole();
	}

	@DeleteMapping("/{id}")
	public boolean deleteRole(@PathVariable long id) {
		try {
			roleServ.delRole(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
