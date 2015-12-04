package project6;

import java.util.HashSet;
import java.util.Scanner;

public class MastermindController {
	
	/* Runs the game
	 * 
	 * Asks if AI or Player will set the code
	 * Runs takeTurn in loop - loop breaks when game is over.
	 * Asks if Player would like to play again
	 * 
	 */
	public void runGame(){
		
	}
	
	/* Sets the correct answer given input from the user (AI or Player)
	 */
	public static void setAnswer(PegCombination answer){
		MastermindModel.answer = answer;
	}
	
	
	/* Fundamental turn operation of game
	 * 
	 * 1. Prompts the user for a guess
	 * 2. Gives a user the response based on accuracy of guess
	 */
	public static void takeTurn(){
		PegCombination guess = promptGuess();
		while(guess == null) { guess = promptGuess(); }
		PegResponse pegResponse = new PegResponse();
		pegResponse = pegResponse(guess, MastermindModel.answer);
		
		Turn turn = new Turn(guess, pegResponse);
		MastermindModel.GameState[MastermindModel.currentTurn] = turn;
		MastermindModel.currentTurn++;
		viewConsole.printBoard();
		
		/* Check if game over
		 */
		
	}
	
	
	
	/* Takes a guess from the user (AI or Player) and updates the turn within the model with that guess and the 
	 * corresponding peg response.
	 * Then returns a peg response based on the accuracy of the guess.
	 * The peg response at first mirrors the answer, so that pegs in the answer that are also in the guess
	 * (whether position is correct or not) are marked in the peg response and thus not compared a second time against 
	 * other pegs in the guess.
	 * After the pegs in the guess have all been checked against the answer, the pegs are added into a final peg response
	 * in the order BLACK, WHITE, NONE.
	 * Ex: The accuracy check is BLACK NONE NONE WHITE. The final peg response is BLACK WHITE NONE NONE.
	 */
	public static PegResponse pegResponse(PegCombination attemptCombo, PegCombination answerCombo){
		int guessIndex = 0;
		PegColors[] attempt = attemptCombo.pegs;
		PegColors[] answer = answerCombo.pegs;
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
				MastermindModel.blackPegCount++;
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
		/*MastermindModel.GameState[MastermindModel.currentTurn].guessThisTurn = attemptCombo;
		MastermindModel.GameState[MastermindModel.currentTurn].pegResponseThisTurn = result;
		MastermindModel.currentTurn++;
		
		//is game over?
		if(MastermindModel.currentTurn == 12 || blackPegCount == 4 ){
			//end game code
		}*/
		
		//return peg response
		return result;
	}
	
	//asks for guess from user and returns the guess as a PegCombination once valid
	public static PegCombination promptGuess(){
		viewConsole.printPrompt();
		Scanner kb = new Scanner(System.in);
		String guess = kb.nextLine();
		
		return PlayerController.submitGuess(guess);
	}
	
	//checks if guess is a valid guess
	public static boolean legalGuess(char[] guess){
		boolean legal = true;
		if(guess.length > 4)
			legal = false;
		
		int i = 0;
		while(legal == true && i < 4){
			switch (guess[i]){
				case 'R':
					break;
				case 'U':
					break;
				case 'G':
					break;
				case 'O':
					break;
				case 'Y':
					break;
				case 'P':
					break;
				default:
					legal = false;
					break;
			}
			i++;	
		}
		return legal;
	}
	
	//converts a char[] (user input) into a peg combination
	public static PegCombination charToPegCombination(char[] guess){
		PegCombination result = new PegCombination(new PegColors[4]);
		
		for(int i = 0; i < 4; i++){
			switch(guess[i]){
			case 'R':
				result.pegs[i] = PegColors.RED;
				break;
			case 'U':
				result.pegs[i] = PegColors.BLUE;
				break;
			case 'G':
				result.pegs[i] = PegColors.GREEN;
				break;
			case 'O':
				result.pegs[i] = PegColors.ORANGE;
				break;
			case 'Y':
				result.pegs[i] = PegColors.YELLOW;
				break;
			case 'P':
				result.pegs[i] = PegColors.PURPLE;
				break;
			}
		}
		
		return result;
	}
	
	public static void resetGame(){
		MastermindModel.GameState = new Turn[12];
		MastermindModel.currentTurn = 0;
		MastermindModel.blackPegCount = 0;
	}
	
}
