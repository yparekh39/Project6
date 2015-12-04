package project6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String playAgain;
		viewConsole.printInstructions();
		
		
		
		do{
			MastermindController.resetGame();
			//ASK FOR GUI OR CONSOLE
			MastermindController.playerOrAI();
			
			PegCombination answer = new PegCombination();
			
			/* Player guessing code
			 */
			if(MastermindModel.playerGuessing){
				System.out.println("player");
				answer = AIController.generateRandomPegCombination();
			}
			
			/* AI guessing code
			 */
			else if(!MastermindModel.playerGuessing){
				System.out.print("Set the code and the AI will try to crack it!\nCode:");
				Scanner kb = new Scanner(System.in);
				String userCode = kb.nextLine();
				char[] userCodeChar = userCode.toCharArray();
				answer = MastermindController.charToPegCombination(userCodeChar);
				System.out.println("ai");
				//answer = new PegCombination(new PegColors[]{PegColors.YELLOW, PegColors.PURPLE, PegColors.ORANGE, PegColors.ORANGE});
			}
			MastermindController.setAnswer(answer);
			//System.out.println(MastermindModel.answer.toString());
			
			//print starting board - console
			if(MastermindModel.playingOnConsole)
				viewConsole.printBoard();
			//print starting board - GUI
			else{
				//TODO
			}
			//take guesses from player until game is won or lost
			while(MastermindModel.blackPegCount < 4 && MastermindModel.currentTurn < 12){
				MastermindModel.blackPegCount = 0; //resets black peg count so it only checks for count this turn
				MastermindController.takeTurn();
			}
			//print end of game code - console
			if(MastermindModel.playerGuessing){
				if(MastermindModel.blackPegCount == 4)
					System.out.println("You win!!!");
				else
					System.out.println("You lose bitch");
				System.out.println("Want to play again? {Y/N}");
				Scanner kb = new Scanner(System.in);
				playAgain = kb.nextLine();
			}
			//print end of game code - GUI
			else{
				//TODO
				playAgain = "";//change this later
			}
			

		}while(playAgain.equals("Y") || playAgain.equals("y"));
		
		System.out.println("Game over. Thanks for playing!");

		
		
	}

}
