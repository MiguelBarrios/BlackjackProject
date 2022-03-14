package com.skilldistillery.cards.blackjack;
import java.util.Scanner;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class BlackJackGame {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BlackJackGame game = new BlackJackGame(scanner);
		game.startGame();

		scanner.close();
//		Deck d = new Deck(1);
//		System.out.println(d.checkDeckSize());
	}

	private Scanner scanner;

	private Player player;

	private Player dealer;

	private Deck deck;

	public BlackJackGame(Scanner scanner) {
		this.scanner = scanner;
		player = new Player("Player");
		dealer = new Dealer("Dealer");
		deck = new Deck(1);
	}
	
	public void startGame() {
		String userInput = "1";
		while(userInput.equals("1")) {
			int results = runGameCycle();
			printResults(results);
			clearTable();

			System.out.print("enter 1 to play again, enter anything else to quit: ");
			userInput = scanner.nextLine().trim();
			System.out.println("\n\n");
		}
		System.out.println("\nGoodbye");
	}
	
	private void clearTable() {
		player.clearHand();
		dealer.clearHand();
	}
	
	public void showTable() {
		System.out.println("# Table");
		System.out.println(player);
		System.out.println(dealer);
	}

	// return 1 if player won
	// return -1 if player lost
	// return 0 if draw
	// return 2 if player won by blackjack
	// return -2 if dealer won by blackjack
	public int runGameCycle() {
		dealNewHand(player);
		dealNewHand(dealer);
		showTable();
		
		// Eval if black jack has occurred
		if(player.getHandValue() == 21 && dealer.getHandValue() == 21) {
			return 0;
		}
		else if(player.getHandValue() == 21) {
			return 2;
		}
		else if(dealer.getHandValue() == 21) {
			return -2;
		}
		
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
	
	public void dealNewHand(Player player) {
		deck.dealCards(2, player);
	}

	// return true if player bust
	public boolean proccessPlayerTurn() {
		boolean exit = false;
		while(!exit) {
			System.out.print("\nPlayers turn. Press 1 to hit or 2 to stay: "); 
			String userInput = scanner.nextLine().trim();
			if(userInput.equals("1")) {
				int handValue = hit(player);
				System.out.println(player);
				if(handValue > 21)
					exit = true;
			}
			else if(userInput.equals("2")) {
				exit = true;
			}
			else {
				showTable();
				System.out.print("Invalid option. ");
			}
		}
		return (player.getHandValue() > 21);
	}
	
	public boolean proccessDealerTurn() {
		System.out.println("\nDealer Turn");
		System.out.println(dealer);
		
		while(dealer.getHandValue() < 17) {
			System.out.println("Dealer will hit");
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
		case 2: message = "Player won by BlackJack!";
			break;
		case -2: message = "Dealer won by BlackJack";
			break;
		}
		
		System.out.println("\nResults: " + message);
		System.out.println(player);
		System.out.println(dealer);
	}
}
