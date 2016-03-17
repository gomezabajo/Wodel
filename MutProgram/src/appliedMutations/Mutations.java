/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link appliedMutations.Mutations#getMuts <em>Muts</em>}</li>
 * </ul>
 * </p>
 *
 * @see appliedMutations.AppliedMutationsPackage#getMutations()
 * @model
 * @generated
 */
public interface Mutations extends EObject {
	/**
	 * Returns the value of the '<em><b>Muts</b></em>' containment reference list.
	 * The list contents are of type {@link appliedMutations.AppMutation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Muts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Muts</em>' containment reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getMutations_Muts()
	 * @model containment="true"
	 * @generated
	 */
	EList<AppMutation> getMuts();

} // Mutations
