/**
 */
package efinder.ir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EF Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.EFPrimitiveType#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getEFPrimitiveType()
 * @model
 * @generated
 */
public interface EFPrimitiveType extends EFType {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.EfinderPackage#getEFPrimitiveType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.EFPrimitiveType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EFPrimitiveType
