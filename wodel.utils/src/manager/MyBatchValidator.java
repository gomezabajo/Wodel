package manager;

/******************************************************************************
 * Copyright (c) 2003, 2010 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 *    Zeligsoft - Bug 218765
 *    
 * $Id$
 * 
 ****************************************************************************/


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.internal.EMFModelValidationDebugOptions;
import org.eclipse.emf.validation.internal.EMFModelValidationPlugin;
import org.eclipse.emf.validation.internal.service.ClientContextManager;
import org.eclipse.emf.validation.internal.service.GetBatchConstraintsOperation;
import org.eclipse.emf.validation.internal.service.IClientContext;
import org.eclipse.emf.validation.internal.service.IProviderOperationExecutor;
import org.eclipse.emf.validation.internal.service.ResourceStatus;
import org.eclipse.emf.validation.internal.util.Trace;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ITraversalStrategy;

/**
 * Basic implementation of the {@link IBatchValidator} interface.
 * Ensures that, in cases of multiple selection where recursion is desired,
 * validation is not repeated on selected elements that are contained in other
 * selected elements.
 *
 * @author Christian W. Damus (cdamus)
 */
public class MyBatchValidator extends MyAbstractValidator<EObject> implements IBatchValidator {
	private IProgressMonitor progressMonitor = null;
	
	private ITraversalStrategy defaultTraversalStrategy =
		new DefaultRecursiveTraversalStrategy();
	
	/**
	 * Initializes me with the operation <code>executor</code> that I use to
	 * execute provider operations.
	 * 
	 * @param executor used by me to execute operations (must not be
	 *      <code>null</code>)
	 */
	public MyBatchValidator(IProviderOperationExecutor executor) {
		super(EvaluationMode.BATCH, executor);
	}

	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	public boolean isIncludeLiveConstraints() {
		return getOption(OPTION_INCLUDE_LIVE_CONSTRAINTS);
	}

	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	public void setIncludeLiveConstraints(boolean includeLiveConstraints) {
		if (includeLiveConstraints != isIncludeLiveConstraints()) {
			setOption(OPTION_INCLUDE_LIVE_CONSTRAINTS, includeLiveConstraints);
		}
	}
	
	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	public ITraversalStrategy getDefaultTraversalStrategy() {
		return defaultTraversalStrategy;
	}
	
	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	public ITraversalStrategy getTraversalStrategy() {
		return getOption(OPTION_TRAVERSAL_STRATEGY);
	}
	
	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	public void setTraversalStrategy(ITraversalStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("strategy is null"); //$NON-NLS-1$
		}

