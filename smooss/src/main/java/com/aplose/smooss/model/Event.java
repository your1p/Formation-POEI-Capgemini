package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event{

	/////////	ATTRIBUTS DE LA CLASSE EVENT
	private User admin ;
	private String name;
	private String description;
	private String localisation;
	private Date start;
	private Date end;
	
	List<Module> modules = new ArrayList<Module>();
	
	//////GET SET ADMIN >>
	public User getAdmin() {
		return admin;
	}
	
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	
	//////GET SET NAME >>
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
	}
	
	//////GET SET NAME >>
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		
	}
	
	/////GET SET LOCALISATION >>
	public String getLocalisation() {
		return localisation;
	}
	
	public void setLocalisation(String localisation) {
		
	}
	
	////GET SET DATESTART
	public Date getStart() {
		return start;
	}
	
	public void setStart(Date start) {
		
	}
	
	////GET SET DATEEND
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		
	}
	
	///GET LIST
	public List<Module> getModules() {
		return modules;
	}
}
