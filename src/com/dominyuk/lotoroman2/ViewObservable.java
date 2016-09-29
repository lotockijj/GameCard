package com.dominyuk.lotoroman2;

public interface ViewObservable {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
}
