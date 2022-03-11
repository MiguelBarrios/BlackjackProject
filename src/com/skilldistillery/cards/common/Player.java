package com.skilldistillery.cards.common;

import com.skilldistillery.cards.blackjack.BlackjackHand;

public class Player {
	private Hand hand;
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public void receiveCard(Card card) {
		hand.addCard(card);
	}

	@Override
	public String toString() {
		return "Player [hand=" + hand + "]";
	}
	
	
	
}
