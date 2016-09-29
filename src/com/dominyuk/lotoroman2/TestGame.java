package com.dominyuk.lotoroman2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestGame extends Thread{
	
	public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException {
		
		ModelTable table = new Table();
		ControllerInterface controller = new Controller(table);
	}
}
