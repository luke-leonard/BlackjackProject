package com.skilldistillery.cards.common;

import java.util.ArrayList;

public abstract class BlackJackPlayer extends Player {

	public BlackJackPlayer(String name, int winnings) {
		super(name, winnings);
	}

	@Override
	public void playTurn(Deck deck) {
		boolean running = true;
		while(running) {
			detectOptions();
			int choice = chooseOption();

			switch (options.get(choice)) {
				case "hit":
					System.out.println(name + " hit");
					Card card = deck.drawCard();
					card.setFaceUp(true);
					System.out.println(name + " drew a " + card);
					hands.get(0).addCard(card);
					break;
				case "stand":
					System.out.println(name + " stands");
					running = false;
					break;
				default:
					break;
			}
			if(hands.get(0).getValue() == -1) {
				System.out.println(name + " busted");
				running = false;
			}else {
				System.out.println(hands.get(0));
			}
		}


	}

	public void detectOptions() {
		options = new ArrayList<>();

		options.add("hit");
		options.add("stand");

	}

}
