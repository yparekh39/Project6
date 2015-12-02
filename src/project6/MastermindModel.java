package project6;

import java.util.HashSet;

public class MastermindModel {

	private class PegCombination {
		PegColor[] pegs;
		int value = 0;
		
		PegCombination(PegColor[] pegs) { 
			this.pegs = pegs;
		}
		
		public boolean isEquals(PegCombination[] combination) {
			for(int i = 0; i < 3; i++) {
				if (!(combination[i].equals(pegs[i]))) {
					return false;
				}
			}
			return true;
		}
	}
	
	private HashSet<PegCombination> totalCombinations = new HashSet<PegCombination>();
	private HashSet<PegCombination> validCombinations;
	
	MastermindModel() {
		for(int i = 0; i < 5; i++) {
			PegColor[] values = PegColor.values();
			PegColor[] pegs = new PegColor[4];
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
		validCombinations = new HashSet<PegCombination>(totalCombinations);
	}
	
	public HashSet<PegCombination> getTotalCombinations() {
		return totalCombinations;
	}
	
	public HashSet<PegCombination> getValidCombinations() {
		return validCombinations;
	}
	
	
	
}
