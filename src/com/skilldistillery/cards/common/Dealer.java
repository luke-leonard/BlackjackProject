package com.skilldistillery.cards.common;

import java.util.List;

public interface Dealer {
	void deal(List<Player> players, Deck deck);

	default void reshuffle(Deck draw, Deck discard) {
		System.out.println("Reshuffleing");
		draw.returnCards(discard);
		draw.setAllFaceDown();
		draw.shuffle();
	}
}
