package com.aplose.smooss.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Picture Class, create a picture.
 * @author Smooss Team
 * Last revision Martin M.
 */

public class Picture
{

	private Image picture = null;
	private String name = null;
	private String description = null;
	private User author = null;
	private List<Comment> comments = new ArrayList<Comment>();
	
	public Picture(Image picture, String name, String description, User author)
	{
		this.picture = picture;
		this.name = name;
		this.description = description;
		this.author = author;
	}
	
	public Image getPicture()
	{
		return picture;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public User getAuthor()
	{
		return author;
	}
	
	public void setComment(Comment comment)
	{
		comments.add(comment);
	}
	
	
	
	
}
