package com.aplose.smooss.services;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.aplose.smooss.model.User;

public class UserService {

	private static UserService INSTANCE = null;
	private TypedQuery<User> findByEmailAndPasswords;

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
	public User update(String email, String password, String firstName, String lastName, String nickName, String picture) {
		User u = new User();
		User u2 = JPASingleton.getInstance().getEntityManager().find(User.class, u);
		
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().merge(u);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		return u;
	}
	
	public User findByEmailAndPassword(String email, String password) {

		User u = null;
		
		if(findByEmailAndPasswords == null) {
			findByEmailAndPasswords = JPASingleton.getInstance().getEntityManager().createQuery("Select u from User u where email = :email AND password = :password", User.class);
		}
		
		findByEmailAndPasswords.setParameter("email", email);
		findByEmailAndPasswords.setParameter("password", password);
		
		try {
			u = findByEmailAndPasswords.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return u;
		
	}
	
}

