package manager;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;

import exceptions.*;

/**
 * @author Pablo Gomez-Abajo
 * 
 * IMutatorExecutor interface for the mutations executor
 * 
 * This interface was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public interface IMutatorExecutor {
	public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, IProgressMonitor monitor) 
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
				AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
				MetaModelNotFoundException,	ModelNotFoundException, IOException;

}
