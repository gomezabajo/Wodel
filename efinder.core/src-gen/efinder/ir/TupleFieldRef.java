/**
 */
package efinder.ir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Field Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.TupleFieldRef#getType <em>Type</em>}</li>
 *   <li>{@link efinder.ir.TupleFieldRef#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getTupleFieldRef()
 * @model
 * @generated
 */
public interface TupleFieldRef extends PropertyFeatureRef {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EFTupleType)
	 * @see efinder.ir.EfinderPackage#getTupleFieldRef_Type()
	 * @model required="true"
	 * @generated
	 */
	EFTupleType getType();

	/**
	 * Sets the value of the '{@link efinder.ir.TupleFieldRef#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EFTupleType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.EfinderPackage#getTupleFieldRef_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.TupleFieldRef#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TupleFieldRef
