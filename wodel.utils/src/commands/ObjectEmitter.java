package commands;

import org.eclipse.emf.ecore.EObject;

import exceptions.ReferenceNonExistingException;

public interface ObjectEmitter {
	
	public EObject getObject() throws ReferenceNonExistingException;

}
