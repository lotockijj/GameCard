package copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Table{
	
	int numberPlayers;
	String[] playersNames;
	boolean isShortDeck = true;
	
	LinkedList<Player> playersInGame = new LinkedList<Player>(); 
	int startPlayer; 
	int startCard;
	LinkedList<Card> cardsOnTable = new LinkedList<Card>(); 
	Deck cardDeck; 
	static int currentPlayer = 0; 
	Card startCardDependShortOrFullDeck = new Card(Deck.suit[2], Deck.rank[7]);
	StringBuilder result;
	
	ArrayList<Observer> observers;
	
	
	public Table(){
		observers  = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0){
			observers.remove(i);
		}
		
	}
	
	public void notifyObserver(){
		for(int i = 0; i < observers.size(); i++){
			Observer observer = (Observer) observers.get(i);
			observer.update(i, playersNames, isShortDeck);
		}
	}
	
	public void setStartData(int numberPlayers, String[] playersNames, boolean isShortDeck){
		this.numberPlayers = numberPlayers;
		this.playersNames = playersNames;
		this.isShortDeck = isShortDeck;
		displaySetData();
	}
	
	public void displaySetData(){
		for(int i = 0; i < playersNames.length; i++){
			System.out.print(playersNames[i] + ", ");
		}
			createPlayersAndDevideDeck(playersNames);
	}
	
	public void createPlayersAndDevideDeck(String... args){
		cardDeck = new Deck(isShortDeck);
		LinkedList<Card> tableCardDeck = cardDeck.shuffledSet;
		for(int i = 0; i < numberPlayers; i++){
			Player player = new Player(playersNames[i]);
			playersInGame.add(player);
		}
		while(true){
			Card s = tableCardDeck.poll();
			playersInGame.get(currentPlayer).cardsOnHands.add(s);
			currentPlayer = nextPlayer(currentPlayer); 
			if(tableCardDeck.size() == 0) break; 
		}
		for(int i = 0; i < playersInGame.size(); i++){
			Collections.sort(playersInGame.get(i).cardsOnHands, Card.rankAndSuitComparator);
		}
		searchStartCardWithRankHearts();
	} 
	
	public void searchStartCardWithRankHearts(){ // in class Deck I commented method shuffle in order to simplify further develop. 
		if(!isShortDeck){
			startCardDependShortOrFullDeck = new Card(Deck.suit[2], Deck.rank[0]);
		}
		for(int i = 0; i < playersInGame.size(); i++){ // in this method I try to find place start card(9 or 2 Hearts). 
			for(int j = 0; j < playersInGame.get(i).cardsOnHands.size(); j++){
				if(playersInGame.get(i).cardsOnHands.get(j).getRank() 
						== startCardDependShortOrFullDeck.getRank() 
						&& playersInGame.get(i).cardsOnHands.get(j).getSuit() 
						== startCardDependShortOrFullDeck.getSuit()){
					currentPlayer = i; 
					startCard = j;
				}
			}
		}
		takeCardFromPlayer(currentPlayer, startCard);
		//playGame();
	}
	
	public void takeCardFromPlayer(int playerNumber, int cardPosition){
		cardsOnTable.add(playersInGame.get(playerNumber).cardsOnHands.get(cardPosition)); 
		playersInGame.get(playerNumber).cardsOnHands.remove(cardPosition);
	}

	public int nextPlayer(int currentPlayerId){
		return (currentPlayerId == playersInGame.size() - 1) // if we have last player's step in p(our array that hold players), we give step to first player.   
				?  0 : ++currentPlayerId;
	}

	void takeCardFromTable(int playerNumber){
		playersInGame.get(playerNumber).cardsOnHands.add(cardsOnTable.getLast()); 
		cardsOnTable.removeLast(); 
	}

	public void checkIfPlayersHaveCard(){
		for(int i = 0; i < playersInGame.size(); i++){ // if player already haven't card, we remove him from game. 
			if(playersInGame.get(i).cardsOnHands.isEmpty()){
				playersInGame.remove(i);
				currentPlayer--;
			}
		}
	}
	
	public boolean checkIfItIsTheLastPlayer(){
		boolean ifItIsTheLastPlayer = false;
		if(playersInGame.size() == 1){ // when we have only one player with card, game just have finished, p.get(0) lost(defeated). 
			ifItIsTheLastPlayer = true;
		}
		return ifItIsTheLastPlayer;
	}

	public LinkedList<Card> getCardsOnTable() {
		return cardsOnTable;
	}

	public LinkedList<Player> getPlayerInGame() {
		return playersInGame;
	}

}



