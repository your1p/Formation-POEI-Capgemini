package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String login; // le login c'est l'email//
	private String password;

	/* Cynthia & Ju >>*/
	private String name;
	private String email;
	private String nickName;
	private String lastName;
	private String firstName;
	private int picture;
	/* << Cynthia & Ju */
	
	public User() { }

	public User(String login, String password,String name, String firstName, String lastName, String nickName, int picture) {
		
		this.name = name;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.picture = picture;
		
	}
	
	//Getters & Setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	/* Cynthia & Ju >>*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getPicture() {
		return picture;
	}
	public void setPicture(int picture) {
		this.picture = picture;
	}
	/* << Cynthia & Ju */

	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
