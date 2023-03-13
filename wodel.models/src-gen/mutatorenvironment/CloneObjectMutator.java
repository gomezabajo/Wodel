/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clone Object Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.CloneObjectMutator#isContents <em>Contents</em>}</li>
 *   <li>{@link mutatorenvironment.CloneObjectMutator#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.CloneObjectMutator#getContainer <em>Container</em>}</li>
 *   <li>{@link mutatorenvironment.CloneObjectMutator#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.CloneObjectMutator#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatorenvironment.CloneObjectMutator#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getCloneObjectMutator()
 * @model
 * @generated
 */
public interface CloneObjectMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' attribute.
	 * @see #setContents(boolean)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCloneObjectMutator_Contents()
	 * @model default="false" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ListType' unique='false' upper='*'"
	 * @generated
	 */
	boolean isContents();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CloneObjectMutator#isContents <em>Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contents</em>' attribute.
	 * @see #isContents()
	 * @generated
	 */
	void setContents(boolean value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference.
	 * @see #setObject(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCloneObjectMutator_Object()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getObject();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CloneObjectMutator#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCloneObjectMutator_Container()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getContainer();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CloneObjectMutator#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Type</em>' reference.
	 * @see #setRefType(EReference)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCloneObjectMutator_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.CloneObjectMutator#getRefType <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' reference.
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(EReference value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.AttributeSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCloneObjectMutator_Attributes()
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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCloneObjectMutator_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceSet> getReferences();

} // CloneObjectMutator
