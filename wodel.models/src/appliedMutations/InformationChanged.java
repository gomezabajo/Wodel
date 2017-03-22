/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information Changed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.InformationChanged#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.InformationChanged#getAttChanges <em>Att Changes</em>}</li>
 *   <li>{@link appliedMutations.InformationChanged#getRefChanges <em>Ref Changes</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getInformationChanged()
 * @model
 * @generated
 */
public interface InformationChanged extends AppMutation {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getInformationChanged_Object()
	 * @model required="true"
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link appliedMutations.InformationChanged#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Att Changes</b></em>' containment reference list.
	 * The list contents are of type {@link appliedMutations.AttributeChanged}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att Changes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att Changes</em>' containment reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getInformationChanged_AttChanges()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AttributeChanged> getAttChanges();

	/**
	 * Returns the value of the '<em><b>Ref Changes</b></em>' containment reference list.
	 * The list contents are of type {@link appliedMutations.ReferenceChanged}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Changes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Changes</em>' containment reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getInformationChanged_RefChanges()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceChanged> getRefChanges();

} // InformationChanged
