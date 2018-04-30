package com.aplose.smooss.services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Picture;
import com.aplose.smooss.model.User;

import junit.framework.TestCase;

public class PictureServiceTest extends TestCase {
	
	public void testCreate() {
		
		PictureService ps = PictureService.getInstance();
		
		User u = new User("m@m.fr","mm","martin","masse",null,null);
		try {
			UserService.getInstance().create(u);
		} catch (EmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Event e = new Event();
		e.setAdmin(u);
		EventService.getInstance().create(e);
		
		String s = "iVBORw0KGgoAAAANSUhEUgA";
		
		ps.create(e, s, "TestPicture", "Picture description..", u);
		
		List<Picture> pictures = ps.findPicturesByEvent(e);
		assertEquals(pictures.size(), 1);

	}

}
