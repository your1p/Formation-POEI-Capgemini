package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class PicturesModule extends Module {

	@OneToMany
	private List<Picture> pictures;
	
	public List<Picture> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
}
