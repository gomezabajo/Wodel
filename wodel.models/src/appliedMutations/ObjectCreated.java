/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Created</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.ObjectCreated#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getObjectCreated()
 * @model
 * @generated
 */
public interface ObjectCreated extends AppMutation {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getObjectCreated_Object()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getObject();

} // ObjectCreated
