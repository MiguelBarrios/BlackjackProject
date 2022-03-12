package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cards;
	
	public abstract int getHandValue();
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.clear();
	}

	@Override
	public String toString() {	
		return cards.toString() ;
	}
	
	
	
	
}
