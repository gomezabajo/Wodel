/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Removed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.ObjectRemoved#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getObjectRemoved()
 * @model
 * @generated
 */
public interface ObjectRemoved extends AppMutation {
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
	 * @see appliedMutations.AppliedMutationsPackage#getObjectRemoved_Object()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getObject();

} // ObjectRemoved
