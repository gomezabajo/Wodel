package manager;

/******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.validation.internal.service.IProviderOperation;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IModelConstraintProvider;
import org.eclipse.emf.validation.util.FilteredCollection;

/**
 * Defines the common structure of all operations supplied by
 * {@link org.eclipse.emf.validation.service.IModelConstraintProvider}s.
 * 
 * @see org.eclipse.emf.validation.service.ModelValidationService
 * @see org.eclipse.emf.validation.service.IModelConstraintProvider
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class MyAbstractGetConstraintsOperation
		implements IProviderOperation<Collection<IModelConstraint>> {
	
	/** The EMF object to be validated. */
	private EObject eObject;

	/** The constraints which I have gathered from providers. */
	private final Collection<IModelConstraint> myConstraints =
		new java.util.ArrayList<IModelConstraint>();
	
	private Collection<IModelConstraint> filteredConstraints;
	
	private MyAbstractValidationContext context;

	/**
	 * Initializes me.
	 */
	public MyAbstractGetConstraintsOperation() {
		super();
	}

	/**
	 * Sets the EMF object that is to be validated.
	 * 
	 * @param eObject the EMF object (must not be <code>null</code>)
	 */
	protected final void setTarget(EObject eObject) {
		assert eObject != null;

		this.eObject = eObject;
		
		myConstraints.clear();  // getting constraints for a new target object
	}

	// implements the interface method
	public final EObject getEObject() {
		return eObject;
	}

	/**
	 * Obtains the context object that the caller must pass to each constraint
	 * that is validated.
	 * 
	 * @return the constraint evaluation context, or <code>null</code> if I have
	 *    not yet been executed
	 * 
	 * @see #execute
	 */
	final MyAbstractValidationContext getContext() {
		maybeInitializeContext();
		
		return context;
	}

	private void maybeInitializeContext() {
		// initialize the context now, if necessary
		if (context == null) {
			context = createContext();
			filteredConstraints = new FilteredCollection<IModelConstraint>(
					getUnfilteredConstraints(),
					context.getConstraintFilter());
		}
	}
	
	// implements the interface method
	public final Collection<IModelConstraint> getConstraints() {
		return filteredConstraints;
	}

	/**
	 * Obtains my constraints, not filtered by the current validation context.
	 * This should only be invoked by clients such as the constraint cache,
	 * that need the constraints outside of any validation context.
	 * 
	 * @return my full collection of constraints
	 */
	protected Collection<IModelConstraint> getUnfilteredConstraints() {
		return myConstraints;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * This is a <i>Template Method</i> encapsulating an invocation of the
	 * {@link #executeImpl} method implemented by subclasses.
	 * 
	 * @param provider a constraint provider
	 * @return my unmodifiable constraints collection
	 */
	public Collection<IModelConstraint> execute(IModelConstraintProvider provider) {
		//Trace.entering(
		//		EMFModelValidationDebugOptions.PROVIDERS,
		//		getClass(),
		//		"execute", //$NON-NLS-1$
		//		provider);
		
		//maybeInitializeContext();
		
		//executeImpl(provider, getUnfilteredConstraints());

		//Trace.exiting(
		//		EMFModelValidationDebugOptions.PROVIDERS,
		//		getClass(),
		//		"execute"); //$NON-NLS-1$

		return getUnfilteredConstraints();
	}

	/**
	 * Creates a validation context that iterates my collection of constraints,
	 * always providing the "current constraint" context.
	 * 
	 * @return the subclass's concrete implementation of the context
	 */
	protected abstract MyAbstractValidationContext createContext();
	
	/**
	 * Implemented by subclasses to invoke the appropriate <code>provider</code>
	 * method.
	 * 
	 * @param provider the provider to be invoked
	 * @param constraints the collection to which constraints are to be added 
	 */
	protected abstract void executeImpl(
			IModelConstraintProvider provider,
			Collection<IModelConstraint> constraints);
}
