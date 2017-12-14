/**
 */
package appliedMutations.util;

import appliedMutations.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see appliedMutations.AppliedMutationsPackage
 * @generated
 */
public class AppliedMutationsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AppliedMutationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedMutationsSwitch() {
		if (modelPackage == null) {
			modelPackage = AppliedMutationsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AppliedMutationsPackage.MUTATIONS: {
				Mutations mutations = (Mutations)theEObject;
				T result = caseMutations(mutations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.APP_MUTATION: {
				AppMutation appMutation = (AppMutation)theEObject;
				T result = caseAppMutation(appMutation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.OBJECT_CREATED: {
				ObjectCreated objectCreated = (ObjectCreated)theEObject;
				T result = caseObjectCreated(objectCreated);
				if (result == null) result = caseAppMutation(objectCreated);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.OBJECT_REMOVED: {
				ObjectRemoved objectRemoved = (ObjectRemoved)theEObject;
				T result = caseObjectRemoved(objectRemoved);
				if (result == null) result = caseAppMutation(objectRemoved);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.REFERENCE_CHANGED: {
				ReferenceChanged referenceChanged = (ReferenceChanged)theEObject;
				T result = caseReferenceChanged(referenceChanged);
				if (result == null) result = caseAppMutation(referenceChanged);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED: {
				SourceReferenceChanged sourceReferenceChanged = (SourceReferenceChanged)theEObject;
				T result = caseSourceReferenceChanged(sourceReferenceChanged);
				if (result == null) result = caseReferenceChanged(sourceReferenceChanged);
				if (result == null) result = caseAppMutation(sourceReferenceChanged);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.TARGET_REFERENCE_CHANGED: {
				TargetReferenceChanged targetReferenceChanged = (TargetReferenceChanged)theEObject;
				T result = caseTargetReferenceChanged(targetReferenceChanged);
				if (result == null) result = caseReferenceChanged(targetReferenceChanged);
				if (result == null) result = caseAppMutation(targetReferenceChanged);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.REFERENCE_CREATED: {
				ReferenceCreated referenceCreated = (ReferenceCreated)theEObject;
				T result = caseReferenceCreated(referenceCreated);
				if (result == null) result = caseAppMutation(referenceCreated);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.REFERENCE_REMOVED: {
				ReferenceRemoved referenceRemoved = (ReferenceRemoved)theEObject;
				T result = caseReferenceRemoved(referenceRemoved);
				if (result == null) result = caseAppMutation(referenceRemoved);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.INFORMATION_CHANGED: {
				InformationChanged informationChanged = (InformationChanged)theEObject;
				T result = caseInformationChanged(informationChanged);
				if (result == null) result = caseAppMutation(informationChanged);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED: {
				AttributeChanged attributeChanged = (AttributeChanged)theEObject;
				T result = caseAttributeChanged(attributeChanged);
				if (result == null) result = caseAppMutation(attributeChanged);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.REFERENCE_SWAP: {
				ReferenceSwap referenceSwap = (ReferenceSwap)theEObject;
				T result = caseReferenceSwap(referenceSwap);
				if (result == null) result = caseReferenceChanged(referenceSwap);
				if (result == null) result = caseAppMutation(referenceSwap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.REFERENCE_ATT: {
				ReferenceAtt referenceAtt = (ReferenceAtt)theEObject;
				T result = caseReferenceAtt(referenceAtt);
				if (result == null) result = caseReferenceChanged(referenceAtt);
				if (result == null) result = caseAppMutation(referenceAtt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.ATTRIBUTE_SWAP: {
				AttributeSwap attributeSwap = (AttributeSwap)theEObject;
				T result = caseAttributeSwap(attributeSwap);
				if (result == null) result = caseAttributeChanged(attributeSwap);
				if (result == null) result = caseAppMutation(attributeSwap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.COMPOSITE_MUTATION: {
				CompositeMutation compositeMutation = (CompositeMutation)theEObject;
				T result = caseCompositeMutation(compositeMutation);
				if (result == null) result = caseAppMutation(compositeMutation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.OBJECT_CLONED: {
				ObjectCloned objectCloned = (ObjectCloned)theEObject;
				T result = caseObjectCloned(objectCloned);
				if (result == null) result = caseAppMutation(objectCloned);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppliedMutationsPackage.OBJECT_RETYPED: {
				ObjectRetyped objectRetyped = (ObjectRetyped)theEObject;
				T result = caseObjectRetyped(objectRetyped);
				if (result == null) result = caseAppMutation(objectRetyped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutations(Mutations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>App Mutation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>App Mutation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppMutation(AppMutation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Created</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Created</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectCreated(ObjectCreated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Removed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Removed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectRemoved(ObjectRemoved object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Changed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Changed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceChanged(ReferenceChanged object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Reference Changed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Reference Changed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceReferenceChanged(SourceReferenceChanged object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Reference Changed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Reference Changed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetReferenceChanged(TargetReferenceChanged object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Created</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Created</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceCreated(ReferenceCreated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Removed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Removed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceRemoved(ReferenceRemoved object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information Changed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information Changed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInformationChanged(InformationChanged object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Changed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Changed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChanged(AttributeChanged object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Swap</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Swap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceSwap(ReferenceSwap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Att</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Att</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceAtt(ReferenceAtt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Swap</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Swap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeSwap(AttributeSwap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Mutation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Mutation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeMutation(CompositeMutation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Cloned</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Cloned</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectCloned(ObjectCloned object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Retyped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Retyped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectRetyped(ObjectRetyped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AppliedMutationsSwitch
