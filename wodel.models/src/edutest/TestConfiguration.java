/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edutest.TestConfiguration#isRetry <em>Retry</em>}</li>
 * </ul>
 * </p>
 *
 * @see edutest.EdutestPackage#getTestConfiguration()
 * @model
 * @generated
 */
public interface TestConfiguration extends Configuration {
	/**
	 * Returns the value of the '<em><b>Retry</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry</em>' attribute.
	 * @see #setRetry(boolean)
	 * @see edutest.EdutestPackage#getTestConfiguration_Retry()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRetry();

	/**
	 * Sets the value of the '{@link edutest.TestConfiguration#isRetry <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry</em>' attribute.
	 * @see #isRetry()
	 * @generated
	 */
	void setRetry(boolean value);

} // TestConfiguration
