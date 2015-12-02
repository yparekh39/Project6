package project6;

public class MastermindModel {
	static PegCombination answer = new PegCombination(new PegColors[4]);
	static Turn[] GameState = new Turn[12];
	static int currentTurn = 0;
	
	
	
	class Turn {
		PegCombination guessThisTurn;
		PegResponse pegResponseThisTurn;
		
		public Turn(){
			guessThisTurn = new PegCombination(new PegColors[4]);
			pegResponseThisTurn = new PegResponse(new PegResponseColors[4]);
		}
	}

}
