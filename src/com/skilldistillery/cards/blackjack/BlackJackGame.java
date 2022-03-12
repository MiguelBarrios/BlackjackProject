package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class BlackJackGame {

	private Player player;
	
	private Player dealer;
	
	private Deck deck;
	
	public BlackJackGame() {
		player = new Player("Player");
		dealer = new Dealer("Dealer");
		deck = new Deck();
	}
	
	public void startGame() {
		deck.suffle();
		dealNewHand(player);
		dealNewHand(dealer);
		System.out.println(player);
		System.out.println(dealer);
	}
	
	
	public void dealNewHand(Player player) {
		deck.dealCards(2, player);
	}
	
	public void gameCycle() {
		
	}

	public static void main(String[] args) {
		BlackJackGame game = new BlackJackGame();
		game.startGame();
		
		
		
	}
	
}
