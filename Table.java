package GamePromt2;

import java.util.ArrayList;
import java.util.Random;

public class Table {
	
	public ArrayList<Card> t;
	public Card s;
	int numberPlayers = 2;  
	
	public void devidePlayers(){
		Deck d = new Deck(); 
		t = d.createShortDeck();
		//System.out.println(t.size());
	}

	public Card getMyCard(){
		Random r = new Random(); 
		int randomInt = r.nextInt(t.size());
		s = t.get(randomInt);
		//System.out.println(s.rank + " " + s.suit);
		t.remove(randomInt);
		//System.out.println(t.get(randomInt).rank + t.get(randomInt).suit);
		return s;
	}
}
	

