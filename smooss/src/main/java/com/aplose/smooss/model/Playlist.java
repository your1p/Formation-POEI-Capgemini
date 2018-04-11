package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;


/**
 * 
 * @author thomas
 *
 */
@Entity
public class Playlist {
	
	@ManyToMany
	private List<Url> urls;
	@Enumerated
	private MusicGenre genre;
	
	
	public MusicGenre getGenre() {
		return genre;
	}
	
	public void setGenre(MusicGenre genre) {
		this.genre = genre;
	}
	
	public List<Url> getUrls() {
		return urls;
	}
	
}
