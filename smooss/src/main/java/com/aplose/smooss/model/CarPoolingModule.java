package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CarPoolingModule extends Module {

	@OneToMany
	private List<CarPooling> carPooling;

	public List<CarPooling> getCarPooling() {
		return carPooling;
	}
	
}