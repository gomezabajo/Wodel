/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Scalar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.AttributeScalar#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeScalar()
 * @model
 * @generated
 */
public interface AttributeScalar extends AttributeSet {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(AttributeType)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeScalar_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AttributeType getValue();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeScalar#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(AttributeType value);

} // AttributeScalar
