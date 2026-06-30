/**
 */
package efinder.ir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.MetaTypeRef#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getMetaTypeRef()
 * @model
 * @generated
 */
public interface MetaTypeRef extends TypeRef {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EFType)
	 * @see efinder.ir.EfinderPackage#getMetaTypeRef_Type()
	 * @model required="true"
	 * @generated
	 */
	EFType getType();

	/**
	 * Sets the value of the '{@link efinder.ir.MetaTypeRef#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EFType value);

} // MetaTypeRef
