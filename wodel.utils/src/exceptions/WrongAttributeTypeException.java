package exceptions;


/**
 * @author Pablo Gomez-Abajo
 * 
 * WrongAttributeTypeException wrong attribute
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class WrongAttributeTypeException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongAttributeTypeException(String msg){
		super(msg);
	}

}
