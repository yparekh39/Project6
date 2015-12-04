package project6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PegCombination answer = AIController.generateRandomPegCombination();
		MastermindController.setAnswer(answer);
		System.out.println(MastermindModel.answer.toString());
		while(MastermindModel.blackPegCount < 4 && MastermindModel.currentTurn < 12){
			MastermindController.takeTurn();
		}
		//viewConsole.printBoard();
	}

}
