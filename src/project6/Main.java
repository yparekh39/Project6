package project6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
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
			String promptText = "The Response:";
			if (MastermindModel.playerGuessing) { promptText = "Your Guess:"; }
			Label label = new Label(promptText);
			HBox hb = new HBox();
			Button submit = new Button("Submit");
			HBox hbSubmit = new HBox(10);
			hbSubmit.getChildren().add(submit);
			hb.getChildren().addAll(label, playerInput, hbSubmit);
			hb.setSpacing(10);
			hb.setPadding(new Insets(20, 25, 25, 85));
			window.setBottom(hb);
			Scene scene = new Scene(window, 500, 800);
			primaryStage.setScene(scene);
			primaryStage.show();
			//generateShapes();
			submit.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					String input = playerInput.getText();
					if(MastermindModel.playerGuessing){ PlayerController.submitGuess(input); }
				}
				
			});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private ArrayList<Shape> generateShapes() {
		
		ArrayList<Shape> turnsAsShapes;
		int radius = 500/8/2;
		for (int i = 0; i < MastermindModel.currentTurn; i++){
			for (int j = 0; j < 4; j++){
				int xGui = j*(500/8);
				int yGui = i*(700/12);
				Shape s = new Circle(radius+xGui, radius+yGui, radius);
				if (MastermindModel.GameState[i].pegCombination.pegs[i] == PegColors.BLUE){
					s.setFill(Color.BLUE);
				} else if (MastermindModel.GameState[i].pegCombination.pegs[i] == PegColors.RED){
					s.setFill(Color.RED);
				} else if (MastermindModel.GameState[i].pegCombination.pegs[i] == PegColors.YELLOW){
					s.setFill(Color.YELLOW);
				} else if (MastermindModel.GameState[i].pegCombination.pegs[i] == PegColors.ORANGE){
					s.setFill(Color.ORANGE);
				} else if (MastermindModel.GameState[i].pegCombination.pegs[i] == PegColors.PURPLE){
					s.setFill(Color.PURPLE);
				} else if (MastermindModel.GameState[i].pegCombination.pegs[i] == PegColors.GREEN){
					s.setFill(Color.GREEN);
				}
			}
			
		}
		
		
		
		
		return null;
	}

//	public static void main(String[] args) {
//		String playAgain;
//		viewConsole.printInstructions();
//		
//		
//		
//		do{
//			MastermindController.resetGame();
//			//ASK FOR GUI OR CONSOLE
//			MastermindController.playerOrAI();
//			
//			PegCombination answer = new PegCombination();
//			
//			/* Player guessing code
//			 * 
//			 */
//			if(MastermindModel.playerGuessing){
//				System.out.println("player");
//				answer = AIController.generateRandomPegCombination();
//			}
//			
//			/* AI guessing code
//			 * 
//			 */
//			else if(!MastermindModel.playerGuessing){
//				System.out.println("ai");
//				answer = new PegCombination(new PegColors[]{PegColors.GREEN, PegColors.GREEN, PegColors.GREEN, PegColors.GREEN});
//			}
//			MastermindController.setAnswer(answer);
//			System.out.println(MastermindModel.answer.toString());
//			
//			
//			/*Old Code
//			 */
//			//MastermindController.setAnswer(answer);
//			//System.out.println(MastermindModel.answer.toString());
//			
//			//print starting board - console
//			if(MastermindModel.playingOnConsole)
//				viewConsole.printBoard();
//			//print starting board - GUI
//			else{
//				//TODO
//			}
//			//take guesses from player until game is won or lost
//			while(MastermindModel.blackPegCount < 4 && MastermindModel.currentTurn < 12){
//				MastermindModel.blackPegCount = 0; //resets black peg count so it only checks for count this turn
//				MastermindController.takeTurn();
//			}
//			//print end of game code - console
//			if(MastermindModel.playerGuessing){
//				if(MastermindModel.blackPegCount == 4)
//					System.out.println("You win!!!");
//				else
//					System.out.println("You lose bitch");
//				System.out.println("Want to play again? {Y/N}");
//				Scanner kb = new Scanner(System.in);
//				playAgain = kb.nextLine();
//			}
//			//print end of game code - GUI
//			else{
//				//TODO
//				playAgain = "";//change this later
//			}
//			
//
//		}while(playAgain.equals("Y") || playAgain.equals("y"));
//		
//		System.out.println("Game over. Thanks for playing!");
//
//		
//		
//	}

}
