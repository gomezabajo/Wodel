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
 * <ul>
 *   <li>{@link appliedMutations.ReferenceCreated#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.ReferenceCreated#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
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
} // ReferenceCreated
