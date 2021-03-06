package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	private int numberOfDecks;
	
	public Deck() {
		this(1);
	}
	
	public Deck(int numberOfDecks) {
		this.numberOfDecks = numberOfDecks;
		cards = new ArrayList<>(52 * numberOfDecks);
		fillDeck();
	}
	
	public void fillDeck() {
		for(int i = 0; i < numberOfDecks; ++i) {
			for(Suit suit : Suit.values()) {
				for(Rank rank : Rank.values())
					cards.add(new Card(suit, rank));
			}
		}

		shuffle();
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.remove(cards.size() - 1);
	}
	
	public void dealCards(int numberOfCards, Player player) {
		for(int i = 0; i < numberOfCards; ++i) {
			if(cards.isEmpty())
				fillDeck();
			
			player.receiveCard(dealCard());
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void printDeck() {
		System.out.println(cards);
	}
}
