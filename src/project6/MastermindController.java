package project6;

import java.util.HashSet;

public class MastermindController {
	
	/* Sets the correct answer given input from the user (AI or Player)
	 */
	public void setAnswer(PegCombination[] answer){
		MastermindModel.answer = answer;
	}
	
	/* Takes a guess from the user (AI or Player) and returns a peg response based on the accuracy of the guess.
	 * The peg response at first mirrors the answer, so that pegs in the answer that are also in the guess
	 * (whether position is correct or not) are marked in the peg response and thus not compared a second time against 
	 * other pegs in the guess.
	 * After the pegs in the guess have all been checked against the answer, the pegs are added into a final peg response
	 * in the order BLACK, WHITE, NONE.
	 * Ex: The accuracy check is BLACK NONE NONE WHITE. The final peg response is BLACK WHITE NONE NONE.
	 */
	public PegResponse guess(PegCombination[] attempt){
		int guessIndex = 0;
		
		//create default peg response (ie all clear pegs)
		PegResponseColors[] resultPegs = new PegResponseColors[4];
		for(int j = 0; j < 4; j++){ resultPegs[j] = PegResponseColors.NONE; }
		
		//check accuracy of guess
		while(guessIndex < 4){
			int answerIndex = 0;
			//check if peg at guessIndex is in correct position
			//if it is, mark that answer position in response as accounted for (ie black)
			if(resultPegs[guessIndex] == PegResponseColors.NONE && attempt[guessIndex] == MastermindModel.answer[guessIndex]){
				resultPegs[guessIndex] = PegResponseColors.BLACK;
			}
			//check rest of answer to see if peg at guessIndex is correct color
			//if it is, mark that answer position in response as accounted for (ie white)
			else{
				while(answerIndex < 4){
					if(attempt[guessIndex] == MastermindModel.answer[answerIndex]){
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
		
		//return peg response
		PegResponse result = new PegResponse(finalResultPegs);
		return result;
	}
	
	

	
}
