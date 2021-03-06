package com.dominyuk.lotoroman2;

import java.io.IOException;

public interface ModelTable {
	
	public void setStartData(int numberPlayers, String[] playersNames, boolean isShortDeck);
	public void createPlayersAndDevideDeck(String... args) throws IOException;
	public void playGame() throws IOException;
	public int getPlayerChoose() throws IOException;
	public String getPlayerNameChoose() throws IOException;
	
	void notifyObserver();
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	
}
