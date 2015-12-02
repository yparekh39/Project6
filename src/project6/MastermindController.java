package project6;

import java.util.HashSet;
import java.util.Scanner;

public class MastermindController {
	
	/* Sets the correct answer given input from the user (AI or Player)
	 */
	public void setAnswer(PegCombination answer){
		MastermindModel.answer = answer;
	}
	
	/* Takes a guess from the user (AI or Player) and updates the turn within the model with that guess and the 
	 * corresponding peg response.
	 * Then it returns a peg response to the user based on the accuracy of the guess.
	 * The peg response at first mirrors the answer, so that pegs in the answer that are also in the guess
	 * (whether position is correct or not) are marked in the peg response and thus not compared a second time against 
	 * other pegs in the guess.
	 * After the pegs in the guess have all been checked against the answer, the pegs are added into a final peg response
	 * in the order BLACK, WHITE, NONE.
	 * Ex: The accuracy check is BLACK NONE NONE WHITE. The final peg response is BLACK WHITE NONE NONE.
	 */
	public PegResponse guess(PegCombination attemptCombo){
		int guessIndex = 0;
		int blackPegCount = 0; //used for win checking
		PegColors[] attempt = attemptCombo.pegs;
		PegColors[] answer = MastermindModel.answer.pegs;
		//create default peg response (ie all clear pegs)
		PegResponseColors[] resultPegs = new PegResponseColors[4];
		for(int j = 0; j < 4; j++){ resultPegs[j] = PegResponseColors.NONE; }
		
		//check accuracy of guess
		while(guessIndex < 4){
			int answerIndex = 0;
			//check if peg at guessIndex is in correct position
			//if it is, mark that answer position in response as accounted for (ie black)
			if(resultPegs[guessIndex] == PegResponseColors.NONE && attempt[guessIndex] == answer[guessIndex]){
				resultPegs[guessIndex] = PegResponseColors.BLACK;
				blackPegCount++;
			}
			//check rest of answer to see if peg at guessIndex is correct color
			//if it is, mark that answer position in response as accounted for (ie white)
			else{
				while(answerIndex < 4){
					if(attempt[guessIndex] == answer[answerIndex]){
						if(resultPegs[answerIndex] == PegResponseColors.NONE){
							resultPegs[answerIndex] = PegResponseColors.WHITE;
							break; //exit loop, (we have accounted for this guess)
						}
							
					}
					answerIndex++;
				}
			}
			guessIndex++;
		}
		
		
		//add resultPegs[] to finalResultPegs[] in order of BLACK, WHITE, NONE
		PegResponseColors[] finalResultPegs = new PegResponseColors[4];
		int j = 0;
		while(j < 4){
			for(int i = 0; i < 4; i++){
				if(resultPegs[i] == PegResponseColors.BLACK){
					finalResultPegs[j] = PegResponseColors.BLACK;
					j++;
				}	
			}
			for(int i = 0; i < 4; i++){
				if(resultPegs[i] == PegResponseColors.WHITE){
					finalResultPegs[j] = PegResponseColors.WHITE;
					j++;
				}	
			}
			for(int i = 0; i < 4; i++){
				if(resultPegs[i] == PegResponseColors.NONE){
					finalResultPegs[j] = PegResponseColors.NONE;
					j++;
				}
			}
		}
		
		//set up final peg response
		PegResponse result = new PegResponse(finalResultPegs);
		
		//update the model
		MastermindModel.GameState[MastermindModel.currentTurn].guessThisTurn = attemptCombo;
		MastermindModel.GameState[MastermindModel.currentTurn].pegResponseThisTurn = result;
		MastermindModel.currentTurn++;
		
		//is game over?
		if(MastermindModel.currentTurn == 12 || blackPegCount == 4 ){
			//end game code
		}
		
		//return peg response
		return result;
	}
	
	public void promptGuess(){
		viewConsole.printPrompt();
		Scanner kb = new Scanner(System.in);
		char[] guess = kb.nextLine().toCharArray();
	}
	
	

	
}
