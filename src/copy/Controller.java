package copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {

	private Table model;
	private View view;
	private ActionListener actionListener;

	public Controller(Table model, View view){
		this.model = model;
		this.view = view;
	}

	public void contol(){        
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for(int i = 0; i < model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.size() - 1; i++){
					int bunchOfCards = 0;
					if(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i) ==
							model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i+1)){
						bunchOfCards++;
						if(bunchOfCards == 4){
							view.setTextJComboBoxBunch(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i).getRank());
							bunchOfCards = 0;
						}
					}
				}

				if(e.getSource() == view.getButton0()){
					for(int i = 0; i < model.playersInGame.get(model.currentPlayer).cardsOnHands.size(); i++){
						if(model.playersInGame.get(model.currentPlayer).cardsOnHands.get(i).getRank() 
								== model.cardsOnTable.getLast().getRank()){ //it concerns only first step.
							model.takeCardFromPlayer(model.currentPlayer, i);
							i--; // !!! 
						}
					}
					model.currentPlayer = model.nextPlayer(model.currentPlayer);
					view.setTextJTextFieldForPlayersCards(model.getPlayerInGame().get(model.currentPlayer).toString());//label1.setText(nameField.getText()
					view.setTextJTextFieldForCardsOnTable(model.getCardsOnTable().toString());
					view.setTextJComboBox(model.getPlayerInGame().get(model.currentPlayer));
					view.getButton0().setEnabled(false);
				}
				if(e.getSource() == view.getButton1()){
					for(int i = 0; i < model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.size(); i++){
						if(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i) 
								== view.getJComboBox().getSelectedItem() 
								&& ((Card)view.getJComboBox().getSelectedItem()).compareTo(model.cardsOnTable.getLast()) >= 0){
							model.takeCardFromPlayer(model.currentPlayer, i);
							model.currentPlayer = model.nextPlayer(model.currentPlayer);
							view.setTextJTextFieldForPlayersCards(model.getPlayerInGame().get(model.currentPlayer).toString());//label1.setText(nameField.getText()
							view.setTextJTextFieldForCardsOnTable(model.getCardsOnTable().toString());

							view.getJComboBox().removeAllItems();
							view.getJComboBoxTakeCards().removeAllItems();

							view.setTextJComboBox(model.getPlayerInGame().get(model.currentPlayer));
						}
					}
				}
				if(e.getSource() == view.getButton2()){
					System.out.println("I'm button PUT BUNCH!!!");
					for(int i = 0; i < model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.size(); i++){
						if(view.getJComboBoxBunch().getSelectedItem() == 
								model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i).getRank()){
							model.takeCardFromPlayer(model.currentPlayer, i);
						}
					}
				}
				if(e.getSource() == view.getButton3()){
					System.out.println("I'm button3 - TAKE CARDS! ");

				}
				System.out.println("Size - " + model.getCardsOnTable().size());
				if(model.getCardsOnTable().size() >= 2){
					if(model.getCardsOnTable().size() == 2){
						view.setNumberJComboBoxTakeCards(1);
					} else if(model.getCardsOnTable().size() == 3){
						view.setNumberJComboBoxTakeCards(1); view.setNumberJComboBoxTakeCards(2);
					} else {
						for(int i = 3; i <= model.getCardsOnTable().size() - 1; i++){
							view.setNumberJComboBoxTakeCards(i);
						}
					}
				}
			}
		};                
		view.getButton0().addActionListener(actionListener);
		view.getButton1().addActionListener(actionListener);
		view.getButton2().addActionListener(actionListener);
		view.getButton3().addActionListener(actionListener);
	}

}