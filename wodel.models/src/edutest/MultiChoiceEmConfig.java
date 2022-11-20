/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Choice Em Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.MultiChoiceEmConfig#isWeighted <em>Weighted</em>}</li>
 *   <li>{@link edutest.MultiChoiceEmConfig#getPenalty <em>Penalty</em>}</li>
 *   <li>{@link edutest.MultiChoiceEmConfig#getOrder <em>Order</em>}</li>
 *   <li>{@link edutest.MultiChoiceEmConfig#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getMultiChoiceEmConfig()
 * @model
 * @generated
 */
public interface MultiChoiceEmConfig extends TestConfiguration {
	/**
	 * Returns the value of the '<em><b>Weighted</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weighted</em>' attribute.
	 * @see #setWeighted(boolean)
	 * @see edutest.EdutestPackage#getMultiChoiceEmConfig_Weighted()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isWeighted();

	/**
	 * Sets the value of the '{@link edutest.MultiChoiceEmConfig#isWeighted <em>Weighted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weighted</em>' attribute.
	 * @see #isWeighted()
	 * @generated
	 */
	void setWeighted(boolean value);

	/**
	 * Returns the value of the '<em><b>Penalty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Penalty</em>' attribute.
	 * @see #setPenalty(double)
	 * @see edutest.EdutestPackage#getMultiChoiceEmConfig_Penalty()
	 * @model required="true"
	 * @generated
	 */
	double getPenalty();

	/**
	 * Sets the value of the '{@link edutest.MultiChoiceEmConfig#getPenalty <em>Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Penalty</em>' attribute.
	 * @see #getPenalty()
	 * @generated
	 */
	void setPenalty(double value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The literals are from the enumeration {@link edutest.Order}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see edutest.Order
	 * @see #setOrder(Order)
	 * @see edutest.EdutestPackage#getMultiChoiceEmConfig_Order()
	 * @model required="true"
	 * @generated
	 */
	Order getOrder();

	/**
	 * Sets the value of the '{@link edutest.MultiChoiceEmConfig#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see edutest.Order
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(Order value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link edutest.Mode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see edutest.Mode
	 * @see #setMode(Mode)
	 * @see edutest.EdutestPackage#getMultiChoiceEmConfig_Mode()
	 * @model required="true"
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link edutest.MultiChoiceEmConfig#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see edutest.Mode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

} // MultiChoiceEmConfig
