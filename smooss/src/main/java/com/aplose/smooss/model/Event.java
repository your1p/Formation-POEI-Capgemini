package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	////////	ATTRIBUTS DE LA CLASSE EVENT
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User admin ;
	private String name;
	private String description;
	private String localisation;
	private Date start;
	private Date end;
	
	@OneToMany
	List<Module> modules = new ArrayList<Module>();
	
	@ManyToMany
	List<User> participants = new ArrayList<User>();

	
	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	//////GET SET ADMIN >>
	private User getAdmin() {
		return admin;
	}
	
	private void setAdmin(User admin) {
		this.admin = admin;
	}
	
	//////GET SET NAME >>
	private String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	//////GET SET NAME >>
	private String getDescription() {
		return description;
	}
	
	private void setDescription(String description) {
		this.description = description;
	}
	
	/////GET SET LOCALISATION >>
	private String getLocalisation() {
		return localisation;
	}
	
	private void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	////GET SET DATESTART
	private Date getStart() { //Une autre façon de noter le get
		return this.start;
	}
	
	private void setStart(Date s) { // Une autre façon de noter le set
		this.start = s;
	}
	
	////GET SET DATEEND
	private Date getEnd() {
		return end;
	}
	
	private void setEnd(Date end) {
		this.end = end;
	}
	
	public List<User> getParticipants() {
		return participants;
	}

	///GET LIST
	private List<Module> getModules() {
		return modules;
	}
}
