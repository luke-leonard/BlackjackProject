package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame implements Game {
	
	// F I E L D S
	private Dealer dealer;
	private List<Player> players;
	private Deck drawPile;
	private Deck discardPile;
	
	// C O N S T R U C T O R S
	public BlackJackGame() {
		super();
	}
	// M E T H O D S
	
	private void reset() {
		BlackJackDealerPlayer dealer = new BlackJackDealerPlayer("No-nonsense Dealer Man", 1_000_000_000);
		this.dealer = dealer;
		this.players = new ArrayList<>();
		
		//Add human players
		int numberOfPlayers = 0;
		while(true) {
			System.out.print("How many human players:");
			String number = CasinoApp.input.nextLine();
			try {
				numberOfPlayers = Integer.parseInt(number);
				if(numberOfPlayers > 4 || numberOfPlayers <= 0) {
					System.out.println("Lets pick a reasonable number.");
				}else {
					break;					
				}
			}catch(NumberFormatException e) {
				System.out.println("That is not a number.");
			}
		}
		for(int i = 0; i < numberOfPlayers; i++) {
			System.out.print("Player " + (i + 1) + "\'s name:");
			String name = CasinoApp.input.nextLine();
			this.players.add(new BlackJackHumanPlayer(name,1000));
		}
		
		//add cpu players
		String[] possibleNames = {"Grumpy Gus" , "Stalky Larry", "Robert(A.K.A. Bob)","Lady Gaga"};
		while(true) {
			System.out.print("How many CPU players:");
			String number = CasinoApp.input.nextLine();
			try {
				numberOfPlayers = Integer.parseInt(number);
				if(numberOfPlayers > 4 || numberOfPlayers < 0) {
					System.out.println("Lets pick a reasonable number.");
				}else {
					break;					
				}
			}catch(NumberFormatException e) {
				System.out.println("That is not a number.");
			}
		}
		for(int i = 0; i < numberOfPlayers; i++) {
			this.players.add(new BlackJackCPUPlayer(possibleNames[i],1000));
			System.out.println(possibleNames[i] + " has joined the game.");
		}
		System.out.println(dealer.getName() + " has joined the game.");
		System.out.println();

		this.players.add(dealer);
		
		DeckBuilder db = new DeckBuilder();
		this.drawPile = db.build52CardBlackJackDeck();
		this.drawPile.shuffle();
		this.discardPile = db.buildEmptyDiscardPile();
	}

	@Override
	public void play() {
		System.out.println("Let's Play BlackJack");
		reset();
		while(true) {
			playRound();
			System.out.println("Play Again(y or n)");
			String userInput = CasinoApp.input.nextLine();
			if(userInput.equalsIgnoreCase("n")) {
				break;
			}
		}
				
	}
	
	public int numberOfPlayers() {
		return players.size();
	}
	
	public void playRound() {
		if(numberOfPlayers() * 5 > drawPile.getDeckSize()) {
			dealer.reshuffle(drawPile, discardPile);
		}
		System.out.println("Lets deal the cards");
		dealer.deal(players,drawPile);
		printTable();
		boolean blackJack = false;
		for(int i = 0; i < players.size()-1;i++) {
			if(players.get(i).getValue() == 21) {
				System.out.println(players.get(i).getName() + " has BlackJack");
				blackJack = true;
			}
		}
		if(!blackJack) {
			boolean allBusted = true;
			for(int i = 0; i < players.size()-1;i++) {
				System.out.println();
				System.out.println(players.get(i).getName() + "\'s turn");

				players.get(i).playTurn(drawPile);
				if(players.get(i).getValue() != -1) {
					allBusted = false;
				}
			}
			if(!allBusted) {
				players.get(players.size()-1).playTurn(drawPile);
			}
		}else {
			players.get(players.size()-1).getHands().get(0).showHand();
		}
		getWinner();
	}
	
	public void getWinner() {
		int dealerScore = players.get(players.size()-1).getValue();
		if(dealerScore == -1) {
			for(Player player: players) {
				if(player.getValue()!= -1 ) {
					System.out.println(player.getName() + " won!");
				}else {
					System.out.println(player.getName() + " lost!");

				}
				discardPile.returnCards(player.getHands().get(0).discardHand());
			}
		}else {
			for(Player player: players) {
				if(player.getValue() > dealerScore ) {
					System.out.println(player.getName() + " won!");
				}else if(player.getValue() == dealerScore ) {
					if(!player.equals(players.get(players.size()-1))) {
						System.out.println(player.getName() + " tied!");
					}
				}else {
					System.out.println(player.getName() + " lost!");
				}
				discardPile.returnCards(player.getHands().get(0).discardHand());
			}
		}
		
	}

	@Override
	public String toString() {
		return "BlackJack Game";
	}
	
	public void printTable() {
		for(Player player: players) {
			System.out.println(player);
		}
	}
	
	
	
	
	
}
