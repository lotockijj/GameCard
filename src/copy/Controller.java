package copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;
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
					for(int i = 0; i < model.playersInGame.get(model.currentPlayer).cardsOnHands.size(); i++){
						if(model.playersInGame.get(model.currentPlayer).cardsOnHands.get(i).getRank() 
								== model.cardsOnTable.getLast().getRank()){ //it concerns only first step.
							model.takeCardFromPlayer(model.currentPlayer, i);
							i--; // !!! 
						}
					}
					nextStep();
					view.getButton0().setEnabled(false);
				}

				if(e.getSource() == view.getButton1()){
					for(int i = 0; i < model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.size(); i++){
						if(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i) 
								== view.getJComboBox().getSelectedItem() 
								&& ((Card)view.getJComboBox().getSelectedItem()).compareTo(model.cardsOnTable.getLast()) >= 0){
							model.takeCardFromPlayer(model.currentPlayer, i);
							nextStep();
						}
					}
				}

				if(e.getSource() == view.getButton2()){
					for(int i = 0; i < model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.size(); i++){
						System.out.print("i is " + i + " ");
						System.out.print(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i).getRank());
						System.out.print(view.getJComboBoxBunch().getSelectedItem() + "\n");
						System.out.println(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i).getRank() 
								== view.getJComboBoxBunch().getSelectedItem());
						if(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i).getRank() 
								== view.getJComboBoxBunch().getSelectedItem() 
								&& ((Card)view.getJComboBox().getSelectedItem()).compareTo(model.cardsOnTable.getLast()) >= 0){
							System.out.println("I'm inside take card from player.................");
							model.takeCardFromPlayer(model.currentPlayer, i);
							i--;
						}
					}
					nextStep();
				}

				if(e.getSource() == view.getButton3()){
					for(int i = 0; i < (int)view.getJComboBoxTakeCards().getSelectedItem(); i++){
						model.takeCardFromTable(model.currentPlayer);
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
		view.setTextJTextFieldForPlayersCards(model.getPlayerInGame().get(model.currentPlayer).toString());//label1.setText(nameField.getText()
		view.setTextJTextFieldForCardsOnTable(model.getCardsOnTable().toString());
		view.getJComboBox().removeAllItems();
		view.getJComboBoxTakeCards().removeAllItems();
		view.getJComboBoxBunch().removeAllItems();
		Collections.sort(model.playersInGame.get(model.currentPlayer).cardsOnHands,
				Card.rankAndSuitComparator);
		model.currentPlayer = model.nextPlayer(model.currentPlayer);
		view.setTextJTextFieldForPlayersCards(model.getPlayerInGame().get(model.currentPlayer).toString());//label1.setText(nameField.getText()
		view.setTextJTextFieldForCardsOnTable(model.getCardsOnTable().toString());
		view.setTextJComboBox(model.getPlayerInGame().get(model.currentPlayer));
		setNumberTakeCard();
		setNumberBunchPlayerHave();
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
		for(int i = 0; i < model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.size() - 3; i++){
			if(     model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i    ).getRank() == 
					model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i + 1).getRank() &&
					model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i + 1).getRank() ==
					model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i + 2).getRank() &&
					model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i + 2).getRank() ==
					model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i + 3).getRank()){
				view.setTextJComboBoxBunch(model.getPlayerInGame().get(model.currentPlayer).cardsOnHands.get(i).getRank());
			}
		}
	}

}