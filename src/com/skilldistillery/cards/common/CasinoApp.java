package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasinoApp {

	// I would have a bunch of scanners open all over the place for every player but
	// that is impossible to handle
	public static Scanner input = new Scanner(System.in);
	
	// F I E L D S
	private List<Game> games;
	
	public static void main(String[] args) {
		CasinoApp app = new CasinoApp();
		app.run();
	}
	
	public void init() {
		games = new ArrayList<>();
		games.add(new BlackJackGame());
	}
	
	public void run() {
		init();
		System.out.println("Welcome to Luke's Casino where everyone is a winner.");
		System.out.println("You may not win any money, but at least you participated.");
		System.out.println("Don't worry, we will give you a ribbon on the way out.");
		System.out.println();
		selectGame();
		close();
	}
	
	public void close() {
		input.close();
	}
	
	public void selectGame() {
		while(true) {
			int selection = 0;
			while(true) {
				System.out.println("Please select a game to play:");
				for (int i = 0; i < games.size();i++) {
					System.out.println((i+1) + ") " + games.get(i));
				}
				System.out.println("Q) Quit");
				String number = CasinoApp.input.nextLine();
				if(number.equalsIgnoreCase("Q")||number.equalsIgnoreCase("QUIT")) {
					return;
				}
				try {
					selection = Integer.parseInt(number);
					if(selection > 0 || selection <= games.size()) {
						break;
					}
					
				}catch(NumberFormatException e) {
					System.out.println("That is not a number.");
				}
			}
			games.get(selection - 1).play(); 
			System.out.println("Thanks for playing");
		}
	}

}
