/**
 */
package mutatortests;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatortests.Configuration#getRetry <em>Retry</em>}</li>
 *   <li>{@link mutatortests.Configuration#getShowall <em>Showall</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatortests.MutatortestsPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Retry</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatortests.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry</em>' attribute.
	 * @see mutatortests.Parameter
	 * @see #setRetry(Parameter)
	 * @see mutatortests.MutatortestsPackage#getConfiguration_Retry()
	 * @model required="true"
	 * @generated
	 */
	Parameter getRetry();

	/**
	 * Sets the value of the '{@link mutatortests.Configuration#getRetry <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry</em>' attribute.
	 * @see mutatortests.Parameter
	 * @see #getRetry()
	 * @generated
	 */
	void setRetry(Parameter value);

	/**
	 * Returns the value of the '<em><b>Showall</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatortests.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Showall</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Showall</em>' attribute.
	 * @see mutatortests.Parameter
	 * @see #setShowall(Parameter)
	 * @see mutatortests.MutatortestsPackage#getConfiguration_Showall()
	 * @model required="true"
	 * @generated
	 */
	Parameter getShowall();

	/**
	 * Sets the value of the '{@link mutatortests.Configuration#getShowall <em>Showall</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Showall</em>' attribute.
	 * @see mutatortests.Parameter
	 * @see #getShowall()
	 * @generated
	 */
	void setShowall(Parameter value);

} // Configuration
