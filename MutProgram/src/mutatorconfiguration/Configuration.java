/**
 */
package mutatorconfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorconfiguration.Configuration#getRetry <em>Retry</em>}</li>
 *   <li>{@link mutatorconfiguration.Configuration#getShowall <em>Showall</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorconfiguration.MutatorconfigurationPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Retry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry</em>' containment reference.
	 * @see #setRetry(Parameter)
	 * @see mutatorconfiguration.MutatorconfigurationPackage#getConfiguration_Retry()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Parameter getRetry();

	/**
	 * Sets the value of the '{@link mutatorconfiguration.Configuration#getRetry <em>Retry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry</em>' containment reference.
	 * @see #getRetry()
	 * @generated
	 */
	void setRetry(Parameter value);

	/**
	 * Returns the value of the '<em><b>Showall</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Showall</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Showall</em>' containment reference.
	 * @see #setShowall(Parameter)
	 * @see mutatorconfiguration.MutatorconfigurationPackage#getConfiguration_Showall()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Parameter getShowall();

	/**
	 * Sets the value of the '{@link mutatorconfiguration.Configuration#getShowall <em>Showall</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Showall</em>' containment reference.
	 * @see #getShowall()
	 * @generated
	 */
	void setShowall(Parameter value);

} // Configuration
