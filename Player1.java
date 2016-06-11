package GamePromt2;

import java.util.ArrayList;

public class Player1 {
	ArrayList<Card> p = new ArrayList<Card>(); 
	int numberCardTake = 24;
	
	public ArrayList<Card> createMixDeck(){
		Table test = new Table();
		test.devidePlayers();
		 
		for(int i = 0; i < numberCardTake; i++){ 
			p.add(test.getMyCard());
		}
		// My test ->
		/*for(int i = 0; i < numberCardTake; i++){
			Card s = p.get(i); 
			System.out.println(s.rank + " " +  s.suit);	
		}
		*/
		return p; 
	}
}
