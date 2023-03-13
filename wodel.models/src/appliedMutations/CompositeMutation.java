/**
 */
package appliedMutations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Mutation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.CompositeMutation#getSize <em>Size</em>}</li>
 *   <li>{@link appliedMutations.CompositeMutation#getMuts <em>Muts</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getCompositeMutation()
 * @model
 * @generated
 */
public interface CompositeMutation extends AppMutation {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see appliedMutations.AppliedMutationsPackage#getCompositeMutation_Size()
	 * @model required="true"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link appliedMutations.CompositeMutation#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Muts</b></em>' containment reference list.
	 * The list contents are of type {@link appliedMutations.AppMutation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Muts</em>' containment reference list.
	 * @see appliedMutations.AppliedMutationsPackage#getCompositeMutation_Muts()
	 * @model containment="true"
	 * @generated
	 */
	EList<AppMutation> getMuts();

} // CompositeMutation
