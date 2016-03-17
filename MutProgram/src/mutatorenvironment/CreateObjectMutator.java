/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Object Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.CreateObjectMutator#getContainer <em>Container</em>}</li>
 *   <li>{@link mutatorenvironment.CreateObjectMutator#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatorenvironment.CreateObjectMutator#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.CreateObjectMutator#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator()
 * @model
 * @generated
 */
public interface CreateObjectMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeSet> getAttributes();

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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CreateObjectMutator#getRefType <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' reference.
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(EReference value);

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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCreateObjectMutator_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceSet> getReferences();

} // CreateObjectMutator
