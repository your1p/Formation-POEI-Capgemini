package com.aplose.smooss.services;

import com.aplose.smooss.model.Invite;

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

}
