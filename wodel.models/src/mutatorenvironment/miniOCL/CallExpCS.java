/**
 */
package mutatorenvironment.miniOCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.CallExpCS#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.CallExpCS#getNavExp <em>Nav Exp</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getCallExpCS()
 * @model
 * @generated
 */
public interface CallExpCS extends LogicExpCS {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(CallExpCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getCallExpCS_Source()
	 * @model containment="true"
	 * @generated
	 */
	CallExpCS getSource();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.CallExpCS#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(CallExpCS value);

	/**
	 * Returns the value of the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nav Exp</em>' containment reference.
	 * @see #setNavExp(NavigationExpCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getCallExpCS_NavExp()
	 * @model containment="true"
	 * @generated
	 */
	NavigationExpCS getNavExp();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.CallExpCS#getNavExp <em>Nav Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nav Exp</em>' containment reference.
	 * @see #getNavExp()
	 * @generated
	 */
	void setNavExp(NavigationExpCS value);

} // CallExpCS
