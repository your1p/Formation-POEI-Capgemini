package com.aplose.smooss.services;

import java.time.Instant;
import java.util.List;

import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.User;

import junit.framework.TestCase;

public class EventServiceTest extends TestCase {
	
	public void testFindEventsByUser() throws EmailException {
		
		UserService us = UserService.getInstance();
		User u = new User();
		u.setEmail("Gustave");
		u.setPassword("password");
		us.create(u);
		
		EventService es = EventService.getInstance();
		Event e = new Event();
		
		e.setAdmin(u);
		e.setName("Happy Birthday");
		e.setDescription("Anniversaire de bob");
		e.setLocalisation("Rond point du grand M");
		e.setStart(Instant.now());
		e.setEnd(Instant.parse("2018-04-18T22:00:00Z"));
		es.create(e);
	
		List<Event> result = es.findEventsByUser(u);
		assertEquals(1, result.size());
//		assertEquals(2, result.size());
	}
	
	public void testModify() {
		
		EventService es = EventService.getInstance();
		Event e = new Event();
		
		e.setName("Happy Birthday");
		e.setDescription("Anniversaire de bob");
		e.setLocalisation("Rond point du grand M");
		e.setStart(Instant.now());
		e.setEnd(Instant.parse("2018-04-18T22:00:00Z"));
		es.create(e);
				
		Event e2 = es.read(e.getId());
		e2.setName("Happy Holliday");
		es.modify(e2);
		
		Event e3 = es.read(e.getId());
		

		assertEquals(e.getName(), e3.getName());
		
		
	}
	
	public void testDelete() {
		
		
		EventService es = EventService.getInstance();
		Event e = new Event();
		
		e.setName("Happy Birthday");
		e.setDescription("Anniversaire de bob");
		e.setLocalisation("Rond point du grand M");
		e.setStart(Instant.now());
		e.setEnd(Instant.parse("2018-04-18T22:00:00Z"));
		es.create(e);
		long id = e.getId();
				
		Event e2 = es.read(id);
		assertNotNull(e2);
		assertEquals(e2, e);
		es.delete(e2);
		
		Event e3 = es.read(id);
		assertNull(e3);
		
		
	}

}