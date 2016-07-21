/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edutest.AlternativeResponse#getConfig <em>Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see edutest.EdutestPackage#getAlternativeResponse()
 * @model
 * @generated
 */
public interface AlternativeResponse extends MutatorTests {
	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(TestConfiguration)
	 * @see edutest.EdutestPackage#getAlternativeResponse_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TestConfiguration getConfig();

	/**
	 * Sets the value of the '{@link edutest.AlternativeResponse#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(TestConfiguration value);

} // AlternativeResponse
