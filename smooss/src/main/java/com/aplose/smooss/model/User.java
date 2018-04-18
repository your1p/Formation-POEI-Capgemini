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
<<<<<<< HEAD
	/* Cynthia & Ju >>*/
	private String name;
	private String email;
	private String firstName;
	private int picture;
	/* << Cynthia & Ju */
	
=======
	private String nickName;
	private String firstName;
	private String lastName;
	
	public User(){};
	
	public User(String login, String password, String firstName, String lastName, String nickName) {
		
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		
	}
>>>>>>> 7a4ca8d8fda84d61d6ef3aafee7163ae14711bf1
	
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
	
<<<<<<< HEAD
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

	
=======
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
>>>>>>> 7a4ca8d8fda84d61d6ef3aafee7163ae14711bf1
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
