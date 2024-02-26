/**
 */
package edutest;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.TestConfiguration#isRetry <em>Retry</em>}</li>
 *   <li>{@link edutest.TestConfiguration#getMode <em>Mode</em>}</li>
 *   <li>{@link edutest.TestConfiguration#getStatement <em>Statement</em>}</li>
 *   <li>{@link edutest.TestConfiguration#getAnswers <em>Answers</em>}</li>
 * </ul>
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

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link edutest.Mode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see edutest.Mode
	 * @see #setMode(Mode)
	 * @see edutest.EdutestPackage#getTestConfiguration_Mode()
	 * @model
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link edutest.TestConfiguration#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see edutest.Mode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' reference.
	 * @see #setStatement(EClass)
	 * @see edutest.EdutestPackage#getTestConfiguration_Statement()
	 * @model
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Sets the value of the '{@link edutest.TestConfiguration#getStatement <em>Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(EClass value);

	/**
	 * Returns the value of the '<em><b>Answers</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Answers</em>' reference.
	 * @see #setAnswers(EClass)
	 * @see edutest.EdutestPackage#getTestConfiguration_Answers()
	 * @model
	 * @generated
	 */
	EClass getAnswers();

	/**
	 * Sets the value of the '{@link edutest.TestConfiguration#getAnswers <em>Answers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Answers</em>' reference.
	 * @see #getAnswers()
	 * @generated
	 */
	void setAnswers(EClass value);

} // TestConfiguration
