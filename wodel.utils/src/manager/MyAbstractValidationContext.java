package manager;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.internal.EMFModelValidationDebugOptions;
import org.eclipse.emf.validation.internal.EMFModelValidationPlugin;
import org.eclipse.emf.validation.internal.EMFModelValidationStatusCodes;
import org.eclipse.emf.validation.internal.service.ClientContextManager;
import org.eclipse.emf.validation.internal.service.IClientContext;
import org.eclipse.emf.validation.internal.service.IProviderOperation;
import org.eclipse.emf.validation.internal.util.TextUtils;
import org.eclipse.emf.validation.internal.util.Trace;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.util.FilteredCollection;

/**
 * A partial implementation of the {@link IValidationContext} interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class MyAbstractValidationContext implements IValidationContext {
	private final IProviderOperation<Collection<IModelConstraint>> operation;
	
	// tracks the eObjects that are ignored by a constraint
	private final ConstraintIgnorement ignoredConstraints =
		new ConstraintIgnorement();
	
	private ConstraintFilter filter;  // lazily initialized
	
	private final Map<IModelConstraint, Object> constraintData =
		new java.util.HashMap<IModelConstraint, Object>();

	private IModelConstraint currentConstraint = null;
	private IConstraintDescriptor currentDescriptor = null;
		
	private final Set<EObject> resultLocus = new java.util.HashSet<EObject>();
	
	private boolean reportSuccesses = false;
	
	private Collection<IClientContext> clientContexts = Collections.emptySet();
	
	//	filters out all ignored and disabled, as well as constraints
	//	   that have already been executed on the current target
	private class ConstraintFilter implements FilteredCollection.Filter<IModelConstraint> {
		/** Initializes me. */
		ConstraintFilter() {
			// nothing to initialize.  Just declare the constructor explicitly
		}
		
		/**
		 * I filter out any constraint that is disabled, ignored, or has already
		 * been evaluated against the current target object.
		 */
		public boolean accept(IModelConstraint constraint) {
			IConstraintDescriptor desc = constraint.getDescriptor();
			
			return (desc.isEnabled() && !isIgnored(desc));
		}
		
		/**
		 * Queries whether the constraint indicated by the specified
		 * <code>desc</code>riptor is ignored for the current target,
		 * in this context.
		 * 
		 * @param desc the constraint descriptor
		 * @return <CODE>true</CODE> if the current constraint is ignored for the
		 *    current target, <CODE>false</CODE>, otherwise
		 */
		private boolean isIgnored(IConstraintDescriptor desc) {
			return ignoredConstraints.isIgnored(getTarget(), desc);
		}
	}
	
	// an object that tracks the ignorement of constraints, according to
	//    whether they are triggered for specific features (in the live and
	//    feature validation cases) or just by the object type (batch mode)
	private class ConstraintIgnorement {
		private final Map<EObject, Collection<IConstraintDescriptor>> ignoreMap =
			new java.util.HashMap<EObject, Collection<IConstraintDescriptor>>();
		
		/**
		 * Ignores the specified <code>constraint</code> for this
		 * <code>eObject</code>, according to whether the constraint was
		 * triggered by a specific feature or not.
		 * 
		 * @param eObject the validation target
		 * @param constraint the constraint
		 */
		void ignore(EObject eObject, IConstraintDescriptor constraint) {
			Collection<IConstraintDescriptor> ignored = getIgnoredConstraints(eObject);
			
			if (ignored == null) {
				ignored = initIgnoredConstraints(eObject);
			}
			
			ignored.add(constraint);
		}
		
		/**
		 * Queries whether the specified <code>constraint</code> is ignored
		 * for this <code>eObject</code>, according to whether the constraint
		 * was triggered by a specific feature or not.
		 * 
		 * @param eObject the validation target
		 * @param constraint the constraint
		 * @return whether the <code>constraint</code> is ignored
		 */
		boolean isIgnored(EObject eObject, IConstraintDescriptor constraint) {
			Collection<IConstraintDescriptor> ignored = getIgnoredConstraints(eObject);
			
			return (ignored != null) && ignored.contains(constraint);
		}
	
		/**
		 * Obtains the type-triggered constraints that have already been
		 * evaluated for the specified <code>target</code> object, or that are
		 * otherwise ignored for it.
		 * 
		 * @param target a validation target object
		 * @return the constraints that are ignored for this <code>target</code>
		 *    and that are not triggered by a feature, or <code>null</code> if
		 *    no ignored constraints collection exists, yet
		 */
		private Collection<IConstraintDescriptor> getIgnoredConstraints(EObject target) {
			return ignoreMap.get(target);
		}
	
		/**
		 * Initializes the type-triggered ignored constraints collection
		 * for the specified <code>target</code> object.
		 * 
		 * @param target a validation target object
		 * @return the new ignored constraints collection
		 */
		private Collection<IConstraintDescriptor> initIgnoredConstraints(EObject target) {
			Collection<IConstraintDescriptor> result = new java.util.HashSet<IConstraintDescriptor>();
			
			ignoreMap.put(target, result);
		
			return result;
		}
	}
	
	/**
	 * Initializes me.
	 * 
	 * @param operation the operation for which I provide a validation context
	 */
	protected MyAbstractValidationContext(
			IProviderOperation<Collection<IModelConstraint>> operation) {
		this.operation = operation;
	}

	/**
	 * Obtains the operation that I provide a validation context for.
	 * 
	 * @return my operation
	 */
	protected final IProviderOperation<Collection<IModelConstraint>> getOperation() {
		return operation;
	}
	
	/**
	 * Default implementation simply returns {@link EMFEventType#NULL}.
	 */
	public EMFEventType getEventType() {
		return EMFEventType.NULL;
	}
	
	/**
	 * Default implementation simply returns an empty list.
	 */
	public List<Notification> getAllEvents() {
		return Collections.emptyList();
	}

	/**
	 * Default implementation simply returns <code>null</code>.
	 */
	public EStructuralFeature getFeature() {
		return null;
	}

	/**
	 * Default implementation simply returns <code>null</code>.
	 */
	public Object getFeatureNewValue() {
		return null;
	}
	
	// implements the interface method
	public void disableCurrentConstraint(Throwable exception) {
		assert exception != null;
		
		getDescriptor().setError(exception);
	}
	
	// implements the interface method
	public void skipCurrentConstraintFor(EObject eObject) {
		ignoredConstraints.ignore(eObject, getDescriptor());
	}
	
	// implements the interface method
	public void skipCurrentConstraintForAll(Collection<?> eObjects) {
		for (Object next : eObjects) {
			if (next instanceof EObject) {
				skipCurrentConstraintFor((EObject)next);
			}
		}
	}
	
	/**
	 * Gets an iteration filter that can be used to filter out the constraints
	 * in a validation operation that do not need to be evaluated in this
	 * context (either because they are disabled or have already been evaluated
	 * on the current target object in this validation context).
	 * 
	 * @return a constraint filter for this context
	 */
	public FilteredCollection.Filter<IModelConstraint> getConstraintFilter() {
		if (filter == null) {
			filter = new ConstraintFilter();
		}
		
		return filter;
	}
	
	/**
	 * Queries whether the current constraint in this context is disabled.
	 * 
	 * @return <CODE>true</CODE> if the current constraint is disabled,
	 *    <CODE>false</CODE>, otherwise
	 */
	public boolean isDisabled() {
		return !getDescriptor().isEnabled();
	}
	
	// implements the interface method
	public final Object getCurrentConstraintData() {
		return constraintData.get(getConstraint());
	}
	
	// implements the interface method
	public final Object putCurrentConstraintData(Object newData) {
		return constraintData.put(getConstraint(), newData);
	}
	
	/**
	 * Provides a way to get the original notification that triggered the
	 *  live validation if this context is being used in a live validation
	 *  context.
	 * 
	 * @return A notification object that was generated and caused live validation
	 *  to occur or null if this is batch validation.
	 */
	public Notification getNotification() {
		return null;
	}
	
	/**
	 * Initializes the result locus to include just the target object.
	 */
	void initializeResultLocus() {
		resultLocus.clear();
		resultLocus.add(getTarget());
	}
	
	// implements the interface method
	public void addResult(EObject eObject) {
		assert eObject != null;
		
		resultLocus.add(eObject);
	}
	
	public void addResults(Collection<? extends EObject> eObjects) {
		assert eObjects != null;
		
		// explicitly iterate instead of calling resultLocus.addAll() in order
		//    to assert the types of the elements by casting
		for (EObject next : eObjects) {
			addResult(next);
		}
	}
	
	// implements the interface method
	public Set<EObject> getResultLocus() {
		return java.util.Collections.unmodifiableSet(resultLocus);
	}
	
	// implements the interface method
	public final String getCurrentConstraintId() {
		return getConstraint().getDescriptor().getId();
	}
	
	/**
	 * Obtains the constraint currently being evaluated.
	 * 
	 * @return the current constraint
	 */
	final IModelConstraint getConstraint() {
		return currentConstraint;
	}
	
	/**
	 * Obtains the descriptor of the constraint currently being evaluated.
	 * 
	 * @return the current constraint'sdescriptor
	 */
	final IConstraintDescriptor getDescriptor() {
		return currentDescriptor;
	}
	
	/**
	 * Sets the constraint currently being evaluated.
	 * 
	 * @param constraint the current constraint
	 */
	private void setConstraint(IModelConstraint constraint) {
		currentConstraint = constraint;
		currentDescriptor = constraint.getDescriptor();
	}

	// implements the interface method
	public final EObject getTarget() {
		return getOperation().getEObject();
	}
	
	/**
	 * Queries whether successful validations are reported.  If successful
	 * validations are not to be reported, then I return a shared "OK" status
	 * object from the {@link #createSuccessStatus()} method that has no
	 * information about the constraint that was evaluated.
	 * 
	 * @return whether we report successes
	 */
	public boolean isReportSuccesses() {
		return reportSuccesses;
	}
	
	/**
	 * Sets whether successful validations are reported.
	 * 
	 * @param b whether successful validations are reported
	 * 
	 * @see #isReportSuccesses()
	 */
	void setReportSuccesses(boolean b) {
		this.reportSuccesses = b;
	}

	// implements the interface method
	public IStatus createSuccessStatus() {
		if (Trace.shouldTrace(EMFModelValidationDebugOptions.CONSTRAINTS_EVALUATION)) {
			Trace.trace(
					EMFModelValidationDebugOptions.CONSTRAINTS_EVALUATION,
					"Constraint " + getCurrentConstraintId() + " passed.");  //$NON-NLS-1$//$NON-NLS-2$
		}
		
		return isReportSuccesses()
			? new SuccessStatus(getTarget(), getConstraint())
			: Status.OK_STATUS;
	}

	// implements the interface method
	public IStatus createFailureStatus(Object... messageArgs) {
		
		String message = TextUtils.formatMessage(
				getDescriptor().getMessagePattern(),
				(messageArgs == null) ? new Object[0] : messageArgs);
		
		if (Trace.shouldTrace(EMFModelValidationDebugOptions.CONSTRAINTS_EVALUATION)) {
			Trace.trace(
					EMFModelValidationDebugOptions.CONSTRAINTS_EVALUATION,
					"Constraint " + getCurrentConstraintId() + " failed: " + message);  //$NON-NLS-1$//$NON-NLS-2$
		}
		
		return new ConstraintStatus(
				getConstraint(),
				getTarget(),
				message,
				getResultLocus());
	}
	
	/**
	 * Obtains the constraints in my context.
	 * 
	 * @return my constraints
	 */
