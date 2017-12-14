package exceptions;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ContainerNotFoundException container not found
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class ContainerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String className;
	
	public ContainerNotFoundException (String className) {
		this.className = className;
	}
	
	public String toString() {
		return "Container not found for class: "+this.className;
	}
}
