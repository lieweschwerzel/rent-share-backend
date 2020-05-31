package com.rentshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rentshare.model.DAOUser;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	void deleteAll();
	List<DAOUser> findAll();

}