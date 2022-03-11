package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = createDeck();
	}
	
	public List<Card> createDeck() {
		List<Card> cards = new ArrayList<>(52);
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
		return cards;
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.remove(cards.size() - 1);
	}
	
	public List<Card> dealCards(Hand hand, int numberOfCards) {
		List<Card> res = new ArrayList<>();
		for(int i = 0; i < numberOfCards; ++i) {
			if(cards.isEmpty())
				cards = createDeck();
			res.add(dealCard());
		}
		
		return res;
	}
	
	public void suffle() {
		Collections.shuffle(cards);
	}
}
