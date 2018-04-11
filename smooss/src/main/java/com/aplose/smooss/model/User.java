package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long login;
	private long password;
	
	//Getters & Setters
	public long getLogin() {
		return login;
	}
	public long getId() {
		return id;
	}
	public void setLogin(long login) {
		this.login = login;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	
	
	
}
