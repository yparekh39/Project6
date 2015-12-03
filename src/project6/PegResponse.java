package project6;

public class PegResponse {
	public PegResponseColors[] response;
    
    PegResponse(PegResponseColors[] response) {
    	this.response = response;
    }
    
    PegResponse(){
    	this.response = new PegResponseColors[4];
    }
    
	public boolean isEquals(PegResponse[] pegResponse) {
		for(int i = 0; i < 3; i++) {
			if (!(pegResponse[i].equals(response[i]))) {
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
		return null;
	}
}
