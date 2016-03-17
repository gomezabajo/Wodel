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
 * <ul>
 *   <li>{@link appliedMutations.ReferenceSwap#getRefObject <em>Ref Object</em>}</li>
 *   <li>{@link appliedMutations.ReferenceSwap#getFirstName <em>First Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see appliedMutations.AppliedMutationsPackage#getReferenceSwap()
 * @model
 * @generated
 */
public interface ReferenceSwap extends ReferenceChanged {
	/**
	 * Returns the value of the '<em><b>Ref Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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

} // ReferenceSwap
