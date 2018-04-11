package com.aplose.smooss.services;

import com.aplose.smooss.model.Event;

public class EventService {

	private static EventService INSTANCE;
	
	private EventService() { }
	
	public static EventService getInstance() {
		if ( INSTANCE == null ) {
			INSTANCE = new EventService();
		}
		
		return INSTANCE;
	}
	
	public void create(Event evt) {
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().persist(evt);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
	}
	
	public Event read(long id) {
		Event evt = JPASingleton.getInstance().getEntityManager().find(Event.class, id);
		return evt;
	}
}
 