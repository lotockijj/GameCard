package copy;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.scene.text.Font;

public class View {
    
    private JFrame frame;
    JPanel panel;
    private JButton button0, button1, button2, button3, button4, button5, button01;
    private JLabel label1, label2;
    private JTextArea displayFieldForTableCard, displayFieldForPlayerCard;
    private JComboBox<Card> cardsForPut;
    private JComboBox<String> bunchForPut;
    private JComboBox<Integer> numberTakeCard; 

    public View(String text){
    	panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		label1 = new JLabel("Table's cards. ");
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 7;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = c.ABOVE_BASELINE;
		panel.add(label1, c);

		displayFieldForTableCard = new JTextArea("");
		displayFieldForTableCard.setLineWrap(true);
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
		
		label2 = new JLabel("Player's cards. ");
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 7;
		c.anchor = c.LINE_START;
		panel.add(label2, c);
		
		displayFieldForPlayerCard = new JTextArea("");
		displayFieldForPlayerCard.setLineWrap(true);
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

		button0 = new JButton("Start game.");
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = c.ABOVE_BASELINE_LEADING;
		panel.add(button0, c);

		button1 = new JButton("Put card");
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		panel.add(button1, c);

		button2 = new JButton("Put bunch");
		c.gridx = 2;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1; 
		panel.add(button2, c);


		button3 = new JButton("Take card");
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
		
		button01 = new JButton("new");
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		panel.add(button01, c);
		
		cardsForPut = new JComboBox<>();
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		panel.add(cardsForPut, c);
		
		bunchForPut = new JComboBox<>();
		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		panel.add(bunchForPut, c);
    	
		numberTakeCard = new JComboBox<>();
		c.gridx = 3;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		panel.add(numberTakeCard, c);
		
		frame = new JFrame("Game PAN :) ");
        frame.setContentPane(panel);                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack();
        frame.setSize(700, 400);        
        frame.setVisible(true);
        
    }
        
    public JButton getButton0(){
        return button0;
    }
    public JButton getButton1(){
    	return button1;
    }
    public JButton getButton2(){
    	return button2;
    }
    public JButton getButton3(){
    	return button3;
    }
    public JComboBox<Card> getJComboBox(){
    	return cardsForPut;
    }
    public JComboBox<String> getJComboBoxBunch(){
    	return bunchForPut;
    }
    public JComboBox<Integer> getJComboBoxTakeCards(){
    	return numberTakeCard;
    }
    
    public void setTextJTextFieldForPlayersCards(String text){
    	displayFieldForPlayerCard.setText(text);
    }
    
    public void setTextJTextFieldForCardsOnTable(String text){
    	displayFieldForTableCard.setText(text);
    }
    public void setTextJComboBox(Player player){
    	for(int i = 0; i < player.cardsOnHands.size(); i++){
    		cardsForPut.addItem(player.cardsOnHands.get(i));
    	}
    }
    public void setTextJComboBoxBunch(String text){
    	bunchForPut.addItem(text);
    }
    public void setNumberJComboBoxTakeCards(Integer number){
    	numberTakeCard.addItem(number);
    }
    
}