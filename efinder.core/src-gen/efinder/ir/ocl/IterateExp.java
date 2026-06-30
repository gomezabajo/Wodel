/**
 */
package efinder.ir.ocl;

import efinder.ir.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.IterateExp#getResult <em>Result</em>}</li>
 *   <li>{@link efinder.ir.ocl.IterateExp#getInit <em>Init</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getIterateExp()
 * @model
 * @generated
 */
public interface IterateExp extends LoopExp {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(VariableDeclaration)
	 * @see efinder.ir.ocl.OclPackage#getIterateExp_Result()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableDeclaration getResult();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.IterateExp#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' containment reference.
	 * @see #setInit(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getIterateExp_Init()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getInit();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.IterateExp#getInit <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' containment reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(OclExpression value);

} // IterateExp
