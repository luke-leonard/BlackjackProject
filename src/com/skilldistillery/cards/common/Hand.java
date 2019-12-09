package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	// F I E L D S
	protected List<Card> cards;

	// C O N S T R U C T O R S
	public Hand() {
		super();
		this.cards = new ArrayList<>();
	}

	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}

	// M E T H O D S
	public Card discardCard(int index) {
		return cards.remove(index);
	}

	public List<Card> discardHand() {
		List<Card> temp = cards;
		cards = new ArrayList<>();
		return temp;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void addCards(List<Card> cards) {
		this.cards.addAll(cards);
	}

	public void showCard(int index) {
		cards.get(index).setFaceUp(true);
	}

	public void showHand() {
		for (Card card : cards) {
			card.setFaceUp(true);
		}
	}

	public void hideCard(int index) {
		cards.get(index).setFaceUp(false);
	}

	public void hideHand() {
		for (Card card : cards) {
			card.setFaceUp(false);
		}
	}

	public int getValue() {
		int value = 0;
		for (Card card : cards) {
			if (card.isFaceUp()) {
				value += card.getValue();
			}
		}
		return value;
	}

	public int getHandSize() {
		return cards.size();
	}

	// A U T O _ G E N E R A T E D _ M E T H O D S
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		String returnString = "";
		for (Card card : cards) {
			returnString += card + "   ";
		}
		returnString += "value: " + getValue();
		return returnString;
	}

}
