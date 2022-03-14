package com.skilldistillery.cards.common;

import com.skilldistillery.cards.blackjack.BlackjackHand;

public class Player {
	protected Hand hand;
	
	protected String name;
	
	public Player(String name) {
		hand = new BlackjackHand();
		this.name = name;
	}
	
	public void receiveCard(Card card) {
		hand.addCard(card);
	}

	@Override
	public String toString() {
		return name + " hand = " + hand.getHandValue()+ ", Cards" +hand;
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public void clearHand(){
		hand.clear();
	}
	
	
	
}
