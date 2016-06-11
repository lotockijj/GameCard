package com.dominyuk.lotoroman2;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable{
	public final String name; 
	List<Card> cardsOnHands = new ArrayList<>();
	
	public Player(String name){
		this.name = name; 
	}
	@Override
	public int compareTo(Object o) {
		
		return 0;
	}
}
