package com.aplose.smooss.services;

import java.util.ArrayList;
import java.util.List;

//import javax.naming.spi.DirStateFactory.Result;
//import java.util.List;
//import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.aplose.smooss.model.Invite;
import com.aplose.smooss.model.User;

public class InviteService {
	
	private static InviteService INSTANCE;
	private TypedQuery<Invite> findInviteByUser;
	
	private InviteService () {}
	
	public static InviteService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new InviteService();
		}
		return INSTANCE;
	}
	public void create(Invite ivt) {
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().persist(ivt);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
	}

	public Invite read(long id) {
		Invite ivt = JPASingleton.getInstance().getEntityManager().find(Invite.class, id);
		return ivt;
	}
	
	public List<Invite> findInvitesByUser(User login) {
		List<Invite> result = new ArrayList<Invite>();
//		Invite i = null;
		if(findInviteByUser == null) {
			findInviteByUser = JPASingleton.getInstance().getEntityManager().createQuery("SELECT i FROM Invite i, User u WHERE event=:event, invited=:invited",Invite.class);

		}
		findInviteByUser.setParameter("login", login);
		
		try {
			result = findInviteByUser.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
