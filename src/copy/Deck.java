package copy;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {  
	public static final String[] suit = {"Spades", "Clubs", "Hearts", "Diamonds"};
	public static final String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Ace"};
	LinkedList<Card> shuffledSet = new LinkedList<>();

	public Deck(boolean isShortDeck) {
			createDeck(isShortDeck);
			Collections.shuffle(shuffledSet);
	}

	public  LinkedList<Card> createDeck(boolean isShortDeck){
		int lowestCardIndex = 0; 
		if(isShortDeck){
			lowestCardIndex = 7; 
		}
		for(int i = 0; i < suit.length; i++){
			for(int j = lowestCardIndex; j < rank.length; j++){
				Card c = new Card(suit[i], rank[j]); 
				shuffledSet.add(c);
				//System.out.println(c.getRank() + " " + c.getSuit());
			}
		}
		return shuffledSet; 
	}
}
