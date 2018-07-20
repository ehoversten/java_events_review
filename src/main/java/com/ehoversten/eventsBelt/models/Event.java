package com.ehoversten.eventsBelt.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 255, message="Event name is required")
	private String eventName;
	
	private LocalDate eventDate;
	
	@Size(min = 2, max = 255, message="Event location is required")
	private String eventCity;
	private String eventState;
	
    @Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;
	
	// --- RELATIONSHIPS --- // 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User host;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> joiners;
	
//	@OneToMany(mappedBy="event",fetch = FetchType.LAZY)
//	private List<Message> messages;
	
	// --- CONSTRUCTORS --- //
	public Event() {
		
	}
	
	public Event(String eventName, String eventCity, String eventState, LocalDate eventDate, User host) {
		this.eventName = eventName;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.eventDate = eventDate;
		this.host = host;
		
	}
	
	// --- GETTERS AND SETTERS --- // 
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getJoiners() {
		return joiners;
	}

	public void setJoiners(List<User> joiners) {
		this.joiners = joiners;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
	
	
}
