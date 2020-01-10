package fr.adaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

}
