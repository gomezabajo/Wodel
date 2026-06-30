/**
 */
package efinder.ir.ocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.IfExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link efinder.ir.ocl.IfExp#getThen <em>Then</em>}</li>
 *   <li>{@link efinder.ir.ocl.IfExp#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getIfExp()
 * @model
 * @generated
 */
public interface IfExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getIfExp_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getCondition();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.IfExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getIfExp_Then()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getThen();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.IfExp#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getIfExp_Else()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getElse();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.IfExp#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(OclExpression value);

} // IfExp
