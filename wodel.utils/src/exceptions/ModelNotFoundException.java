package exceptions;


public class ModelNotFoundException extends Exception {
	
	private String model;
	
	public ModelNotFoundException (String mmuri) {
		this.model = mmuri;
	}
	
	public String toString() {
		return "Model not found: "+this.model;
	}
}
