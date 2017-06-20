package exceptions;

public class ContainerNotFoundException extends Exception {

	private String className;
	
	public ContainerNotFoundException (String className) {
		this.className = className;
	}
	
	public String toString() {
		return "Container not found for class: "+this.className;
	}
}
