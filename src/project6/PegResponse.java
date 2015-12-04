package project6;

public class PegResponse {
	public PegResponseColors[] response;
    
    PegResponse(PegResponseColors[] response) {
    	this.response = response;
    }
    
    PegResponse(){
    	this.response = new PegResponseColors[4];
    }
    
    @Override
	public boolean equals(Object pegResponse) {
		if (!(pegResponse instanceof PegResponse)) {
			return false;
		}
		
		for(int i = 0; i < 4; i++) {
			if (!(((PegResponse)pegResponse).response[i].equals(response[i]))) {
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		String result = "";
		
		for(int i = 0; i < 4; i++){
			switch(response[i]){
				case BLACK:
					result += "B";
					break;
				case WHITE:
					result += "W";
					break;
				case NONE:
					result += "X";
					break;
			}
		}
		return result;
	}
}