//	  final Collection<IModelConstraint> getConstraints() {
		// use only those constraints that match the client contexts
//		final Collection<IModelConstraint> delegate = ClientContextManager.getInstance().getBindings(
//				clientContexts,
//				getOperation().getConstraints());
//		
//		// wraps my constraints collection's iterator in order to access
//		//    the descriptor of each constraint as it is traversed
//		class ConstraintsIterator implements Iterator<IModelConstraint> {
//			private final Iterator<? extends IModelConstraint> delegateIterator;
//
//			ConstraintsIterator(Collection<? extends IModelConstraint> delegateCollection) {
//				this.delegateIterator = delegateCollection.iterator();
//			}
//			
//			// implements the interface method
//			public boolean hasNext() {
//				return delegateIterator.hasNext();
//			}
//	
//			// implements the interface method, additionally setting attributes
//			//    of the enclosing context object from the next constraint
//			//    descriptor
//			public IModelConstraint next() {
//				IModelConstraint result = delegateIterator.next();
//				
//				// make this descriptor available in the context
//				setConstraint(result);
//				
//				// set the default result locus for this next constraint
//				MyAbstractValidationContext.this.initializeResultLocus();
//				
//				return result;
//			}
//	
//			// this collection is not modifiable
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}}
		
//		return new AbstractCollection<IModelConstraint>() {
//			@Override
//			public Iterator<IModelConstraint> iterator() {
//				return new ConstraintsIterator(delegate);
//			}
//
//			@Override
//			public int size() {
//				return delegate.size();
//			}};
//	}
	
	/**
	 * Assigns my current client contexts.  <b>Note</b> that this method does
	 * not copy the collection.
	 * 
	 * @param clientContexts a collection of
	 *    {@link org.eclipse.emf.validation.internal.service.IClientContext}s
	 *    or <code>null</code> to specify none
	 */
	final void setClientContexts(Collection<IClientContext> clientContexts) {
		if (clientContexts == null) {
			clientContexts = Collections.emptySet();
		}
		
		this.clientContexts = clientContexts;
	}
	
	/**
	 * Obtains my current client contexts.  <b>Note</b> that the result should
	 * not be modified (it may actually be modifiable, or it may not).
	 * 
	 * @return a collection of
	 *    {@link org.eclipse.emf.validation.internal.service.IClientContext}s
	 */
	final Collection<IClientContext> getClientContexts() {
		return clientContexts;
	}
	
	private static class SuccessStatus extends Status implements IConstraintStatus {
		private final EObject target;
		private final IModelConstraint constraint;
		
		SuccessStatus(EObject target, IModelConstraint constraint) {
			super(
				IStatus.OK,
				EMFModelValidationPlugin.getPluginId(),
				IModelConstraint.STATUS_CODE_SUCCESS,
				EMFModelValidationStatusCodes.CONSTRAINT_SUCCESS_MSG,
				null);
			
			this.target = target;
			this.constraint = constraint;
		}

		/* (non-Javadoc)
		 * Implements the inherited method.
		 */
		public IModelConstraint getConstraint() {
			return constraint;
		}

		/* (non-Javadoc)
		 * Implements the inherited method.
		 */
		public EObject getTarget() {
			return target;
		}

		/* (non-Javadoc)
		 * Implements the inherited method.
		 */
		public Set<EObject> getResultLocus() {
			return Collections.emptySet();
		}
	}
}
