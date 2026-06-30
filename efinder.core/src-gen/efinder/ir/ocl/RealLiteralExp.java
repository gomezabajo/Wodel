/**
 */
package efinder.ir.ocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.RealLiteralExp#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getRealLiteralExp()
 * @model
 * @generated
 */
public interface RealLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Double)
	 * @see efinder.ir.ocl.OclPackage#getRealLiteralExp_Value()
	 * @model required="true"
	 * @generated
	 */
	Double getValue();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.RealLiteralExp#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Double value);

} // RealLiteralExp
