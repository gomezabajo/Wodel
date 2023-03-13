package wodel.utils.commands;

import org.eclipse.emf.ecore.EObject;

import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ObjectEmitter interface
 * 
 * This interface was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public interface ObjectEmitter {
	
	public EObject getObject() throws ReferenceNonExistingException;

}
