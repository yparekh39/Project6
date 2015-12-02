package project6;

import java.util.HashSet;

public class AIModel {
	
	private HashSet<PegCombination> totalCombinations;
	private HashSet<PegCombination> validCombinations;
	
	AIModel() {
        totalCombinations = new HashSet<PegCombination>(AIController.generateAllPegCombinations());
		validCombinations = new HashSet<PegCombination>(totalCombinations);
	}
	
	public HashSet<PegCombination> getTotalCombinations() {
		return totalCombinations;
	}
	
	public HashSet<PegCombination> getValidCombinations() {
		return validCombinations;
	}
	
	
	
}
