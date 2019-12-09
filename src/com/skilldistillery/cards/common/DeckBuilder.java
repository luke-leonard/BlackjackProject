package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {
	public Deck build52CardBlackJackDeck() {
		List<Card> cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new BlackJackCard(suit, rank));
			}
		}
		return new Deck(cards);

	}
	public Deck buildEmptyDiscardPile() {
		return new Deck(new ArrayList<>(52));
	}

}
