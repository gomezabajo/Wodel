package exceptions;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ReferenceNonExistingException reference does not exist
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class ReferenceNonExistingException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReferenceNonExistingException(String msg){
		super(msg);
	}

}
