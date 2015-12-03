package project6;

public class viewConsole {
	
	//print the board
	public static void printBoard(){
		//print each turn/row
		for(int i = 0; i < 12; i++){
			//assemble and print a row
			String turn = "";
			turn += MastermindModel.GameState[i].guessThisTurn.toString();
			turn+="..........";
			turn += MastermindModel.GameState[i].pegResponseThisTurn.toString();
			System.out.println(turn);
		}
	}
	public static void printPrompt(){
		System.out.println("Guess!");
	}
	

}
