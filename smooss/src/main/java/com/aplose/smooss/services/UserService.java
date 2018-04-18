package com.aplose.smooss.services;

import javax.persistence.NoResultException;
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
	
	
	
	
	/**
	 * L'opération Update
	 * @param u La personne à mettre à jour dans la base de données.
	 * @return La personne mise à jour
	 */
	public User update(User u) {
		
		u = JPASingleton.getInstance().getEntityManager().find(User.class, u);
		
		System.out.println("boubou >> " + u);
		
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		u = JPASingleton.getInstance().getEntityManager().merge(u);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		return u;
	}
	
	public User findByLoginAndPassword(String login, String password) {

		User u = null;
		
		if(findByLoginsAndPasswords == null) {
			findByLoginsAndPasswords = JPASingleton.getInstance().getEntityManager().createQuery("Select u from User u where login = :login AND password = :password", User.class);
		}
		
		findByLoginsAndPasswords.setParameter("login", login);
		findByLoginsAndPasswords.setParameter("password", password);
		
		try {
			u = findByLoginsAndPasswords.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return u;
		
	}
	
	

}

