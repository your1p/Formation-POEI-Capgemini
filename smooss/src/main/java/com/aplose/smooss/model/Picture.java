package com.aplose.smooss.model;

import java.awt.Image;
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
	List<Comment> comments = new List<Comment>();

	
}
