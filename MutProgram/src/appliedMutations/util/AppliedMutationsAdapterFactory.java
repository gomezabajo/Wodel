/**
 */
package appliedMutations.util;

import appliedMutations.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see appliedMutations.AppliedMutationsPackage
 * @generated
 */
public class AppliedMutationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AppliedMutationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedMutationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AppliedMutationsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppliedMutationsSwitch<Adapter> modelSwitch =
		new AppliedMutationsSwitch<Adapter>() {
			@Override
			public Adapter caseMutations(Mutations object) {
				return createMutationsAdapter();
			}
			@Override
			public Adapter caseAppMutation(AppMutation object) {
				return createAppMutationAdapter();
			}
			@Override
			public Adapter caseObjectCreated(ObjectCreated object) {
				return createObjectCreatedAdapter();
			}
			@Override
			public Adapter caseObjectRemoved(ObjectRemoved object) {
				return createObjectRemovedAdapter();
			}
			@Override
			public Adapter caseReferenceChanged(ReferenceChanged object) {
				return createReferenceChangedAdapter();
			}
			@Override
			public Adapter caseSourceReferenceChanged(SourceReferenceChanged object) {
				return createSourceReferenceChangedAdapter();
			}
			@Override
			public Adapter caseTargetReferenceChanged(TargetReferenceChanged object) {
				return createTargetReferenceChangedAdapter();
			}
			@Override
			public Adapter caseReferenceCreated(ReferenceCreated object) {
				return createReferenceCreatedAdapter();
			}
			@Override
			public Adapter caseReferenceRemoved(ReferenceRemoved object) {
				return createReferenceRemovedAdapter();
			}
			@Override
			public Adapter caseInformationChanged(InformationChanged object) {
				return createInformationChangedAdapter();
			}
			@Override
			public Adapter caseAttributeChanged(AttributeChanged object) {
				return createAttributeChangedAdapter();
			}
			@Override
			public Adapter caseReferenceSwap(ReferenceSwap object) {
				return createReferenceSwapAdapter();
			}
			@Override
			public Adapter caseAttributeSwap(AttributeSwap object) {
				return createAttributeSwapAdapter();
			}
			@Override
			public Adapter caseCompositeMutation(CompositeMutation object) {
				return createCompositeMutationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.Mutations <em>Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.Mutations
	 * @generated
	 */
	public Adapter createMutationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.AppMutation <em>App Mutation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.AppMutation
	 * @generated
	 */
	public Adapter createAppMutationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.ObjectCreated <em>Object Created</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.ObjectCreated
	 * @generated
	 */
	public Adapter createObjectCreatedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.ObjectRemoved <em>Object Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.ObjectRemoved
	 * @generated
	 */
	public Adapter createObjectRemovedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.ReferenceChanged <em>Reference Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.ReferenceChanged
	 * @generated
	 */
	public Adapter createReferenceChangedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.SourceReferenceChanged <em>Source Reference Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.SourceReferenceChanged
	 * @generated
	 */
	public Adapter createSourceReferenceChangedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.TargetReferenceChanged <em>Target Reference Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.TargetReferenceChanged
	 * @generated
	 */
	public Adapter createTargetReferenceChangedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.ReferenceCreated <em>Reference Created</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.ReferenceCreated
	 * @generated
	 */
	public Adapter createReferenceCreatedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.ReferenceRemoved <em>Reference Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.ReferenceRemoved
	 * @generated
	 */
	public Adapter createReferenceRemovedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.InformationChanged <em>Information Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.InformationChanged
	 * @generated
	 */
	public Adapter createInformationChangedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.AttributeChanged <em>Attribute Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.AttributeChanged
	 * @generated
	 */
	public Adapter createAttributeChangedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.ReferenceSwap <em>Reference Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.ReferenceSwap
	 * @generated
	 */
	public Adapter createReferenceSwapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.AttributeSwap <em>Attribute Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.AttributeSwap
	 * @generated
	 */
	public Adapter createAttributeSwapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link appliedMutations.CompositeMutation <em>Composite Mutation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see appliedMutations.CompositeMutation
	 * @generated
	 */
	public Adapter createCompositeMutationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AppliedMutationsAdapterFactory
