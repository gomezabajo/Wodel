/**
 */
package appliedMutations;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Reference Changed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link appliedMutations.TargetReferenceChanged#getOldTo <em>Old To</em>}</li>
 * </ul>
 * </p>
 *
 * @see appliedMutations.AppliedMutationsPackage#getTargetReferenceChanged()
 * @model
 * @generated
 */
public interface TargetReferenceChanged extends ReferenceChanged {

	/**
	 * Returns the value of the '<em><b>Old To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old To</em>' reference.
	 * @see #setOldTo(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getTargetReferenceChanged_OldTo()
	 * @model required="true"
	 * @generated
	 */
	EObject getOldTo();

	/**
	 * Sets the value of the '{@link appliedMutations.TargetReferenceChanged#getOldTo <em>Old To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old To</em>' reference.
	 * @see #getOldTo()
	 * @generated
	 */
	void setOldTo(EObject value);
} // TargetReferenceChanged
