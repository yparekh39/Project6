package project6;

public class PegCombination {
	PegColors[] pegs;
	int value = 0;
	
	PegCombination(PegColors[] pegs) { 
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