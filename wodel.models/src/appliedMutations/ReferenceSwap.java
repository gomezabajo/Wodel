/**
 */
package appliedMutations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Swap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.ReferenceSwap#getRefObject <em>Ref Object</em>}</li>
 *   <li>{@link appliedMutations.ReferenceSwap#getFirstName <em>First Name</em>}</li>
 *   <li>{@link appliedMutations.ReferenceSwap#getOtherFrom <em>Other From</em>}</li>
 *   <li>{@link appliedMutations.ReferenceSwap#getOtherFromName <em>Other From Name</em>}</li>
 *   <li>{@link appliedMutations.ReferenceSwap#getOtherTo <em>Other To</em>}</li>
 *   <li>{@link appliedMutations.ReferenceSwap#getOtherToName <em>Other To Name</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap()
 * @model
 * @generated
 */
public interface ReferenceSwap extends ReferenceChanged {
	/**
	 * Returns the value of the '<em><b>Ref Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Object</em>' reference.
	 * @see #setRefObject(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap_RefObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getRefObject();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceSwap#getRefObject <em>Ref Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Object</em>' reference.
	 * @see #getRefObject()
	 * @generated
	 */
	void setRefObject(EObject value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap_FirstName()
	 * @model required="true"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceSwap#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Other From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other From</em>' reference.
	 * @see #setOtherFrom(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap_OtherFrom()
	 * @model required="true"
	 * @generated
	 */
	EObject getOtherFrom();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceSwap#getOtherFrom <em>Other From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other From</em>' reference.
	 * @see #getOtherFrom()
	 * @generated
	 */
	void setOtherFrom(EObject value);

	/**
	 * Returns the value of the '<em><b>Other From Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other From Name</em>' attribute.
	 * @see #setOtherFromName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap_OtherFromName()
	 * @model required="true"
	 * @generated
	 */
	String getOtherFromName();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceSwap#getOtherFromName <em>Other From Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other From Name</em>' attribute.
	 * @see #getOtherFromName()
	 * @generated
	 */
	void setOtherFromName(String value);

	/**
	 * Returns the value of the '<em><b>Other To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other To</em>' reference.
	 * @see #setOtherTo(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap_OtherTo()
	 * @model required="true"
	 * @generated
	 */
	EObject getOtherTo();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceSwap#getOtherTo <em>Other To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other To</em>' reference.
	 * @see #getOtherTo()
	 * @generated
	 */
	void setOtherTo(EObject value);

	/**
	 * Returns the value of the '<em><b>Other To Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other To Name</em>' attribute.
	 * @see #setOtherToName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap_OtherToName()
	 * @model required="true"
	 * @generated
	 */
	String getOtherToName();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceSwap#getOtherToName <em>Other To Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other To Name</em>' attribute.
	 * @see #getOtherToName()
	 * @generated
	 */
	void setOtherToName(String value);

} // ReferenceSwap
