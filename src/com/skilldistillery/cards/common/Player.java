package com.skilldistillery.cards.common;

import com.skilldistillery.cards.blackjack.BlackjackHand;

public class Player {
	private Hand hand;
	
	private String name;
	
	public Player(String name) {
		hand = new BlackjackHand();
		this.name = name;
	}
	
	public void receiveCard(Card card) {
		hand.addCard(card);
	}

	@Override
	public String toString() {
		return name + hand + " (" + hand.getHandValue() + ")";
	}
	
	
	
}
