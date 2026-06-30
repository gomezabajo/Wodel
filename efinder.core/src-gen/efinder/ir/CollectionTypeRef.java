/**
 */
package efinder.ir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.CollectionTypeRef#getContainedType <em>Contained Type</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getCollectionTypeRef()
 * @model abstract="true"
 * @generated
 */
public interface CollectionTypeRef extends TypeRef {
	/**
	 * Returns the value of the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Type</em>' containment reference.
	 * @see #setContainedType(TypeRef)
	 * @see efinder.ir.EfinderPackage#getCollectionTypeRef_ContainedType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeRef getContainedType();

	/**
	 * Sets the value of the '{@link efinder.ir.CollectionTypeRef#getContainedType <em>Contained Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained Type</em>' containment reference.
	 * @see #getContainedType()
	 * @generated
	 */
	void setContainedType(TypeRef value);

} // CollectionTypeRef
