package edu.dat18c.coursesystem.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.dat18c.coursesystem.models.Role;

/**
 * RoleRepository
 */
public interface RoleRepository extends CrudRepository<Role, Long>
{

}