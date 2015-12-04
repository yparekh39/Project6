package project6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PegCombination answer = AIController.generateRandomPegCombination();
		MastermindController.setAnswer(answer);
		MastermindController.takeTurn();
		//viewConsole.printBoard();
	}

}
