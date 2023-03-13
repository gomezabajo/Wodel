/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Object Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.CreateObjectMutator#getContainer <em>Container</em>}</li>
 *   <li>{@link mutatorenvironment.CreateObjectMutator#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatorenvironment.CreateObjectMutator#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator()
 * @model
 * @generated
 */
public interface CreateObjectMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator_Container()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getContainer();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CreateObjectMutator#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.AttributeSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeSet> getAttributes();

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.ReferenceSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceSet> getReferences();

} // CreateObjectMutator
