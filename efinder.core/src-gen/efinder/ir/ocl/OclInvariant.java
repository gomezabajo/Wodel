/**
 */
package efinder.ir.ocl;

import efinder.ir.Constraint;
import efinder.ir.EFClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.OclInvariant#getKlass <em>Klass</em>}</li>
 *   <li>{@link efinder.ir.ocl.OclInvariant#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getOclInvariant()
 * @model
 * @generated
 */
public interface OclInvariant extends Constraint, WithContextVariable {
	/**
	 * Returns the value of the '<em><b>Klass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Klass</em>' reference.
	 * @see #setKlass(EFClass)
	 * @see efinder.ir.ocl.OclPackage#getOclInvariant_Klass()
	 * @model required="true"
	 * @generated
	 */
	EFClass getKlass();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OclInvariant#getKlass <em>Klass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Klass</em>' reference.
	 * @see #getKlass()
	 * @generated
	 */
	void setKlass(EFClass value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getOclInvariant_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getExpression();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OclInvariant#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OclExpression value);

} // OclInvariant
