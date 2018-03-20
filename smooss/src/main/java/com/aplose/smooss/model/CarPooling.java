package com.aplose.smooss.model;

import java.util.Scanner;

public class CarPooling {

	public static void main(String[] args) {
		
		System.out.println("Classe CarPooling");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez entrer l'adresse de départ :");
		String departAdress = sc.nextLine();
		
		System.out.println("Veuillez entrer l'adresse d'arrivée :");
		String arriveeAdress = sc.nextLine();
		
		System.out.println("Veuillez entrer le nombre de place du véhicule :");
		String nbPlaces = sc.nextLine();
		
		System.out.println("Veuillez entrer une description du véhicule :");
		String carDescription = sc.nextLine();
		
		System.out.println("Veuillez préciser si c'est un aller retour :");
		String allerRetour = sc.nextLine();
		
		System.out.println("Veuillez entrer l'heure de départ du covoiturage :");
		String departureTime = sc.nextLine();
		
		System.out.println("Veuillez entrer l'heure de retour en cas d'aller-retour :");
		String departureBackTime = sc.nextLine();
		
		sc.close();
		
		
		System.out.print("NOTE DEV AFFICHAGE VARIABLES " +arriveeAdress + " " +departAdress + " " +nbPlaces + " " +carDescription + " " +allerRetour + " " +departureTime + " " +departureBackTime + " ");
			
	}

}
