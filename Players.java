package GamePromt2;

import java.util.ArrayList;

public class Players {
	ArrayList<Card> fullMixCard = new ArrayList<Card>();
	ArrayList<Card> player1 = new ArrayList<Card>();
	ArrayList<Card> player2 = new ArrayList<Card>();
	
	int numberPlayers = 2; 
	
	public void giveCardPlayers(){
		Card s1;  
		Player1 test = new Player1(); 
		fullMixCard = test.createMixDeck();
		if(numberPlayers == 1){
			System.out.println("Wrong number. Number must be egaul or greater than 2");
		}
		if(numberPlayers == 2){
			for(int i = 0; i < 24; i++){
				s1 = fullMixCard.get(i);
				if(i < 12){
					player1.add(s1);
					//System.out.println(player1.get(i).rank + " " + player1.get(i).suit);
				}  else {
					player2.add(s1); 
					//System.out.println(player2.get(i).rank + " " + player2.get(i).suit);
				} 
			}
		}
	}
}
