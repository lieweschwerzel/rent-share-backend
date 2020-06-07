package com.rentshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentshare.model.DAOUser;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Long> {
	
	DAOUser findByUsername(String username);
	void deleteDAOUserById(Long Id);
	DAOUser findDAOUserById(Long id);
}