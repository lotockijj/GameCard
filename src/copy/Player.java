package copy;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Object>{
	
	public final String name; 
	
	List<Card> cardsOnHands = new ArrayList<>();
	
	public Player(String name){
		this.name = name; 
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	@Override
	public String toString(){
		StringBuilder allCards = new StringBuilder();
		for(int i = 0; i < cardsOnHands.size(); i++){
			allCards.append(cardsOnHands.get(i) + ", ");
		}
		return allCards.toString();
		
	}
}
