/**
 */
package efinder.ir.ocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unsupported Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.UnsupportedExp#getReason <em>Reason</em>}</li>
 *   <li>{@link efinder.ir.ocl.UnsupportedExp#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getUnsupportedExp()
 * @model
 * @generated
 */
public interface UnsupportedExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reason</em>' attribute.
	 * @see #setReason(String)
	 * @see efinder.ir.ocl.OclPackage#getUnsupportedExp_Reason()
	 * @model required="true"
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.UnsupportedExp#getReason <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reason</em>' attribute.
	 * @see #getReason()
	 * @generated
	 */
	void setReason(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see efinder.ir.ocl.OclPackage#getUnsupportedExp_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.UnsupportedExp#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // UnsupportedExp
