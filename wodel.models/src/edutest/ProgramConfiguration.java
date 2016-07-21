/**
 */
package edutest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edutest.ProgramConfiguration#getNavigation <em>Navigation</em>}</li>
 * </ul>
 * </p>
 *
 * @see edutest.EdutestPackage#getProgramConfiguration()
 * @model
 * @generated
 */
public interface ProgramConfiguration extends Configuration {
	/**
	 * Returns the value of the '<em><b>Navigation</b></em>' attribute.
	 * The literals are from the enumeration {@link edutest.Navigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigation</em>' attribute.
	 * @see edutest.Navigation
	 * @see #setNavigation(Navigation)
	 * @see edutest.EdutestPackage#getProgramConfiguration_Navigation()
	 * @model required="true"
	 * @generated
	 */
	Navigation getNavigation();

	/**
	 * Sets the value of the '{@link edutest.ProgramConfiguration#getNavigation <em>Navigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigation</em>' attribute.
	 * @see edutest.Navigation
	 * @see #getNavigation()
	 * @generated
	 */
	void setNavigation(Navigation value);

} // ProgramConfiguration
