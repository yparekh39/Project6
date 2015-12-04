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

public class Main extends Application {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		PegCombination answer = AIController.generateRandomPegCombination();
		MastermindController.setAnswer(answer);
		System.out.println(MastermindModel.answer.toString());
		while(MastermindModel.blackPegCount < 4 || MastermindModel.currentTurn < 12){
			MastermindController.takeTurn();
		}
		//viewConsole.printBoard();
	}*/
	
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
			playerInput.setPromptText("");
			Scene scene = new Scene(window, 500, 800);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
