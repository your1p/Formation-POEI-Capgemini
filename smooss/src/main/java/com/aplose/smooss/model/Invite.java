package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class Invite {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany
	private Invite ivt;
}
