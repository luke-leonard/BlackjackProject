package com.skilldistillery.cards.common;

public enum Suit {
	SPADE("Spades"), HEART("Hearts"), CLUB("Clubs"), DIAMOND("Diamonds");

	private String name;

	Suit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
