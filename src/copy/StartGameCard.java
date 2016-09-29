package copy;

import java.io.IOException;

public interface StartGameCard {
	
	public void setPlayersNumber()throws IOException;
	public void setShortOrFullDeck() throws IOException;
	public void setPlayersName() throws IOException;
	public void createPlayersAndDevideDeck(String... args);
	public void playGame() throws IOException;

}
