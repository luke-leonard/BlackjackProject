package com.skilldistillery.cards.common;

public class BlackJackHumanPlayer extends BlackJackPlayer {

	public BlackJackHumanPlayer(String name, int winnings) {
		super(name, winnings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int chooseOption() {
		
		int choice = 0;
		while(true) {
			System.out.println("What do you want to do:");
			for(int i = 0 ; i < options.size(); i++) {
				System.out.println((i+1) + ") " + options.get(i));
			}
			String number = CasinoApp.input.nextLine();
			try {
				choice = Integer.parseInt(number);
				if(choice >  options.size() || choice <= 0) {
					System.out.println("Lets pick an actual");
				}else {
					break;					
				}
			}catch(NumberFormatException e) {
				System.out.println("That is not a number.");
			}
		}
	
		return choice - 1;
		
	}

	public void displayOptions() {
		for(String option : options) {
			System.out.println(option);
		}
	}

}
