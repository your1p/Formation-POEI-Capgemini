package com.aplose.smooss.services;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.aplose.smooss.exception.EmailException;
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

	public void create(User u) throws EmailException {

		try {
			JPASingleton.getInstance().getEntityManager().getTransaction().begin();
			JPASingleton.getInstance().getEntityManager().persist(u);
			JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		}catch(PersistenceException e) {
			JPASingleton.getInstance().getEntityManager().getTransaction().rollback();
			u.setId(0);
			
			throw new EmailException("Oh mec t'as déjà un compte SMOOS Connecte-toi!");
		}

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

