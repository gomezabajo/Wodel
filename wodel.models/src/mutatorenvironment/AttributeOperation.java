/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.AttributeOperation#getOperator <em>Operator</em>}</li>
 *   <li>{@link mutatorenvironment.AttributeOperation#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeOperation()
 * @model
 * @generated
 */
public interface AttributeOperation extends AttributeSet {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorenvironment.ArithmeticOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see mutatorenvironment.ArithmeticOperator
	 * @see #setOperator(ArithmeticOperator)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeOperation_Operator()
	 * @model required="true"
	 * @generated
	 */
	ArithmeticOperator getOperator();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeOperation#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see mutatorenvironment.ArithmeticOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(ArithmeticOperator value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(AttributeEvaluationType)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeOperation_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AttributeEvaluationType getValue();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeOperation#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(AttributeEvaluationType value);

} // AttributeOperation
