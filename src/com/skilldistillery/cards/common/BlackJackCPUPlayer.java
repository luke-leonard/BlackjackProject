package com.skilldistillery.cards.common;

public class BlackJackCPUPlayer extends BlackJackPlayer {

	public BlackJackCPUPlayer(String name, int winnings) {
		super(name, winnings);
	}

	@Override
	public int chooseOption() {
		if(hands.get(0).getValue() < 17) {
			return 0;
		}else {
			return 1;
		}
	}

}
