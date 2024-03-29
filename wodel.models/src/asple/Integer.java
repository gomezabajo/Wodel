/**
 */
package asple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link asple.Integer#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see asple.AsplePackage#getInteger()
 * @model
 * @generated
 */
public interface Integer extends Literal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see asple.AsplePackage#getInteger_Value()
	 * @model required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link asple.Integer#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

} // Integer
