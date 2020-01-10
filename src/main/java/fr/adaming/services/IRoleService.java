package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Role;

public interface IRoleService {

	public void saveRole(Role role);

	public void updateRole(Role role);

	public Role getRoleById(long id);

	public List<Role> getAllRole();

	public void delRole(long id);
}
