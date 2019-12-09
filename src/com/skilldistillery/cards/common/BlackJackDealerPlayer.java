package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class BlackJackDealerPlayer extends BlackJackCPUPlayer implements Dealer {

	public BlackJackDealerPlayer(String name, int winnings) {
		super(name, winnings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deal(List<Player> players, Deck deck) {
		for (Player player : players) {
			player.setHands(new ArrayList<>());
			player.getHands().add(new BlackJackHand());
			Card cardToDeal = deck.drawCard();
			if (!(player instanceof Dealer)) {
				cardToDeal.setFaceUp(true);
			}
			player.getHands().get(0).addCard(cardToDeal);
		}
		for (Player player : players) {
			Card cardToDeal = deck.drawCard();
			cardToDeal.setFaceUp(true);
			player.getHands().get(0).addCard(cardToDeal);
		}
	}
	
	@Override
	public void playTurn(Deck deck) {
		hands.get(0).showHand();
		super.playTurn(deck);
	}

}
