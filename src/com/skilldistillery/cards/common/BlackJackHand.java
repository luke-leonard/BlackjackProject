package com.skilldistillery.cards.common;

public class BlackJackHand extends Hand {	
	@Override
	public int getValue() {
		int value = super.getValue();
        for (int i = 0; value > 21 && i < cards.size();i++) {
        	if(cards.get(i).getRank().equals(Rank.ACE)) {
        		value -= 10;
        	}
        }
        if(value > 21) {
        	return -1;
        }
        return value;
	}
}
