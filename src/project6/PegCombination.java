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
	
	@Override
	public boolean equals(Object combination) {
		if(!(combination instanceof PegCombination)){
			return false;
		}
		for(int i = 0; i < 3; i++) {
			if (!(((PegCombination)combination).pegs[i].equals(pegs[i]))) {
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		String result = "";
		if(pegs == null)
			result = "----";
		
		else{
			for(int i = 0; i < 4; i++){
				switch(pegs[i]){
					case RED:
						result += "R";
						break;
					case GREEN:
						result += "G";
						break;
					case BLUE:
						result += "U";
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
					default:
						result+= "-";
						break;
						
				}
			}
		}
		
		return result;
	}
}