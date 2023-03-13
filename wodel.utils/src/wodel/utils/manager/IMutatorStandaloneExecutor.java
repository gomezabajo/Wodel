package wodel.utils.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;

import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import wodel.utils.manager.MutatorUtils.MutationResults;

/**
 * @author Pablo Gomez-Abajo
 * 
 * IMutatorExecutor interface for the mutations executor
 * 
 * This interface was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public interface IMutatorStandaloneExecutor {
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry,
			boolean metrics, boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject, TreeMap<String, List<String>> classes,
			HashMap<String, EPackage> registeredPackages)  
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
				AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
				MetaModelNotFoundException,	ModelNotFoundException, IOException;

}
