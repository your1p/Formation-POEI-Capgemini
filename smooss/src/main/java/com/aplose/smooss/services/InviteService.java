package com.aplose.smooss.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.aplose.smooss.model.Invite;
import com.aplose.smooss.model.User;

public class InviteService {
	
	private static InviteService INSTANCE;
	
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
	
	public List <User> findInviteByUser(User id) {
		String query = "SELECT id FROM user WHERE login=:login";

			
		
		return null;
	} 

}
