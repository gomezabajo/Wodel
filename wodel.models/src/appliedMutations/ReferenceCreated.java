/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Created</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.ReferenceCreated#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.ReferenceCreated#getRef <em>Ref</em>}</li>
 *   <li>{@link appliedMutations.ReferenceCreated#getRefName <em>Ref Name</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getReferenceCreated()
 * @model
 * @generated
 */
public interface ReferenceCreated extends AppMutation {

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
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceCreated_Object()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getObject();

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceCreated_Ref()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EReference> getRef();

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
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceCreated_RefName()
	 * @model required="true"
	 * @generated
	 */
	String getRefName();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceCreated#getRefName <em>Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Name</em>' attribute.
	 * @see #getRefName()
	 * @generated
	 */
	void setRefName(String value);
} // ReferenceCreated
