/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.AttributeType#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeType()
 * @model abstract="true"
 * @generated
 */
public interface AttributeType extends AttributeEvaluationType {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorenvironment.Operator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see mutatorenvironment.Operator
	 * @see #setOperator(Operator)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeType_Operator()
	 * @model required="true"
	 * @generated
	 */
	Operator getOperator();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeType#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see mutatorenvironment.Operator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operator value);

} // AttributeType
