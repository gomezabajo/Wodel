package exceptions;

public class USEImportException extends Exception {
	
	private String modelName = "";

	public USEImportException (String modelName) {
		this.modelName = modelName;
	}
	
	public String toString() {
		return "USE model could not be imported into EMF XMI: " + this.modelName;
	}
}
