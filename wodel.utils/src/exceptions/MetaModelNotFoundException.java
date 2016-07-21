package exceptions;


public class MetaModelNotFoundException extends Exception {
	
	private String metamodel;
	
	public MetaModelNotFoundException (String mmuri) {
		this.metamodel = mmuri;
	}
	
	public String toString() {
		return "Meta-model not found: "+this.metamodel;
	}
}
