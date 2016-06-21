/**
 */
package mutatortests;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Choice Em Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatortests.MultiChoiceEmConfig#isWeighted <em>Weighted</em>}</li>
 *   <li>{@link mutatortests.MultiChoiceEmConfig#getPenalty <em>Penalty</em>}</li>
 *   <li>{@link mutatortests.MultiChoiceEmConfig#getOrder <em>Order</em>}</li>
 *   <li>{@link mutatortests.MultiChoiceEmConfig#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatortests.MutatortestsPackage#getMultiChoiceEmConfig()
 * @model
 * @generated
 */
public interface MultiChoiceEmConfig extends TestConfiguration {
	/**
	 * Returns the value of the '<em><b>Weighted</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weighted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weighted</em>' attribute.
	 * @see #setWeighted(boolean)
	 * @see mutatortests.MutatortestsPackage#getMultiChoiceEmConfig_Weighted()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isWeighted();

	/**
	 * Sets the value of the '{@link mutatortests.MultiChoiceEmConfig#isWeighted <em>Weighted</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Penalty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Penalty</em>' attribute.
	 * @see #setPenalty(double)
	 * @see mutatortests.MutatortestsPackage#getMultiChoiceEmConfig_Penalty()
	 * @model required="true"
	 * @generated
	 */
	double getPenalty();

	/**
	 * Sets the value of the '{@link mutatortests.MultiChoiceEmConfig#getPenalty <em>Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Penalty</em>' attribute.
	 * @see #getPenalty()
	 * @generated
	 */
	void setPenalty(double value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatortests.Order}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see mutatortests.Order
	 * @see #setOrder(Order)
	 * @see mutatortests.MutatortestsPackage#getMultiChoiceEmConfig_Order()
	 * @model required="true"
	 * @generated
	 */
	Order getOrder();

	/**
	 * Sets the value of the '{@link mutatortests.MultiChoiceEmConfig#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see mutatortests.Order
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(Order value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatortests.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see mutatortests.Mode
	 * @see #setMode(Mode)
	 * @see mutatortests.MutatortestsPackage#getMultiChoiceEmConfig_Mode()
	 * @model required="true"
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link mutatortests.MultiChoiceEmConfig#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see mutatortests.Mode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

} // MultiChoiceEmConfig
