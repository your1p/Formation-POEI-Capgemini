package com.aplose.smooss;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class CommentTestMain {

	public static void main(String[] args) {

		
		System.out.println("Comments Pictures");
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList ListeCommentairesPhotos = new ArrayList() ;
		
			
		
		Calendar Calendrier = Calendar.getInstance();
		int hour = Calendrier.get(Calendar.HOUR_OF_DAY);
		int minute = Calendrier.get(Calendar.MINUTE);
		int jour = Calendrier.get(Calendar.DATE);
		int mois = Calendrier.get(Calendar.MONTH);
		int année = Calendrier.get(Calendar.YEAR);
		
		System.out.println(Calendrier.get(Calendar.DATE)+"/"+Calendrier.get(Calendar.MONTH)+"/"+Calendrier.get(Calendar.YEAR)+"  "+Calendrier.get(Calendar.HOUR_OF_DAY)+" h "+Calendrier.get(Calendar.MINUTE)+" min");

	

	}

}
