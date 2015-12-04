package project6;

import java.util.HashSet;

public class AIModel {
	
	public static HashSet<PegCombination> totalCombinations = AIController.generateAllPegCombinations();
	public static HashSet<PegCombination> validCombinations = new HashSet<PegCombination>(totalCombinations);
	
	public static void refreshModel() {
		totalCombinations = AIController.generateAllPegCombinations();
		validCombinations = new HashSet<PegCombination>(totalCombinations); 
	}
	
}
