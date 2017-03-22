/**
 */
package appliedMutations;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Reference Changed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.SourceReferenceChanged#getOldFrom <em>Old From</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getSourceReferenceChanged()
 * @model
 * @generated
 */
public interface SourceReferenceChanged extends ReferenceChanged {

	/**
	 * Returns the value of the '<em><b>Old From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old From</em>' reference.
	 * @see #setOldFrom(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getSourceReferenceChanged_OldFrom()
	 * @model required="true"
	 * @generated
	 */
	EObject getOldFrom();

	/**
	 * Sets the value of the '{@link appliedMutations.SourceReferenceChanged#getOldFrom <em>Old From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old From</em>' reference.
	 * @see #getOldFrom()
	 * @generated
	 */
	void setOldFrom(EObject value);
} // SourceReferenceChanged
