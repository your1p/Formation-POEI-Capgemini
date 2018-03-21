package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event extends User{


	//private Admin User ;
	private String name = null;
	private String description = null;
	private String localisation = null;
	private Date start = null;
	private Date end = null;
	
	List<Module> modules = new ArrayList<Module>();
}
