package com.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worldcup.model.Privilege;


@Repository("privilegeRepository")
public interface PrivilegeRepository  extends JpaRepository<Privilege, Long>{
	

}
