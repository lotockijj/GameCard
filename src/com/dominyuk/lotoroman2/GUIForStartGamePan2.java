package com.dominyuk.lotoroman2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIForStartGamePan2 implements ActionListener, Observer{

	ModelTable model;
	Controller controller;
	
	JFrame frame;
	JPanel panel = new JPanel();
	JComboBox<Integer> cBoxPlayersNumber; 
	JTextField playersNames;
	JComboBox<Boolean> cBoxShortOrFullDeck;
	JLabel numberPlayer,  numberName, shortOrFullDeck;
	JButton setNumberPlayers, setName, setFullOrShortDeck, setData;

	private int nP;
	private DefaultListModel<String> pNames = new DefaultListModel<>();
	private String[] s;
	private boolean sOrFDeck;
	
	public GUIForStartGamePan2(ModelTable model, Controller controller) {
		this.model = model;
		this.controller = controller;
		model.registerObserver(this);
	}
	@Override
	public void update(int numberPlayers, String[] playersNames, boolean sOrFDeck) {
		System.out.println("GUI 2 is notifyed ******************");
	}

	public void createGuiForStartGame(){
		
		panel.setLayout(new FlowLayout());

		setNumberPlayers = new JButton(" Confirm number ");
		
		setName = new JButton("Confirm names");
		setFullOrShortDeck = new JButton(" Confirm  size ");

		cBoxPlayersNumber = new JComboBox<Integer>();
		playersNames = new JTextField("", 10);
		cBoxShortOrFullDeck = new JComboBox<>();

		for(int i = 2; i < 53; i++){
			cBoxPlayersNumber.addItem(i);
		}
		cBoxPlayersNumber.setSelectedIndex(0);

		cBoxShortOrFullDeck.addItem(true);
		cBoxShortOrFullDeck.addItem(false);

		numberPlayer = new JLabel(" Number  players     ");
		numberName = new JLabel("Set name");
		shortOrFullDeck = new JLabel("Short  or  full  deck");

		setData = new JButton("SET DATA");
		setData.setEnabled(false);
		playersNames.setEditable(false);
		setName.setEnabled(false);
		cBoxShortOrFullDeck.setEnabled(false);
		setFullOrShortDeck.setEnabled(false);

		setNumberPlayers.addActionListener(this);
		setName.addActionListener(this);
		setFullOrShortDeck.addActionListener(this);
		setData.addActionListener(this);

		panel.add(numberPlayer);
		panel.add(cBoxPlayersNumber);
		panel.add(setNumberPlayers);
		panel.add(numberName);
		panel.add(playersNames);
		panel.add(setName);
		panel.add(shortOrFullDeck);
		panel.add(cBoxShortOrFullDeck);
		panel.add(setFullOrShortDeck);
		panel.add(setData);

		frame = new JFrame("Set game");
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(360, 180);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == setNumberPlayers){
			playersNames.setEditable(true);
			setName.setEnabled(true);
			setNumberPlayers.setEnabled(false);
			cBoxPlayersNumber.setEnabled(false);
		}
		if(e.getSource() == setName){
			int numberNames = (int) cBoxPlayersNumber.getSelectedItem();
			if(!playersNames.getText().equals("")){
				cBoxPlayersNumber.setEnabled(false);
				pNames.add(0, playersNames.getText());
				playersNames.setText("");
				playersNames.requestFocusInWindow();
				if(numberNames == pNames.size()){
					setName.setEnabled(false);
					playersNames.setEnabled(false);
					cBoxShortOrFullDeck.setEnabled(true);
					setFullOrShortDeck.setEnabled(true);
				}
			}
		}
		
		if(e.getSource() == setFullOrShortDeck){
			setFullOrShortDeck.setEnabled(false);
			cBoxShortOrFullDeck.setEnabled(false);
			setData.setEnabled(true);
		}
		if(e.getSource() == setData){
			nP = (int) cBoxPlayersNumber.getSelectedItem();
			s = getpNames(); 
			sOrFDeck = (boolean) cBoxShortOrFullDeck.getSelectedItem();
			model.setStartData(nP, s, sOrFDeck);
			
			frame.dispose();
			new GUIForGame();
//			WindowEvent winClosingEvent = new WindowEvent( frame, WindowEvent.WINDOW_CLOSING );
//			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent( winClosingEvent );
//			setChanged();
//			notifyObservers();
//			try{
//				frame.setVisible(false);
//			} finally {
//			}
			//System.exit(0);
		}
	}
	
	public int getnP() {
		return nP;
	}

	public String[] getpNames() {
		s = new String[pNames.getSize()];
		for(int i = 0; i < pNames.size(); i++){
			s[i] = pNames.get(i);
		}
		return s;
	}

	public boolean getIssOrFDeck() {
		return sOrFDeck;
	}
}