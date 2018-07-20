package com.ehoversten.eventsBelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.ehoversten.eventsBelt.models.Event;

@Repository
public interface EventRepository extends CrudRepository <Event, Long>{
	List<Event> findAll();
	
	List<Event> findEventByState(String state);
	
//	@Query("SELECT e FROM Event e WHERE e.state != ?1")
//	List<Event> findEventByNotState(String state);
//	
//	@Query(value="SELECT COUNT(user_id) FROM users_events WHERE event_id = ?1", nativeQuery=true)
//	Long countJoiners(Long id);
	
	
	
}
