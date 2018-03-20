package com.aplose.smooss.model;

import java.util.List;


/**
 * Class PlaylistModule that will manage the playlist for an event
 * @author tomas
 *
 */
public class PlaylistModule 
{
	private List<String> playlist;
	private String musicType;
	
	// Method main for a simple test, delete it after
	public static void main(String[] args) 
	{
		for (MusicGenre musicType : MusicGenre.values()) 
		{
			System.out.println("Different type of music : " + musicType);
		}
	}
	
}
