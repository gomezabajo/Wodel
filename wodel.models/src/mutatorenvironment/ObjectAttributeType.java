/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.ObjectAttributeType#getObjSel <em>Obj Sel</em>}</li>
 *   <li>{@link mutatorenvironment.ObjectAttributeType#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link mutatorenvironment.ObjectAttributeType#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectAttributeType()
 * @model
 * @generated
 */
public interface ObjectAttributeType extends AttributeEvaluationType {
	/**
	 * Returns the value of the '<em><b>Obj Sel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Sel</em>' reference.
	 * @see #setObjSel(ObjectEmitter)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectAttributeType_ObjSel()
	 * @model required="true"
	 * @generated
	 */
	ObjectEmitter getObjSel();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObjectAttributeType#getObjSel <em>Obj Sel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj Sel</em>' reference.
	 * @see #getObjSel()
	 * @generated
	 */
	void setObjSel(ObjectEmitter value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectAttributeType_Attribute()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObjectAttributeType#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorenvironment.Operator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see mutatorenvironment.Operator
	 * @see #setOperator(Operator)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectAttributeType_Operator()
	 * @model required="true"
	 * @generated
	 */
	Operator getOperator();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObjectAttributeType#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see mutatorenvironment.Operator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operator value);

} // ObjectAttributeType
