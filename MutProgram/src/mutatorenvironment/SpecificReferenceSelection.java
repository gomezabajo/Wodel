/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Reference Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.SpecificReferenceSelection#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.SpecificReferenceSelection#getObjectEmitter <em>Object Emitter</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getSpecificReferenceSelection()
 * @model
 * @generated
 */
public interface SpecificReferenceSelection extends SpecificSelection {
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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getSpecificReferenceSelection_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.SpecificReferenceSelection#getRefType <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' reference.
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(EReference value);

	/**
	 * Returns the value of the '<em><b>Object Emitter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Emitter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Emitter</em>' containment reference.
	 * @see #setObjectEmitter(ObjectEmitter)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getSpecificReferenceSelection_ObjectEmitter()
	 * @model containment="true"
	 * @generated
	 */
	ObjectEmitter getObjectEmitter();

	/**
	 * Sets the value of the '{@link mutatorenvironment.SpecificReferenceSelection#getObjectEmitter <em>Object Emitter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Emitter</em>' containment reference.
	 * @see #getObjectEmitter()
	 * @generated
	 */
	void setObjectEmitter(ObjectEmitter value);

} // SpecificReferenceSelection
