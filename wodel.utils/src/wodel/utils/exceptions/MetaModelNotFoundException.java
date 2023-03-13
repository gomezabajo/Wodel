package wodel.utils.exceptions;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MetaModelNotFoundException meta-model not found
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class MetaModelNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String metamodel;
	
	public MetaModelNotFoundException (String mmuri) {
		this.metamodel = mmuri;
	}
	
	public String toString() {
		return "Meta-model not found: "+this.metamodel;
	}
}
