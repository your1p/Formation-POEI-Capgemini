package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	private String name = "Default Module Name";
	private TypeModule type = TypeModule.DefaultType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(TypeModule type) {
		this.type = type;
	}
	
	public TypeModule getType() {
		return this.type;
	}
	
	public enum TypeModule {
		DefaultType, CarpoolingModule, BringModule, PicturesModule, PlaylistModule,
	}
}