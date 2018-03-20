package com.aplose.smooss.model;

import java.awt.Image;
import java.util.List;

/**
 * Picture Class, create a picture.
 * @author Martin M
 *
 */

public class Picture
{

	private Image picture = null;
	private String name = null;
	private String description = null;
	private User author = null;
	//List<Comment> comments = new List<Comment>();

	Picture(Image picture)
	{
		this.picture = picture;
	}
	
	Picture(Image picture, String name)
	{
		this.picture = picture;
		this.name = name;
	}
	
}
