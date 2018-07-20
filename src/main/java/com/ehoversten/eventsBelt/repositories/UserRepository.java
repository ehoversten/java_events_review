package com.ehoversten.eventsBelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ehoversten.eventsBelt.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{
	// Taking care of casting the type here before its needed in the SERVICE
	List<User> findAll();
	
	// our specified query for a users email
	User findByEmail(String email);
	
}
