/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Double Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.RandomDoubleType#getMin <em>Min</em>}</li>
 *   <li>{@link mutatorenvironment.RandomDoubleType#getMax <em>Max</em>}</li>
 *   <li>{@link mutatorenvironment.RandomDoubleType#isAllowsNull <em>Allows Null</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomDoubleType()
 * @model
 * @generated
 */
public interface RandomDoubleType extends DoubleType {
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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomDoubleType_Min()
	 * @model required="true"
	 * @generated
	 */
	double getMin();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomDoubleType#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(double value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(double)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomDoubleType_Max()
	 * @model required="true"
	 * @generated
	 */
	double getMax();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomDoubleType#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(double value);

	/**
	 * Returns the value of the '<em><b>Allows Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allows Null</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allows Null</em>' attribute.
	 * @see #setAllowsNull(boolean)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomDoubleType_AllowsNull()
	 * @model required="true"
	 * @generated
	 */
	boolean isAllowsNull();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomDoubleType#isAllowsNull <em>Allows Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allows Null</em>' attribute.
	 * @see #isAllowsNull()
	 * @generated
	 */
	void setAllowsNull(boolean value);

} // RandomDoubleType
