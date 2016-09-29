package copy;

import java.util.Arrays;
import java.util.Comparator;

public class Card implements Comparable<Card>{
	private final String suit; 
	private final String rank; 

	public Card(String suit, String rank){
		this.suit = suit;
		this.rank = rank; 
	}
	public String getSuit(){
		return suit;
	}

	public String getRank(){
		return rank; 
	}
	
	@Override
	public int compareTo(Card c) {
		return Arrays.asList(Deck.rank).indexOf(this.rank) 
				- Arrays.asList(Deck.rank).indexOf(c.rank);
	}
	
	@Override
	public String toString() {
		return this.rank + " " + this.suit;
	}
	
	public static Comparator<Card> rankAndSuitComparator = new Comparator<Card>(){
		public int compare(Card o1, Card o2) {
			int flag = Arrays.asList(Deck.rank).indexOf(o1.getRank()) 
					- Arrays.asList(Deck.rank).indexOf(o2.getRank()); 
			if(flag == 0){ flag = Arrays.asList(Deck.suit).indexOf(o1.getSuit()) 
					- Arrays.asList(Deck.suit).indexOf(o2.getSuit());}
			return flag;
		}
	};
}

