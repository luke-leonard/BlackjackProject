package com.skilldistillery.cards.common;

public class BlackJackCard extends Card {

	public BlackJackCard(Suit suit, Rank rank) {
		super(suit, rank);
		// TODO Auto-generated constructor stub
	}
	public BlackJackCard(Suit suit, Rank rank, boolean faceUp) {
		super(suit, rank, faceUp);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getValue() {
		if(getRank().isFaceCard()) {
			return 10;
		}
		if(getRank().equals(Rank.ACE)) {
			return 11;
		}
		return super.getValue();
	}

}
