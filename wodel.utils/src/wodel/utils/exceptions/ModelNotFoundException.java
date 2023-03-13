package wodel.utils.exceptions;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ModelNotFoundException model not found
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class ModelNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String model;
	
	public ModelNotFoundException (String mmuri) {
		this.model = mmuri;
	}
	
	public String toString() {
		return "Model not found: "+this.model;
	}
}
