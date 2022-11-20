/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.AlternativeText#getConfig <em>Config</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getAlternativeText()
 * @model
 * @generated
 */
public interface AlternativeText extends MutatorTests {
	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(TextConfiguration)
	 * @see edutest.EdutestPackage#getAlternativeText_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TextConfiguration getConfig();

	/**
	 * Sets the value of the '{@link edutest.AlternativeText#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(TextConfiguration value);

} // AlternativeText
