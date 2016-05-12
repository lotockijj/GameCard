package GamePromt2;

public class TestDeckCard {

	public static void main(String[] args) {
		Players test = new Players(); 
		test.giveCardPlayers();
		Card s; 
		for(int i = 0; i < test.player1.size(); i++){
			s = test.player1.get(i);
			System.out.println(s.rank + " " + s.suit);
		}
		System.out.println();
		for(int i = 0; i < test.player1.size(); i++){
			s = test.player2.get(i);
			System.out.println(s.rank + " " + s.suit);
		}
	}
}
