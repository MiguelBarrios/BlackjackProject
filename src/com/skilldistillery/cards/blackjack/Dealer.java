package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Player;

public class Dealer extends Player {
	
	public Dealer(String name) {
		super(name);
	}
	
	public void showHand(boolean partialView) {
		String view = name + hand + " (" + hand.getHandValue() + ")";
		
		System.out.println(view);
	}
	
	
}
