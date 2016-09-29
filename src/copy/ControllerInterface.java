package copy;

import java.util.ArrayList;

public interface ControllerInterface {
	
	void start();
	void takeCards();
	void putCards();
	void setBPM(ArrayList<Card> cards);

}
