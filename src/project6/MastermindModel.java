package project6;

public class MastermindModel {
	static PegCombination answer = new PegCombination(new PegColors[4]);
	static Turn[] GameState = new Turn[12];
	static int currentTurn = 0;	
	static int blackPegCount = 0;

}
