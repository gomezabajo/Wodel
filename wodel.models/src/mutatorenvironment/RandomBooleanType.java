/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Boolean Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.RandomBooleanType#isAllowsNull <em>Allows Null</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomBooleanType()
 * @model
 * @generated
 */
public interface RandomBooleanType extends BooleanType {
	/**
	 * Returns the value of the '<em><b>Allows Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allows Null</em>' attribute.
	 * @see #setAllowsNull(boolean)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomBooleanType_AllowsNull()
	 * @model required="true"
	 * @generated
	 */
	boolean isAllowsNull();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomBooleanType#isAllowsNull <em>Allows Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allows Null</em>' attribute.
	 * @see #isAllowsNull()
	 * @generated
	 */
	void setAllowsNull(boolean value);

} // RandomBooleanType
