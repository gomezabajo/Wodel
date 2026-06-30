/**
 */
package efinder.ir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Defined Operation Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.DefinedOperationRef#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getDefinedOperationRef()
 * @model
 * @generated
 */
public interface DefinedOperationRef extends OperationFeatureRef {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see efinder.ir.EfinderPackage#getDefinedOperationRef_Operation()
	 * @model required="true"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link efinder.ir.DefinedOperationRef#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // DefinedOperationRef
