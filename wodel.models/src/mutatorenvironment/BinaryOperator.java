/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.BinaryOperator#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getBinaryOperator()
 * @model
 * @generated
 */
public interface BinaryOperator extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorenvironment.LogicOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see mutatorenvironment.LogicOperator
	 * @see #setType(LogicOperator)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBinaryOperator_Type()
	 * @model required="true"
	 * @generated
	 */
	LogicOperator getType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.BinaryOperator#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see mutatorenvironment.LogicOperator
	 * @see #getType()
	 * @generated
	 */
	void setType(LogicOperator value);

} // BinaryOperator
