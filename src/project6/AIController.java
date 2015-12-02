package project6;

import java.util.HashSet;
import java.util.Random;

public class AIController {
	
	public PegCombination generateRandomPegCombination(){
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
		for(int i = 0; i < 5; i++) {
			PegColors[] values = PegColors.values();
			PegColors[] pegs = new PegColors[4];
			pegs[0] = values[i];
			for(int j = 0; j < 5; j++){
				pegs[1] = values[j];
				for(int k = 0; k < 5; k++){
					pegs[2] = values[k];
					for(int l = 0; l < 5; l++){
						pegs[3] = values[l];
						totalCombinations.add(new PegCombination(pegs));
					}
				}
			}
		}
		return totalCombinations;
	}

	
}
