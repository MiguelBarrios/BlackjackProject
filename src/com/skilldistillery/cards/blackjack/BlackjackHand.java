package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int value = 0;
		for(Card card : cards) {
			value += card.getValue();
		}
		return value;
	}
	
	public boolean isBlackjack() {
		
		int value = getHandValue();
		return (value == 21 && cards.size() == 2);
	}
	
	public boolean isBust() {
		return (getHandValue() > 21);
	}
	
	public boolean isSoft() {
		for(Card card : cards) {
			if(card.getValue() == 11);
				return true;
		}
		return false;
	}
	
	public boolean isHard() {
		return !isSoft();
	}

}
