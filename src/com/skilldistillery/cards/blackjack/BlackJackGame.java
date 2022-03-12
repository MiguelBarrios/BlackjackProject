package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class BlackJackGame {

	private Scanner scanner;

	private Player player;

	private Player dealer;

	private Deck deck;

	public BlackJackGame(Scanner scanner) {
		this.scanner = scanner;
		player = new Player("Player");
		dealer = new Dealer("Dealer");
		deck = new Deck();
	}
	
	public void startGame() {
		deck.suffle();
		String userInput = "1";
		while(userInput.equals("1")) {
			int results = turnCycle();
			printResults(results);
			player.clearHand();
			dealer.clearHand();
			System.out.print("enter 1 to play again, enter anything else to continue: ");
			userInput = scanner.nextLine().trim();
		}

		
	}
	
	// return 1 if player won
	// return -1 if player lost
	// return 0 if draw
	public int turnCycle() {
		dealNewHand(player);
		dealNewHand(dealer);
		showTable();
		
		boolean playerBust = proccessPlayerTurn();
		if(playerBust)
			return -1;
		
		boolean dealerBust = proccessDealerTurn();
		if(dealerBust)
			return 1;
		
		if(player.getHandValue() == dealer.getHandValue())
			return 0;
		
		return (player.getHandValue() > dealer.getHandValue()) ? 1 : -1;
	}
	
	public void showTable() {
		System.out.println(player);
		System.out.println(dealer);
	}
	
	public void dealNewHand(Player player) {
		deck.dealCards(2, player);
	}

	// return true if player bust
	public boolean proccessPlayerTurn() {
		boolean exit = false;
		while(!exit) {
			System.out.print("\n1) hit 2) stay\nselect option: "); 
			String userInput = scanner.nextLine().trim();
			if(userInput.equals("1")) {
				int handValue = hit(player);
				if(handValue > 21)
					exit = true;
			}
			else if(userInput.equals("2")) {
				exit = true;
			}
			else {
				System.out.print("Invalid option\nselect option: ");
				userInput = scanner.nextLine();
			}
			System.out.println(player);			
		}
		return (player.getHandValue() > 21);
	}
	
	public boolean proccessDealerTurn() {
		System.out.println("Dealer Turn");
		while(dealer.getHandValue() < 17) {
			System.out.println("Dealer hit");
			hit(dealer);
			System.out.println(dealer);
		}
		
		return (dealer.getHandValue() > 21);
	}


	public int hit(Player player) {
		Card card = deck.dealCard();
		player.receiveCard(card);
		return player.getHandValue();
	}
	
	public void printResults(int results) {
		String message = "";
		switch(results) {
		case 0: message = "Draw";
			break;
		case -1: message = "Dealer wins";
			break;
		case 1: message = "Player wins";
			break;
		}
		
		System.out.println(message);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BlackJackGame game = new BlackJackGame(scanner);
		game.startGame();

		scanner.close();
	}

}
