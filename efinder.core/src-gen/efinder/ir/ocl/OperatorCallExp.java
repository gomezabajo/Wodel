/**
 */
package efinder.ir.ocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.OperatorCallExp#getOperator <em>Operator</em>}</li>
 *   <li>{@link efinder.ir.ocl.OperatorCallExp#getArgument <em>Argument</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getOperatorCallExp()
 * @model
 * @generated
 */
public interface OperatorCallExp extends CallExp {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link efinder.ir.ocl.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see efinder.ir.ocl.OperatorKind
	 * @see #setOperator(OperatorKind)
	 * @see efinder.ir.ocl.OclPackage#getOperatorCallExp_Operator()
	 * @model required="true"
	 * @generated
	 */
	OperatorKind getOperator();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OperatorCallExp#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see efinder.ir.ocl.OperatorKind
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OperatorKind value);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference.
	 * @see #setArgument(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getOperatorCallExp_Argument()
	 * @model containment="true"
	 * @generated
	 */
	OclExpression getArgument();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OperatorCallExp#getArgument <em>Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument</em>' containment reference.
	 * @see #getArgument()
	 * @generated
	 */
	void setArgument(OclExpression value);

} // OperatorCallExp
