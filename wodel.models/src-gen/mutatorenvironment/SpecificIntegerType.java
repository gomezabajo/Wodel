/**
 */
package mutatorenvironment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Integer Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.SpecificIntegerType#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getSpecificIntegerType()
 * @model
 * @generated
 */
public interface SpecificIntegerType extends IntegerType {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getSpecificIntegerType_Value()
	 * @model required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link mutatorenvironment.SpecificIntegerType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

} // SpecificIntegerType
