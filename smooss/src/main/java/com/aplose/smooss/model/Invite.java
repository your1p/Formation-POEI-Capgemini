package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity

public class Invite {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Event event;
	@ManyToOne
	private User invited;
	
	public List<Invite> findInviteByUser(User login) {
		return null;
	}
}
