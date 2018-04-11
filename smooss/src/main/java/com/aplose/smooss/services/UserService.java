package com.aplose.smooss.services;

import javax.persistence.TypedQuery;

import com.aplose.smooss.model.User;

public class UserService {

	private static UserService INSTANCE = null;
	
	
	private TypedQuery<User> findByLoginsAndPasswords;

	private UserService() {
	}

	public static UserService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UserService();
		}
		return INSTANCE;
	}

	public void create(User u) {

		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().persist(u);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();

	}

	public User read(long id) {

		User u = JPASingleton.getInstance().getEntityManager().find(User.class, id);
		return u;
	}
	
	private User findByLoginAndPassword(String login, String password) {
		String query = "Select u from User where login =: login AND password =: password";
		User u;
		findByLoginsAndPasswords = u.createQuery("query", User.class);
		findByLoginsAndPasswords.setParameter(login, User.class);
		findByLoginsAndPasswords.setParameter(password, User.class);
		User u = findByLoginsAndPasswords.getSingleResult();
		return u;
	}

}
