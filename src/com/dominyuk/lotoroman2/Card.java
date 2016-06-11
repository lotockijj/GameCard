package com.dominyuk.lotoroman2;

import java.util.Arrays;

public class Card implements Comparable<Card>{
	private final String suit; 
	private final String rank; 
	
	public Card(String suit, String rank){
		this.suit = suit;
		this.rank = rank; 
	}
	public String getSuit(){
		return suit;
	}
	
	public String getRank(){
		return rank; 
	}
	@Override
	public int compareTo(Card c) {
		return Arrays.asList(Deck.rank).indexOf(this.rank) 
				- Arrays.asList(Deck.rank).indexOf(c.rank);
	}
	@Override
	public String toString() {
		return this.rank + " " + this.suit;
	}
}
