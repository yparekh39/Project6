package project6;

public class viewConsole {
	//print the instructions
	public static void printInstructions(){
		System.out.println("Welcome to MasterMind!");
		System.out.println("You may quit at any time by typing \"quit\"");
	}
	
	//print the peg color choices
	public static void printColorChoices(){
		System.out.println("\nPeg Colors:\nR U G O Y P");
	}
	
	//print the board
	public static void printBoard(){
		//print each turn/row
		for(int i = 0; i < 12; i++){
			//assemble and print a row
			String turn = "";
			if(MastermindModel.GameState[i] == null)
				turn+="----";
			else
				turn += MastermindModel.GameState[i].pegCombination.toString();
			
			turn+="..........";
			
			if(MastermindModel.GameState[i] == null)
				turn += "----";
			else
				turn += MastermindModel.GameState[i].pegResponse.toString();
			System.out.println(turn);
		}
	}
	public static void printPrompt(){
		System.out.print("\nGuess: ");
	}
	

}
