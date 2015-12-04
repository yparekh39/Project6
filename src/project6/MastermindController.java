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
	
	
	/* TURN HANDLING
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
		//print board - console
		if(MastermindModel.playerGuessing)
			viewConsole.printBoard();
		//print board - GUI
		else{
			//print board - GUI
			//TODO
		}
		
		
	}
	
	/* GUESS HANDLING
	* 1. Compares each guess peg to its parallel answer peg to determine
	* if any are in the correct position. Flags pegs in both guess and local
	* answer that are.
	* 2. Compares pegs that were not in the correct position to the answer
	* to determine if any are the correct color. Flags pegs in local answer
	* that are.*/
	public static PegResponse pegResponse(PegCombination attemptCombo, PegCombination answerCombo){
		int guessIndex = 0;
		PegColors[] attempt = attemptCombo.pegs;
		PegColors[] answer = answerCombo.pegs;
		//create default peg response (ie all clear pegs)
		PegResponseColors[] resultPegs = new PegResponseColors[4];
		PegResponseColors[] guessMirrorResponsePegs = new PegResponseColors[4];
		for(int j = 0; j < 4; j++){ resultPegs[j] = PegResponseColors.NONE; }
		
		/*Updates the current turn in the gamestate array with the current guess*/
		
		
		// NEW ALGORITHM
		//check position
		for(int i = 0; i < 4; i++){
			if(attempt[i] == answer[i]){
				resultPegs[i] = PegResponseColors.BLACK;
				guessMirrorResponsePegs[i] = PegResponseColors.BLACK;
				MastermindModel.blackPegCount++;
			}
		}
		//check color
		guessIndex = 0;
		while(guessIndex < 4){
			int answerIndex = 0;
			while(answerIndex < 4){
				if(attempt[guessIndex] == answer[answerIndex] && guessMirrorResponsePegs[guessIndex] != PegResponseColors.BLACK && resultPegs[answerIndex] != PegResponseColors.BLACK){
					resultPegs[answerIndex] = PegResponseColors.WHITE;
					break;//exit loop (we have accounted for this guess and needn't compare it to other pegs in the answer)
				}
				answerIndex++;
			}
			guessIndex++;
		}
		
		/* OLD ALGORITHM THAT HAS A BROKEN POSITION CHECKER
		 * WE HAVE TO CHECK FOR POSITION OF ALL THE PEGS BEFORE CHECKING ANY OF THE COLORS
		 * OR ELSE THE CORRECT POSITION PEGS WILL BE OVERLOOKED IF ANOTHER PEG AHEAD OF IT 
		 * WAS THE CORRECT COLOR
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
		}*/
		
		
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
		
		//return peg response
		return result;
	}
	
	//asks for guess from user and returns the guess as a PegCombination once valid
	public static PegCombination promptGuess(){
		String guess;
		//prompts and takes guess - console
		if(MastermindModel.playerGuessing){
			viewConsole.printColorChoices();
			viewConsole.printPrompt();
			Scanner kb = new Scanner(System.in);
			guess = kb.nextLine();
		}
		//prompts and takes guess - GUI
		else{
			//TODO
			guess = "";//fix later
		}
		
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
		MastermindModel.playerGuessing = true;
	}
	
	public static void playerOrAI(){
		System.out.print("Player or AI guessing? {P/A}: ");
		Scanner kb = new Scanner(System.in);
		String input = kb.nextLine();
		if(input.equals("P") || input.equals("A"))
			MastermindModel.playerGuessing = input == "P" ? true:false;
		else
			playerOrAI();
		
	}
	
}
