package com.aplose.smooss.services;

import javax.persistence.PersistenceException;

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
	
	public void testCreate() {
		UserService us = UserService.getInstance();
		User u = createGustave("gustave@gmail.com");
		us.create(u);
		assertTrue(u.getId()>0);
		
		User u2 = createGustave("gustave@gmail.com");		
		
		us.create(u2);
		
		assertFalse(u2.getId()>0);
		
	}
	
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
		
		
		User u3 = us.findByEmailAndPassword("Gustave", "badpassword");
		assertNull(u3);

	}
	
	private User createGustave(String email) {
		User u = new User();
		u.setEmail(email);
		u.setFirstName("Gustave");
		u.setLastName("Flaubert");
		u.setPassword("password");
		return u;
	}
}