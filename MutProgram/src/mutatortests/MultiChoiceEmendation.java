/**
 */
package mutatortests;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Choice Emendation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatortests.MultiChoiceEmendation#getConfig <em>Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatortests.MutatortestsPackage#getMultiChoiceEmendation()
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
	 * @see mutatortests.MutatortestsPackage#getMultiChoiceEmendation_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MultiChoiceEmConfig getConfig();

	/**
	 * Sets the value of the '{@link mutatortests.MultiChoiceEmendation#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(MultiChoiceEmConfig value);

} // MultiChoiceEmendation
