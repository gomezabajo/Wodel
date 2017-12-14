/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Retyped</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.ObjectRetyped#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.ObjectRetyped#getRemovedObject <em>Removed Object</em>}</li>
 *   <li>{@link appliedMutations.ObjectRetyped#getType <em>Type</em>}</li>
 *   <li>{@link appliedMutations.ObjectRetyped#getNewType <em>New Type</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getObjectRetyped()
 * @model
 * @generated
 */
public interface ObjectRetyped extends AppMutation {
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
	 * @see appliedMutations.AppliedMutationsPackage#getObjectRetyped_Object()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getObject();

	/**
	 * Returns the value of the '<em><b>Removed Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Removed Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Removed Object</em>' reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getObjectRetyped_RemovedObject()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getRemovedObject();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see appliedMutations.AppliedMutationsPackage#getObjectRetyped_Type()
	 * @model
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link appliedMutations.ObjectRetyped#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>New Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Type</em>' reference.
	 * @see #setNewType(EClass)
	 * @see appliedMutations.AppliedMutationsPackage#getObjectRetyped_NewType()
	 * @model
	 * @generated
	 */
	EClass getNewType();

	/**
	 * Sets the value of the '{@link appliedMutations.ObjectRetyped#getNewType <em>New Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Type</em>' reference.
	 * @see #getNewType()
	 * @generated
	 */
	void setNewType(EClass value);

} // ObjectRetyped
