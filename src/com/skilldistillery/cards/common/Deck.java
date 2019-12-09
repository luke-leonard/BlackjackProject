package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// F I E L D S
	private List<Card> cards;

	// C O N S T R U C T O R S
	public Deck(List<Card> cards) {
		super();
		this.cards = cards;
		shuffle();
	}

	// M E T H O D S
	public Card drawCard() {
		if (getDeckSize() > 0) {
			return cards.remove(cards.size() - 1);
		} else {
			return null;
		}
	}

	public List<Card> drawCards(int amount) {
		List<Card> cards = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			cards.add(drawCard());
		}
		return cards;
	}

	public void returnCard(Card card) {
		cards.add(card);
	}

	public void returnCards(List<Card> cards) {
		this.cards.addAll(cards);
	}
	
	public void returnCards(Deck deck) {
		this.cards.addAll(deck.drawCards(deck.getDeckSize()));
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public int getDeckSize() {
		return cards.size();
	}
	
	public void setAllFaceDown() {
		for(Card card: cards) {
			card.setFaceUp(false);
		}
	}

	@Override
	public String toString() {
		String returnString = "Deck:\n";
		for(Card card:cards) {
			returnString += card + "\n";
		}
		return returnString;
	}
	
}
