/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modify Source Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.ModifySourceReferenceMutator#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.ModifySourceReferenceMutator#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorenvironment.ModifySourceReferenceMutator#getNewSource <em>New Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getModifySourceReferenceMutator()
 * @model
 * @generated
 */
public interface ModifySourceReferenceMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Type</em>' reference.
	 * @see #setRefType(EReference)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifySourceReferenceMutator_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ModifySourceReferenceMutator#getRefType <em>Ref Type</em>}' reference.
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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifySourceReferenceMutator_Source()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getSource();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ModifySourceReferenceMutator#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>New Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Source</em>' containment reference.
	 * @see #setNewSource(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifySourceReferenceMutator_NewSource()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getNewSource();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ModifySourceReferenceMutator#getNewSource <em>New Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Source</em>' containment reference.
	 * @see #getNewSource()
	 * @generated
	 */
	void setNewSource(ObSelectionStrategy value);

} // ModifySourceReferenceMutator
