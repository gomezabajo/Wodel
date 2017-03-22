/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Double Number Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.RandomDoubleNumberType#getMin <em>Min</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomDoubleNumberType()
 * @model
 * @generated
 */
public interface RandomDoubleNumberType extends RandomNumberType {
	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(double)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomDoubleNumberType_Min()
	 * @model required="true"
	 * @generated
	 */
	double getMin();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomDoubleNumberType#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(double value);

} // RandomDoubleNumberType
