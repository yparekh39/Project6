package project6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PegCombination answer = AIController.generateRandomPegCombination();
		MastermindController.setAnswer(answer);
		System.out.println(MastermindModel.answer.toString());
		
		while(MastermindModel.blackPegCount < 4 && MastermindModel.currentTurn < 12){
			MastermindModel.blackPegCount = 0; //resets black peg count so it only checks for count this turn
			MastermindController.takeTurn();
		}

	}

}
