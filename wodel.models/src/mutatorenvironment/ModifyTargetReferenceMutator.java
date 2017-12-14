/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modify Target Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.ModifyTargetReferenceMutator#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.ModifyTargetReferenceMutator#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorenvironment.ModifyTargetReferenceMutator#getNewTarget <em>New Target</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyTargetReferenceMutator()
 * @model
 * @generated
 */
public interface ModifyTargetReferenceMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Type</em>' reference.
	 * @see #setRefType(EReference)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyTargetReferenceMutator_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ModifyTargetReferenceMutator#getRefType <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' reference.
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(EReference value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyTargetReferenceMutator_Source()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getSource();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ModifyTargetReferenceMutator#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>New Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Target</em>' containment reference.
	 * @see #setNewTarget(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyTargetReferenceMutator_NewTarget()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getNewTarget();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ModifyTargetReferenceMutator#getNewTarget <em>New Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Target</em>' containment reference.
	 * @see #getNewTarget()
	 * @generated
	 */
	void setNewTarget(ObSelectionStrategy value);

} // ModifyTargetReferenceMutator
