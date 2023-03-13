package wodel.utils.exceptions;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ObjectNotContainedException not contained object
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class ObjectNotContainedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotContainedException(String msg){
		super(msg);
	}

}
