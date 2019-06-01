package manager;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;

import exceptions.*;
import manager.MutatorUtils.MutationResults;

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
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry,
			boolean metrics, boolean debugMetrics, String[] blockNames, IProject project,
			IProgressMonitor monitor, boolean serialize, Object testObject, TreeMap<String, List<String>> classes) 
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
				AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
				MetaModelNotFoundException,	ModelNotFoundException, IOException;

}
