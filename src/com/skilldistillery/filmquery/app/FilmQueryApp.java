package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		Scanner kb = new Scanner(System.in);
//    app.test();
		do {
			app.launch(kb);
			System.out.println();
		} while (true);
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
		Actor actor = db.findActorById(1);
		System.out.println(actor);
	}

	private void launch(Scanner kb) {
		System.out.println(
				"Hello! Please select from the following options:\n1. Lookup a film by its ID.\n2. Search for a film by keyword in title and/or description.\n3 Exit this application.");

		startUserInterface(kb);

	}

	private void startUserInterface(Scanner kb) {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		int choice = 0;
		try {
			do {
				choice = kb.nextInt();
				kb.hasNextLine();
				if (choice != 1 && choice != 2 && choice != 3) {
					System.out.println("Please select option 1, 2, or 3.");
				}
			} while (choice != 1 && choice != 2 && choice != 3);

		} catch (Exception e) {
			System.out.println("Input needs to be an int. please try again.");
		}

		int choice2 = -1;

		switch (choice) {
		case 1:
			System.out.print("Great. What is the film's ID? ");
			choice2 = kb.nextInt();
			kb.hasNextLine();
			Film f = db.findFilmById(choice2);
			if (f != null) {
				System.out.println(f);
			}

			break;
		case 2:
			System.out.print("What is the word you want to search? ");
			String keyWord = kb.next();
//			System.out.println(keyWord + "*");
			ArrayList<Film> titleSearchResults = db.titleKeyWordSearch(keyWord);
			System.out.println(keyWord + " returned " + titleSearchResults.size() + " results from movie titles:");
			for (int i = 0; i < titleSearchResults.size(); i++) {
				System.out.println(titleSearchResults.get(i));
			}
			ArrayList<Film> descriptionSearchResults = db.descriptionKeyWordSearch(keyWord);
			descriptionSearchResults.addAll(db.descriptionKeyWordSearch(keyWord));
			for (int i = 0; i < descriptionSearchResults.size(); i++) {
				System.out.println(descriptionSearchResults.get(i));
			}

			break;
		case 3:
			System.out.println("Good bye.");
			System.exit(0);
			break;

		}

	}

}
