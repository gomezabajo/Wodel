/**
 */
package efinder.ir.ocl;

import efinder.ir.DerivedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.OclDerivedProperty#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getOclDerivedProperty()
 * @model
 * @generated
 */
public interface OclDerivedProperty extends DerivedProperty, WithContextVariable {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OclExpression)
	 * @see efinder.ir.ocl.OclPackage#getOclDerivedProperty_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getBody();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OclDerivedProperty#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpression value);

} // OclDerivedProperty
