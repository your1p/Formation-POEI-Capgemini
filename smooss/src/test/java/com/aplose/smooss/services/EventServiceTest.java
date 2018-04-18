package com.aplose.smooss.services;

import java.time.Instant;
import java.util.List;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.User;

import junit.framework.TestCase;

public class EventServiceTest extends TestCase {
	
	public void testFindEventsByUser() {
		
		UserService us = UserService.getInstance();
		User u = new User();
		u.setLogin("Gustave");
		u.setPassword("password");
		us.create(u);
		assertEquals(1L, u.getId());
		
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

}
