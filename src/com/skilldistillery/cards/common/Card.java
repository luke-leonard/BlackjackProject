package com.skilldistillery.cards.common;

public class Card {
	
	// F I E L D S
	private Suit suit;
	private Rank rank;
	private boolean faceUp;
	
	// C O N S T R U C T O R S
	public Card() {
		super();
	}
	
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
		this.faceUp = false;
	}
	public Card(Suit suit, Rank rank, boolean faceUp) {
		super();
		this.suit = suit;
		this.rank = rank;
		this.faceUp = faceUp;
	}

	// M E T H O D S
	
	public int getValue() {
		return rank.ordinal() + 1;
	}
	
	// A U T O _ G E N E R A T E D _ M E T H O D S
	
	@Override
	public String toString() {
		if(faceUp) {
			return rank + " of " + suit;
		}else {
			return "Face down";
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	
	
}
