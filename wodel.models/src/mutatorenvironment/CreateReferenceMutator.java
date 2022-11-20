/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.CreateReferenceMutator#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorenvironment.CreateReferenceMutator#getTarget <em>Target</em>}</li>
 *   <li>{@link mutatorenvironment.CreateReferenceMutator#getRefType <em>Ref Type</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateReferenceMutator()
 * @model
 * @generated
 */
public interface CreateReferenceMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateReferenceMutator_Source()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getSource();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CreateReferenceMutator#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateReferenceMutator_Target()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getTarget();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CreateReferenceMutator#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Type</em>' reference.
	 * @see #setRefType(EReference)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateReferenceMutator_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CreateReferenceMutator#getRefType <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' reference.
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(EReference value);

} // CreateReferenceMutator
