package com.aplose.smooss.services;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.aplose.smooss.services.JPASingleton;

public class JPASingleton {
	
	private static JPASingleton INSTANCE;
	private EntityManagerFactory emf;
	private EntityManager em;

	private JPASingleton() {
	}
	
	public static JPASingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new JPASingleton();
		}
		return INSTANCE;
	}


	public EntityManager getEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("SmoossPU");
		}
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
		return em;
	}

	public void close() {

		if (em !=null && em.isOpen()) {
			em.close();
		}
		
		if (emf!=null && emf.isOpen()) {
			emf.close();
		}
	}
}

