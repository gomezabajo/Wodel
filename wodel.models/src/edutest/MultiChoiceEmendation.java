/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Choice Emendation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.MultiChoiceEmendation#getConfig <em>Config</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getMultiChoiceEmendation()
 * @model
 * @generated
 */
public interface MultiChoiceEmendation extends MutatorTests {
	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(MultiChoiceEmConfig)
	 * @see edutest.EdutestPackage#getMultiChoiceEmendation_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MultiChoiceEmConfig getConfig();

	/**
	 * Sets the value of the '{@link edutest.MultiChoiceEmendation#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(MultiChoiceEmConfig value);

} // MultiChoiceEmendation
