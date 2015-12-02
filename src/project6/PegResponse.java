package project6;

public class PegResponse {
	public PegResponseColors[] response;
    
    PegResponse(PegResponseColors[] response) {
    	this.response = response;
    }
    
	public boolean isEquals(PegResponse[] pegResponse) {
		for(int i = 0; i < 3; i++) {
			if (!(pegResponse[i].equals(response[i]))) {
				return false;
			}
		}
		return true;
	}
}
