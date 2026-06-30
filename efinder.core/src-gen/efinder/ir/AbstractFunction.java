/**
 */
package efinder.ir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.AbstractFunction#getName <em>Name</em>}</li>
 *   <li>{@link efinder.ir.AbstractFunction#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getAbstractFunction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractFunction extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.EfinderPackage#getAbstractFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.AbstractFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(EFType)
	 * @see efinder.ir.EfinderPackage#getAbstractFunction_Context()
	 * @model
	 * @generated
	 */
	EFType getContext();

	/**
	 * Sets the value of the '{@link efinder.ir.AbstractFunction#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EFType value);

} // AbstractFunction
