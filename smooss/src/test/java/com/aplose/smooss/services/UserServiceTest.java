package com.aplose.smooss.services;

import com.aplose.smooss.model.User;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {
	
	public void testFindByLoginAndPassword() {
		
		UserService us = UserService.getInstance();
		User u = new User();
		u.setLogin("Gustave");
		u.setPassword("password");
		us.create(u);
		
		User u2 = us.findByLoginAndPassword("Gustave", "password");
		assertNotNull(u2);
		assertEquals(u.getId(), u2.getId());
		
		User u3 = us.findByLoginAndPassword("Gustave", "badpassword");
		assertNull(u3);
		
	}

}
