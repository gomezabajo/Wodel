/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Changed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.ReferenceChanged#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.ReferenceChanged#getSrcRefName <em>Src Ref Name</em>}</li>
 *   <li>{@link appliedMutations.ReferenceChanged#getFrom <em>From</em>}</li>
 *   <li>{@link appliedMutations.ReferenceChanged#getRefName <em>Ref Name</em>}</li>
 *   <li>{@link appliedMutations.ReferenceChanged#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getReferenceChanged()
 * @model
 * @generated
 */
public interface ReferenceChanged extends AppMutation {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceChanged_Object()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getObject();

	/**
	 * Returns the value of the '<em><b>Src Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Ref Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Ref Name</em>' attribute.
	 * @see #setSrcRefName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceChanged_SrcRefName()
	 * @model required="true"
	 * @generated
	 */
	String getSrcRefName();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceChanged#getSrcRefName <em>Src Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Ref Name</em>' attribute.
	 * @see #getSrcRefName()
	 * @generated
	 */
	void setSrcRefName(String value);

	/**
	 * Returns the value of the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Name</em>' attribute.
	 * @see #setRefName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceChanged_RefName()
	 * @model required="true"
	 * @generated
	 */
	String getRefName();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceChanged#getRefName <em>Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Name</em>' attribute.
	 * @see #getRefName()
	 * @generated
	 */
	void setRefName(String value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceChanged_From()
	 * @model required="true"
	 * @generated
	 */
	EObject getFrom();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceChanged#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(EObject value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceChanged_To()
	 * @model required="true"
	 * @generated
	 */
	EObject getTo();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceChanged#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(EObject value);

} // ReferenceChanged
