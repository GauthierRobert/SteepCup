package com.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldcup.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("Select r from Role r where r.name = :name")
	Role findByName(@Param("name") String name);
	
}
