package com.dominyuk.lotoroman2;

import java.io.IOException;
import java.util.ArrayList;

public class Controller implements ControllerInterface {

	ModelTable model;
	GUIForStartGamePan2 gui;
	
	public Controller(ModelTable model) {
		this.model = model;
		gui = new GUIForStartGamePan2(model, this);
		gui.createGuiForStartGame();
		try {
			model.playGame();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e){
			
		}
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBPM(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
	}


}
