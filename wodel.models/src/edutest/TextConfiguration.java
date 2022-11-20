/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.TextConfiguration#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getTextConfiguration()
 * @model
 * @generated
 */
public interface TextConfiguration extends TestConfiguration {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see edutest.EdutestPackage#getTextConfiguration_Identifier()
	 * @model required="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link edutest.TextConfiguration#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

} // TextConfiguration
