package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CarPoolingModule extends Module {

	@OneToMany
	private List<String> carPooling;

	public List<String> getCarPooling() {
		return carPooling;
	}
	
	
	
	
}
