/**
 */
package edutest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Choice Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.MultiChoiceDiagram#getConfig <em>Config</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getMultiChoiceDiagram()
 * @model
 * @generated
 */
public interface MultiChoiceDiagram extends MutatorTests {
	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(TestConfiguration)
	 * @see edutest.EdutestPackage#getMultiChoiceDiagram_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TestConfiguration getConfig();

	/**
	 * Sets the value of the '{@link edutest.MultiChoiceDiagram#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(TestConfiguration value);

} // MultiChoiceDiagram
