package com.ehoversten.eventsBelt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 255, message="First name cannot be blank")
	private String fName;
	
	@Size(min = 2, max = 255, message="Last name cannot be blank")
	private String lName;
	
	@Size(min = 2, max = 255, message="Email is required")
	@Email(message="Must be valid email")
	private String email;
	
	@Size(min = 2, max = 255, message="City cannot be blank")
	private String city;
	
	@Size(min = 2, message="State cannot be blank")
	private String state;
	
	@Size(min = 5, max = 255, message="password cannot be blank")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
    @Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;
	
	// --- RELATIONSHIPS --- // 
	
//    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
//    private List<Event> myEvents;
	
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "users_events", 
//        joinColumns = @JoinColumn(name = "user_id"), 
//        inverseJoinColumns = @JoinColumn(name = "event_id")
//    )
//    private List<Event> joinedEvents;
	
//    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
//    private List<Message> messages;
	
	
	// --- CONSTRUCTORS --- // 
	public User() {
		
	}
	
	// constructor for a user to login
	public User(String email, String password) {
		this.email = email;
		this.password = password;
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


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
