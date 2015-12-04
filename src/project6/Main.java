package project6;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {
	
	public static void main(String[] args) {
		String playAgain = "no";
		viewConsole.printInstructions();
		
		do{
			MastermindController.resetGame();
			//Ask for GUI or console
			MastermindController.playerOrAI();
			PegCombination answer = new PegCombination();
			
			//SET ANSWER CODE
			//Generate answer for AI
			if(MastermindModel.playerGuessing){
				answer = AIController.generateRandomPegCombination();
			}
			//Ask user to set answer
			else if(!MastermindModel.playerGuessing){
				System.out.print("Set the code and the AI will try to crack it!\nCode:");
				Scanner kb = new Scanner(System.in);
				String userCode = kb.nextLine();
				char[] userCodeChar = userCode.toCharArray();
				answer = MastermindController.charToPegCombination(userCodeChar);
			}
			MastermindController.setAnswer(answer);
			
			//PERFORM TURNS UNTIL GAME IS WON OR LOST
			while(MastermindModel.blackPegCount < 4 && MastermindModel.currentTurn < 12 && !MastermindModel.quitGame){
				MastermindModel.blackPegCount = 0; //resets black peg count so it only checks for count this turn
				MastermindController.takeTurn();
			}
			
			//PRINT END OF GAME MESSAGE
			if(!MastermindModel.quitGame){
				if(MastermindModel.playerGuessing){
					if(MastermindModel.blackPegCount == 4)
						System.out.println("You win!!!");
					else
						System.out.println("You lose.");
				}
				else{
					System.out.println("The computer has bested you!");
				}
				System.out.print("Would you like ot play again? {Y/N}: ");
				Scanner kb = new Scanner(System.in);
				playAgain = kb.nextLine();
			}
			

		}while((playAgain.equals("Y") || playAgain.equals("y")) && !MastermindModel.quitGame);
		
		System.out.println("Game over. Thanks for playing!");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			primaryStage.setTitle("Test");
			Group world = new Group();
			BorderPane window = new BorderPane();
			Shape board = new Rectangle(500, 700);
			board.setFill(Color.FLORALWHITE);
			world.getChildren().add(board);
			window.setCenter(world);
			TextField playerInput = new TextField();
			playerInput.setPromptText("");
			Scene scene = new Scene(window, 500, 800);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		launch(args);
//	}

}
