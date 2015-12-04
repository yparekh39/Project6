package project6;

public class viewConsole {
	
	//print the board
	public static void printBoard(){
		//print each turn/row
		for(int i = 0; i < MastermindModel.currentTurn; i++){
			//assemble and print a row
			String turn = "";
			turn += MastermindModel.GameState[i].pegCombination.toString();
			turn+="..........";
			turn += MastermindModel.GameState[i].pegResponse.toString();
			System.out.println(turn);
		}
	}
	public static void printPrompt(){
		System.out.println("Guess!");
	}
	

}
