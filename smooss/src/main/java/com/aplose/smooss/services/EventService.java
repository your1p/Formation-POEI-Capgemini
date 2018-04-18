package com.aplose.smooss.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.User;

public class EventService {

	private static EventService INSTANCE;
	private TypedQuery<Event> queryFindEventByUser;

	private EventService() {
	}

	public static EventService getInstance() {
		if (INSTANCE == null) {
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

	public List<Event> findEventsByUser(User user) {
		if (queryFindEventByUser == null) {
			EntityManager em = JPASingleton.getInstance().getEntityManager();
			queryFindEventByUser = em.createQuery("SELECT e FROM Event e WHERE admin = :user ", Event.class);
		}
		queryFindEventByUser.setParameter("user", user);
		List<Event> result = queryFindEventByUser.getResultList();
		return result;
	}

	public void modify(Event evt) {
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().merge(evt);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
	}
	
}