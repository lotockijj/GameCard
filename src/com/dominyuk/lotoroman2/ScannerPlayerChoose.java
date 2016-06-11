package com.dominyuk.lotoroman2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScannerPlayerChoose {

	public int getPlayerChoose() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
		String s1 = reader.readLine();
		Integer i = Integer.valueOf(s1);
		return i; 
	}
}
