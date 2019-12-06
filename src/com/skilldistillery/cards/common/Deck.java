package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		super();
		this.cards = new52CardDeck();
		shuffle();
	}
	
	private List<Card> new52CardDeck(){
		List<Card> cards = new ArrayList<>(54);
		for(Suit suit:Suit.values()) {
			for(Rank rank:Rank.values()) {
				cards.add(new Card(suit,rank));
			}
		}
		return cards;
	}
	
	public Card DealCard() {
		if(checkDeckSize() > 0) {
			return cards.remove(cards.size()-1);			
		}else {
			return null;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	
	public int checkDeckSize() {
		return cards.size();
	}
}
