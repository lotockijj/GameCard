package copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

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

				if(e.getSource() == view.getButton0()){
					for(int i = 0; i < model.playersInGame.get(Table.currentPlayer).cardsOnHands.size(); i++){
						if(model.playersInGame.get(Table.currentPlayer).cardsOnHands.get(i).getRank() 
								== model.cardsOnTable.getLast().getRank()){ //it concerns only first step.
							model.takeCardFromPlayer(Table.currentPlayer, i);
							i--; // !!! 
						}
					}
					nextStep();
					view.getButton0().setEnabled(false);
				}

				if(e.getSource() == view.getButton1()){
					for(int i = 0; i < model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.size(); i++){
						if(model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i) 
								== view.getJComboBox().getSelectedItem() 
								&& ((Card)view.getJComboBox().getSelectedItem()).compareTo(model.cardsOnTable.getLast()) >= 0){
							model.takeCardFromPlayer(Table.currentPlayer, i);
							nextStep();
						}
					}
				}

				if(e.getSource() == view.getButton2()){
					boolean iMadeStep = false;
					for(int i = 0; i < model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.size(); i++){
						if(model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i).getRank() 
								== view.getJComboBoxBunch().getSelectedItem() 
								&& model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i).compareTo(model.cardsOnTable.getLast()) >= 0){
							model.takeCardFromPlayer(Table.currentPlayer, i);
							iMadeStep = true;
							i--;
						}
					}
					if(iMadeStep){
						nextStep();
					}
				}

				if(e.getSource() == view.getButton3()){
					for(int i = 0; i < (int)view.getJComboBoxTakeCards().getSelectedItem(); i++){
						model.takeCardFromTable(Table.currentPlayer);
					}
					nextStep();
				}

			}
		};
		view.getButton0().addActionListener(actionListener);
		view.getButton1().addActionListener(actionListener);
		view.getButton2().addActionListener(actionListener);
		view.getButton3().addActionListener(actionListener);
	}

	private void nextStep(){
		view.setTextJTextFieldForPlayersCards(model.getPlayerInGame().get(Table.currentPlayer).toString());//label1.setText(nameField.getText()
		view.setTextJTextFieldForCardsOnTable(model.getCardsOnTable().toString());
		view.getJComboBox().removeAllItems();
		view.getJComboBoxTakeCards().removeAllItems();
		view.getJComboBoxBunch().removeAllItems();
		Collections.sort(model.playersInGame.get(Table.currentPlayer).cardsOnHands,
				Card.rankAndSuitComparator);
		model.checkIfPlayersHaveCard();
		Table.currentPlayer = model.nextPlayer(Table.currentPlayer);
		view.setTextJTextFieldForPlayersCards(model.getPlayerInGame().get(Table.currentPlayer).toString());//label1.setText(nameField.getText()
		view.setTextJTextFieldForCardsOnTable(model.getCardsOnTable().toString());
		view.setTextJComboBox(model.getPlayerInGame().get(Table.currentPlayer));
		setNumberTakeCard();
		setNumberBunchPlayerHave();
		endingGame();
	}

	private void setNumberTakeCard(){
		if(model.getCardsOnTable().size() >= 2){
			if(model.getCardsOnTable().size() == 2){
				view.setNumberJComboBoxTakeCards(1);
			} else if(model.getCardsOnTable().size() == 3){
				view.setNumberJComboBoxTakeCards(2);
			} else {
				for(int i = 3; i <= model.getCardsOnTable().size() - 1; i++){
					view.setNumberJComboBoxTakeCards(i);
				}
			}
		}
	}

	private void setNumberBunchPlayerHave(){
		for(int i = 0; i < model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.size() - 3; i++){
			if(     model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i    ).getRank() ==  
					model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i + 1).getRank() &&
					model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i + 1).getRank() ==
					model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i + 2).getRank() &&
					model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i + 2).getRank() ==
					model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i + 3).getRank()){
				view.setTextJComboBoxBunch(model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i).getRank());
			}
			if(model.cardsOnTable.size() == 1 && 
					model.cardsOnTable.getLast().getRank() == 
					model.getPlayerInGame().get(Table.currentPlayer).cardsOnHands.get(i).getRank() && 
					model.cardsOnTable.getLast().getRank() != view.getJComboBoxBunch().getSelectedItem()){
				view.setTextJComboBoxBunch(model.cardsOnTable.getLast().getRank());
			}
		}
	}

	private void endingGame(){
		boolean itIsEnd = model.checkIfItIsTheLastPlayer();
		if(itIsEnd){
			//Swith JOptionPane "Player lost".
			view.setTextJTextFieldForCardsOnTable("Player - " + model.getPlayerInGame().getLast().name + " LOST!" );
			view.setTheEndGame(model.getPlayerInGame().getLast().name);
		}
	}
}



