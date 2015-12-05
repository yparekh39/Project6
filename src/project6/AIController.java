package project6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class AIController {
	
	public static PegCombination generateRandomPegCombination(){
		PegColors[] pegs = new PegColors[4];
		PegColors[] values = PegColors.values();
		Random rand = new Random();
		for (int i = 0; i < 4; i++){
		   	int choice = rand.nextInt(6);
		   	pegs[i] = values[choice];
		}
		return new PegCombination(pegs);
	}
	
	
	public static HashSet<PegCombination> generateAllPegCombinations(){
		HashSet<PegCombination> totalCombinations = new HashSet<PegCombination>();
		for(int i = 0; i < 6; i++) {
			PegColors[] values = PegColors.values();
			PegColors[] pegCombo = new PegColors[4];
			pegCombo[0] = values[i];
			for(int j = 0; j < 6; j++){
				pegCombo[1] = values[j];
				for(int k = 0; k < 6; k++){
					pegCombo[2] = values[k];
					for(int l = 0; l < 6; l++){
						pegCombo[3] = values[l];
						PegCombination toBeAdded = new PegCombination();
						toBeAdded.pegs[0] = pegCombo[0];
						toBeAdded.pegs[1] = pegCombo[1];
						toBeAdded.pegs[2] = pegCombo[2];
						toBeAdded.pegs[3] = pegCombo[3];
						totalCombinations.add(toBeAdded);
					}
				}
			}
		}
		return totalCombinations;
	}

	public static PegCombination getNextGuess(PegCombination lastGuess, PegResponse response) {
		Iterator<PegCombination> i = AIModel.validCombinations.iterator();
		
		while(i.hasNext()){
			PegCombination combo = i.next();
			PegResponse comboGuessComparison = MastermindController.pegResponse(lastGuess, combo);
			//comboGuessComparison = MastermindController.pegResponse(lastGuess, MastermindModel.answer);
			if(!(response.equals(comboGuessComparison))){
				//System.out.print(combo + "........");
				//System.out.println(comboGuessComparison);
				i.remove();
			}
		}
		/*
		if (!(AIModel.validCombinations.contains(lastGuess))) {
			return null;
		}*/
		//Random rand = new Random();
		//return (PegCombination) AIModel.validCombinations.toArray()[rand.nextInt(AIModel.validCombinations.size())];
		Iterator<PegCombination> j = AIModel.validCombinations.iterator();
		if(j.hasNext())
			return j.next();
		else{
			System.out.println("null");
			return null;
		}
	}
	
	public static PegCombination submitGuess(String guess){
		guess.replaceAll("\\s+","");
		char[] guessArray = guess.toCharArray();
		
		if(!MastermindController.legalGuess(guessArray)){
			System.out.println("Invalid input. Please Guess Again.");
			return null;
		}
		
		return MastermindController.charToPegCombination(guessArray);
	}
	
	//FOR WHEN AI IS GUESSING
		public static PegResponse getPegResponseFromPlayer(){
			System.out.println("How accurate is this guess?");
			Scanner kb = new Scanner(System.in);
			String pegResponse = kb.nextLine();
			char[] pegResponseChar = pegResponse.toCharArray();
			PegResponse finalPegResponse = new PegResponse();
			for(int i = 0; i < 4; i ++){
				switch(pegResponseChar[i]){
					case 'B':
						finalPegResponse.response[i] = PegResponseColors.BLACK;
						break;
					case 'W':
						finalPegResponse.response[i] = PegResponseColors.WHITE;
						break;
					case 'X':
						finalPegResponse.response[i] = PegResponseColors.NONE;
						break;
				}
			}
			
			return finalPegResponse;
		}
	
}
