package com.dominyuk.lotoroman2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIForGame implements ActionListener, com.dominyuk.lotoroman2.Observer{

	ViewObservable viewObservable;
	ModelTable model;
	
	JFrame frame1;
	JPanel panel;
	public JButton button0, button1, button2, button3, button4, button5;
	public JTextField displayFieldForTableCard, displayFieldForPlayerCard;
	Label label1, label2;
	Table table;

	public GUIForGame(){ 
		createGUIForGame();
	}
	public GUIForGame(ViewObservable viewObservable){
		this.viewObservable = viewObservable;
		viewObservable.registerObserver(this);
		System.out.println("I'm in constractor GUI for game==========");
	}
	@Override
	public void update(int numberPlayers, String[] playersNames, boolean sOrFDeck) {
			System.out.println("I'm notifyed ***************************************************");
			System.out.println("GUI for game is activate... ");
			createGUIForGame();
	}
	
	public void createGUIForGame(){
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		label1 = new Label("Card on table");
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 7;
		c.anchor = c.LINE_START;
		panel.add(label1, c);

		displayFieldForTableCard = new JTextField("");
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 7;
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = c.LINE_START;
		c.insets = new Insets(5, 5, 5, 5);
		panel.add(displayFieldForTableCard, c);

		label2 = new Label("Player's cards. ");
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 7;
		c.anchor = c.LINE_START;
		panel.add(label2, c);

		displayFieldForPlayerCard = new JTextField("");
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 7;
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = c.LINE_START;
		c.insets = new Insets(5, 5, 5, 5);
		panel.add(displayFieldForPlayerCard, c);

		button0 = new JButton("0");
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = c.ABOVE_BASELINE_LEADING;
		panel.add(button0, c);

		button1 = new JButton("1");
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		panel.add(button1, c);

		button2 = new JButton("2");
		c.gridx = 2;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		panel.add(button2, c);


		button3 = new JButton("3");
		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		panel.add(button3, c);

		button4 = new JButton("4");
		c.gridx = 4;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		panel.add(button4, c);

		button5 = new JButton("5");
		c.gridx = 5;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		panel.add(button5, c);

		button0.addActionListener(this);


		frame1 = new JFrame("Game PAN :) ");
		frame1.setContentPane(panel);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.pack();
		frame1.setSize(700, 400);
		frame1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button0){
			displayFieldForTableCard.setText(table.result.toString());
		}
	}

}
