/**
 */
package appliedMutations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Swap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.AttributeSwap#getAttObject <em>Att Object</em>}</li>
 *   <li>{@link appliedMutations.AttributeSwap#getFirstName <em>First Name</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getAttributeSwap()
 * @model
 * @generated
 */
public interface AttributeSwap extends AttributeChanged {
	/**
	 * Returns the value of the '<em><b>Att Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att Object</em>' reference.
	 * @see #setAttObject(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getAttributeSwap_AttObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getAttObject();

	/**
	 * Sets the value of the '{@link appliedMutations.AttributeSwap#getAttObject <em>Att Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att Object</em>' reference.
	 * @see #getAttObject()
	 * @generated
	 */
	void setAttObject(EObject value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getAttributeSwap_FirstName()
	 * @model required="true"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link appliedMutations.AttributeSwap#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

} // AttributeSwap
