package project6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String playAgain;
		viewConsole.printInstructions();
		
		do{
			MastermindController.resetGame();
			PegCombination answer = AIController.generateRandomPegCombination();
			MastermindController.setAnswer(answer);
			System.out.println(MastermindModel.answer.toString());
			viewConsole.printBoard();
			
			while(MastermindModel.blackPegCount < 4 && MastermindModel.currentTurn < 12){
				MastermindModel.blackPegCount = 0; //resets black peg count so it only checks for count this turn
				MastermindController.takeTurn();
			}
			
			System.out.println("You win!!!");
			System.out.println("Want to play again? {Y/N}");
			Scanner kb = new Scanner(System.in);
			playAgain = kb.nextLine();

		}while(playAgain.equals("Y") || playAgain.equals("y"));
		
		System.out.println("Game over. Thanks for playing!");

		
		
	}

}
