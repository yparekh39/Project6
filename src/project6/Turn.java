package project6;

public class Turn {
	PegCombination pegCombination;
	PegResponse pegResponse;
	
	public Turn(){
		this.pegCombination = new PegCombination(new PegColors[4]);
		this.pegResponse = new PegResponse(new PegResponseColors[4]);
	}
	
	public Turn(PegCombination pegCombination, PegResponse pegResponse) {
		this.pegCombination = pegCombination;
		this.pegResponse = pegResponse;
	}
}
