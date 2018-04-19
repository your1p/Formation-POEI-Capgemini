package com.aplose.smooss.services;

import com.aplose.smooss.model.User;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {
	
//	public void testFindByLoginAndPassword() {
//		
//		UserService us = UserService.getInstance();
//		User u = new User();
//		u.setEmail("Gustave");
//		u.setPassword("password");
//		us.create(u);
//		
//		User u2 = us.findByLoginAndPassword("Gustave", "password");
//		assertNotNull(u2);
//		assertEquals(u.getId(), u2.getId());
//		
//		User u3 = us.findByLoginAndPassword("Gustave", "badpassword");
//		assertNull(u3);
//		
//	}
	
	public void testUpdate() {
		
		
		UserService us =  UserService.getInstance();
		User u = new User();
		u.setEmail("bouboudbz@gmail.com");
		u.setFirstName("boubou");
		long id = u.getId();
		u.setEmail("bouboulogin");
		u.setFirstName("majinbou");
		u.setPassword("bouboukiki");
		
		if(u.getId()> 0 ) {
			System.out.println("On récupère l'id : "+id);
			us.update(u);
		}
		
		
		User u3 = us.findByLoginAndPassword("Gustave", "badpassword");
		assertNull(u3);

	}

}