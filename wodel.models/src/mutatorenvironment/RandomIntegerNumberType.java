/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Integer Number Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.RandomIntegerNumberType#getMin <em>Min</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomIntegerNumberType()
 * @model
 * @generated
 */
public interface RandomIntegerNumberType extends RandomNumberType {
	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(int)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomIntegerNumberType_Min()
	 * @model required="true"
	 * @generated
	 */
	int getMin();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomIntegerNumberType#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(int value);

} // RandomIntegerNumberType
