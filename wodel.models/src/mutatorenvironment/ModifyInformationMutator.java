/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modify Information Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.ModifyInformationMutator#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.ModifyInformationMutator#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatorenvironment.ModifyInformationMutator#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyInformationMutator()
 * @model
 * @generated
 */
public interface ModifyInformationMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference.
	 * @see #setObject(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyInformationMutator_Object()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getObject();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ModifyInformationMutator#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.AttributeSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyInformationMutator_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeSet> getAttributes();

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.ReferenceSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getModifyInformationMutator_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceSet> getReferences();

} // ModifyInformationMutator
