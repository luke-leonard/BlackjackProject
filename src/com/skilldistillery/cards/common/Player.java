package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	
	// F I E L D S
	protected String name;
	protected List<Hand> hands;
	protected int winnings;
	protected List<String> options;
	
	// C O N S T R U C T O R S
	public Player(String name, int winnings) {
		super();
		this.name = name;
		this.hands = new ArrayList<>();
		this.winnings = winnings;
		this.options = new ArrayList<>();
	}
	
	// A B S T R A C T _ M E T H O D S
	public abstract void playTurn(Deck deck);
	public abstract int chooseOption();
	
	// A U T O _ G E N E R A T E D _ M E T H O D S
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hand> getHands() {
		return hands;
	}

	public void setHands(List<Hand> hands) {
		this.hands = hands;
	}

	public int getWinnings() {
		return winnings;
	}

	public void setWinnings(int winnings) {
		this.winnings = winnings;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public int getValue() {
		return hands.get(0).getValue();
	}
	@Override
	public String toString() {
		String returnString = name + " has:\n";
		for(int i = 0; i < hands.size();i++) {
			returnString += "hand " + (i + 1) +": "+ hands.get(i) + "\n";
		}
		return returnString;
	}	
}