		setOption(OPTION_TRAVERSAL_STRATEGY, strategy);
	}
	
	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	public IStatus validate(EObject eObject, IProgressMonitor monitor) {
		IStatus result;
		
		progressMonitor = monitor;
		
		result = validate(eObject);
		
		return result;
	}

	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	public IStatus validate(Collection<? extends EObject> objects, IProgressMonitor monitor) {
		IStatus result;
		
		progressMonitor = monitor;
		
		result = validate(objects);
		
		return result;
	}

	/* (non-Javadoc)
	 * Implements the inherited method.
	 */
	@Override
	protected Collection<IStatus> doValidate(Collection<? extends EObject> objects,
			Set<IClientContext> clientContexts) {
		
		List<IStatus> result = new java.util.ArrayList<IStatus>(64);  // anticipate large scale
		
		MyGetBatchConstraintsOperation operation =
			new MyGetBatchConstraintsOperation(!isIncludeLiveConstraints());
		MyAbstractValidationContext ctx = operation.getContext();
		ctx.setReportSuccesses(isReportSuccesses());
		
		validate(getTraversalStrategy(), result, ctx, objects, operation, clientContexts);
		
		return result;
	}
	
	/**
	 * Helper method for validation of any number of objects, using the
	 * specified <code>traversal</code> strategy.
	 * 
	 * @param traversal the traversal strategy to employ
	 * @param evaluationResults the evaluation results that are being
	 *     accumulated recursively
	 * @param ctx context for evaluation
	 * @param clientContexts 
	 * @param eObjects a collection of {@link EObject}s to validate
	 * @param the operation to reuse for getting constraints
	 * @param (output) the set of client contexts to be updated with all of the
	 *         encountered contexts while performing validation.
	 */
	private void validate(
			ITraversalStrategy traversal,
			List<IStatus> evaluationResults,
			MyAbstractValidationContext ctx,
			Collection<? extends EObject> objects,
			MyGetBatchConstraintsOperation operation, 
			Set<IClientContext> clientContexts) {
		
		Set<Resource> resources = null;
		boolean trackResources = getOption(OPTION_TRACK_RESOURCES);
		
		if (trackResources) {
			resources = new java.util.HashSet<Resource>();
		}
		
		IProgressMonitor monitor = progressMonitor;
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		
		traversal.startTraversal(objects, monitor);
		boolean firstElement = true;
		
		try {
			while (traversal.hasNext()) {
				if (monitor.isCanceled()) {
					break;
				}
		
				boolean recomputeClients = firstElement
					|| traversal.isClientContextChanged();
				
				final EObject next = traversal.next();

				//if (recomputeClients) {
				//	Collection<IClientContext> contexts = ClientContextManager.getInstance()
				//			.getClientContextsFor(next);
				//	ctx.setClientContexts(contexts);
				//	clientContexts.addAll(contexts);
				//}
				
				traversal.elementValidated(
					next,
					validate(
						ctx,
						next,
						operation,
						evaluationResults));
				
				if (trackResources) {
					resources.add(next.eResource());
				}
				
				firstElement = false;
			}
		} catch (OperationCanceledException e) {
			// a constraint has requested cancellation of the validation
			//    operation.  Honour that request and propagate the exception
			monitor.setCanceled(true);
			throw e;
		} finally {
			if (!monitor.isCanceled()) {
				monitor.done();
			}
			progressMonitor = null;
			
			if (trackResources) {
				evaluationResults.add(createDummyResourceStatus(resources));
			}
		}
	}

	/**
	 * Helper method for validation of a single object.
	 * 
	 * @param ctx the context within which to validate the <code>eObject</code>
	 * @param eObject the EMF object to validate
	 * @param the operation to reuse for getting constraints
	 * @param results list of {@link IStatus} results of constraint evaluations
	 * 
	 * @return a summary status of the <code>eObject</code>'s validation
	 */
	private IStatus validate(
			MyAbstractValidationContext ctx,
			EObject eObject,
			MyGetBatchConstraintsOperation operation,
			List<IStatus> results) {
		//if (Trace.shouldTraceEntering(EMFModelValidationDebugOptions.PROVIDERS)) {
		//	Trace.entering(getClass(), "validate", //$NON-NLS-1$
		//			new Object[] {eObject});
		//}

		operation.setTarget(eObject);
		
		execute(operation);
		
		IStatus result = evaluateConstraints(ctx, results);

		//if (Trace.shouldTraceExiting(EMFModelValidationDebugOptions.PROVIDERS)) {
		//	Trace.exiting(
		//		getClass(),
		//		"validate", //$NON-NLS-1$
		//		result);
		//}
		
		return result;
	}
	
	/**
	 * Creates OK statuses (in a multi-status if necessary) for each resource
	 * visited when the {@link IBatchValidator#OPTION_TRACK_RESOURCES}
	 * option is set.  These will cue the {@link MarkerUtil} to clear markers
	 * from resources that had no problems.
	 * 
	 * @param resources the resources covered by validation
	 * 
	 * @return the status
	 */
	private IStatus createDummyResourceStatus(Collection<Resource> resources) {
		List<IStatus> result = new java.util.ArrayList<IStatus>(resources.size());
		
		for (Resource next : resources) {
			if (next != null) {
				// there must be at least one contained object, otherwise we
				// couldn't have found this resource via EObject::eResource()
				result.add(new ResourceStatus(next.getContents().get(0)));
			}
		}
		
		return result.isEmpty()
			? Status.OK_STATUS
			: (result.size() == 1)
				? result.get(0)
				: new MultiStatus(EMFModelValidationPlugin.getPluginId(), 0,
					result.toArray(new IStatus[result.size()]), result.get(0)
						.getMessage(), null);
	}
	
	private static class DefaultRecursiveTraversalStrategy implements ITraversalStrategy {
		private Map<ITraversalStrategy, Collection<EObject>> delegates;
		private Map<ITraversalStrategy, IProgressMonitor> monitors;
		private Iterator<ITraversalStrategy> delegateIterator;
		private ITraversalStrategy current;
		
		/* (non-Javadoc)
		 * Redefines/Implements/Extends the inherited method.
		 */
		public void startTraversal(Collection<? extends EObject> traversalRoots,
				IProgressMonitor monitor) {
			current = null;
			delegates = initDelegates(traversalRoots);
			monitors = new java.util.HashMap<ITraversalStrategy, IProgressMonitor>();
			
			monitor.beginTask("", delegates.size() * 1024); //$NON-NLS-1$
			
			for (Map.Entry<ITraversalStrategy, Collection<EObject>> next :
					delegates.entrySet()) {
				
				SubProgressMonitor sub = new SubProgressMonitor(
					monitor,
					1024,
					SubProgressMonitor.SUPPRESS_SUBTASK_LABEL);
				next.getKey().startTraversal(next.getValue(), sub);
				
				monitors.put(next.getKey(), sub);
			}
			
			delegateIterator = delegates.keySet().iterator();
		}

		/* (non-Javadoc)
		 * Redefines/Implements/Extends the inherited method.
		 */
		public boolean hasNext() {
			if ((current == null) && (delegateIterator.hasNext())) {
				current = delegateIterator.next();
			}
			
			if (current == null) {
				return false;
			}
			
			if (!current.hasNext()) {
				monitors.get(current).done();
				current = null;
				
				return hasNext();  // get the next delegate and try it
			}
			
			return true;
		}

		/* (non-Javadoc)
		 * Redefines/Implements/Extends the inherited method.
		 */
		public EObject next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			return current.next();
		}
		
		/* (non-Javadoc)
		 * Redefines/Implements/Extends the inherited method.
		 */
		public boolean isClientContextChanged() {
			if (current != null) {
				return current.isClientContextChanged();
			}
			
			return false;
		}

		/* (non-Javadoc)
		 * Redefines/Implements/Extends the inherited method.
		 */
		public void elementValidated(EObject element, IStatus status) {
			current.elementValidated(element, status);
		}
		
		private Map<ITraversalStrategy, Collection<EObject>> initDelegates(
				Collection<? extends EObject> traversalRoots) {
			
			Map<ITraversalStrategy, Collection<EObject>> result =
				new java.util.HashMap<ITraversalStrategy, Collection<EObject>>();
			
			for (EObject next : traversalRoots) {
				ITraversalStrategy delegate = MyTraversalStrategyManager
					.getInstance().getTraversalStrategy(next);
				
				Collection<EObject> delegateRoots = result.get(delegate);
				if (delegateRoots == null) {
					delegateRoots = new java.util.ArrayList<EObject>();
					result.put(delegate, delegateRoots);
				}
				
				delegateRoots.add(next);
			}
			
			return result;
		}
	}
}
