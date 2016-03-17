/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.ReferenceSet#getReference <em>Reference</em>}</li>
 *   <li>{@link mutatorenvironment.ReferenceSet#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.ReferenceSet#getRefType <em>Ref Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getReferenceSet()
 * @model
 * @generated
 */
public interface ReferenceSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getReferenceSet_Reference()
	 * @model
	 * @generated
	 */
	EList<EReference> getReference();

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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getReferenceSet_Object()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getObject();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ReferenceSet#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObSelectionStrategy value);

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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getReferenceSet_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ReferenceSet#getRefType <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' reference.
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(EReference value);

} // ReferenceSet
