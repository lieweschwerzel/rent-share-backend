package com.rentshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.rentshare.model.DAOUser;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Long> {
	
	DAOUser findByUsername(String username);
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void deleteDAOUserById(Long Id);
	DAOUser findDAOUserById(Long id);

	@Modifying
	@Query("update DAOUser u set u.streetName= ?1,  u.houseNumber = ?2,  u.zipcode = ?3 where u.username = ?4")
	void updateUserDetails(String streetname, Integer housenumber, String zipcode, String username);
}