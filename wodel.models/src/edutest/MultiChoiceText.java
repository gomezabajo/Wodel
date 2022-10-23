/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Choice Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.MultiChoiceText#getConfig <em>Config</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getMultiChoiceText()
 * @model
 * @generated
 */
public interface MultiChoiceText extends MutatorTests {
	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(MultiChoiceTextConfig)
	 * @see edutest.EdutestPackage#getMultiChoiceText_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MultiChoiceTextConfig getConfig();

	/**
	 * Sets the value of the '{@link edutest.MultiChoiceText#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(MultiChoiceTextConfig value);

} // MultiChoiceText
