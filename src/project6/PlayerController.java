package project6;

public class PlayerController {

	public static PegCombination submitGuess(String guess){
		guess.replaceAll("\\s+","");
		char[] guessArray = guess.toCharArray();
		
		if(!MastermindController.legalGuess(guessArray)){
			System.out.println("Invalid input. Please Guess Again.");
			return null;
		}
		
		return MastermindController.charToPegCombination(guessArray);
	}
}
