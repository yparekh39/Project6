package project6;

public class viewConsole {
	
	//print the board
	public static void printBoard(){
		//print each turn/row
		for(int i = 0; i < 12; i++){
			//assemble and print a row
			String turn = "";
			
			//add the peg combination to the row to be printed
			PegColors[] comboThisTurn = MastermindModel.GameState[i].guessThisTurn.pegs;
			for(int j = 0; j < 4; j++){
				switch(comboThisTurn[j]){
					case RED:
						turn+="R ";
						break;
					case BLUE:
						turn+="U ";
						break;
					case GREEN:
						turn+="G ";
						break;
					case ORANGE:
						turn+="O ";
						break;
					case YELLOW:
						turn+="Y ";
						break;
					case PURPLE:
						turn+="P ";
						break;
				}
			}
			turn+="..........";
			//add the peg response to the row to be printed
			PegResponseColors[] rspThisTurn = MastermindModel.GameState[i].pegResponseThisTurn.response;
			for(int j = 0; j < 4; j++){
				switch(rspThisTurn[j]){
					case BLACK:
						turn+="B";
						break;
					case WHITE:
						turn+="W";
						break;
					case NONE:
						turn+="X";
						break;
				}
			}
			System.out.println(turn);
		}
	}
	public static void printPrompt(){
		System.out.println("Guess!");
	}
	

}
