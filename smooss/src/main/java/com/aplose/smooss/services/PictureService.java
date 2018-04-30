package com.aplose.smooss.services;

import java.util.ArrayList;
import java.util.List;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Module;
import com.aplose.smooss.model.Picture;
import com.aplose.smooss.model.PicturesModule;
import com.aplose.smooss.model.User;
import com.aplose.smooss.model.Module.TypeModule;

public class PictureService {

	private static PictureService INSTANCE;
	
	private PictureService() {}

	public static PictureService getInstance() {	
		if (INSTANCE == null) {
			INSTANCE = new PictureService();
		}
		return INSTANCE;
	}

	public Picture create(Event e, String imgBase64, String name, String description, User author) {
		
		//Construct the picture and add it into PictureModule's list of pictures.
		Picture p = new Picture(imgBase64, name, description, author);
		PicturesModule pm = (PicturesModule)EventService.getInstance().findModuleByEvent(e, TypeModule.PicturesModule);
		
		
		List<Picture> pictures = pm.getPictures();
		pictures.add(p);
		pm.setPictures(pictures);
		
		//Persist picture and merge to event
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().persist(p);
		this.updatePictureModule(pm);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		
		return p;
	}
	
	public Picture read(Long id) {
		
		Picture p = JPASingleton.getInstance().getEntityManager().find(Picture.class, id);
		return p;
	}
	
	public Picture update(Picture p) { 
		
		Picture picture = JPASingleton.getInstance().getEntityManager().find(Picture.class, p);
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().merge(p);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		return picture;
		
	}
	
	public void delete(Picture p, Event e) {
		
		PicturesModule pm = (PicturesModule)EventService.getInstance().findModuleByEvent(e, TypeModule.PicturesModule);
		List<Picture> pictures = pm.getPictures();
		pictures.remove(p);
		pm.setPictures(pictures);
		
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().remove(p);
		this.updatePictureModule(pm);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		
	}
	
	public Module updatePictureModule(Module pm) {
		Module pictureModule = JPASingleton.getInstance().getEntityManager().find(Module.class, pm);
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().merge(pm);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		return pictureModule;
	}
	
	public List<Picture> findPicturesByEvent(Event e){
		
		List<Picture> pictures = null;
		
		for(Module m : e.getModules()) {
			if(m instanceof PicturesModule) {
				pictures = ((PicturesModule)m).getPictures();
			}
		}
		if(pictures == null) {
			pictures = new ArrayList<Picture>();
		}
		
		return pictures;
	}

}