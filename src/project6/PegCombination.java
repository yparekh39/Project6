package project6;

public class PegCombination {
	PegColors[] pegs;
	int value = 0;
	
	PegCombination(PegColors[] pegs) { 
		this.pegs = pegs;
	}
	
	PegCombination(){
		pegs = new PegColors[4];
	}
	
	public boolean isEquals(PegCombination[] combination) {
		for(int i = 0; i < 3; i++) {
			if (!(combination[i].equals(pegs[i]))) {
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		String result = "";
		
		for(int i = 0; i < 4; i++){
			switch(pegs[i]){
				case RED:
					result += "R";
					break;
				case GREEN:
					result += "U";
					break;
				case BLUE:
					result += "G";
					break;
				case ORANGE:
					result += "O";
					break;
				case YELLOW:
					result += "Y";
					break;
				case PURPLE:
					result += "P";
					break;
					
			}
		}
		return null;
	}
}