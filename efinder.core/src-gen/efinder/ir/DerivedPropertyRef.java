/**
 */
package efinder.ir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Property Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.DerivedPropertyRef#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getDerivedPropertyRef()
 * @model
 * @generated
 */
public interface DerivedPropertyRef extends PropertyFeatureRef {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(DerivedProperty)
	 * @see efinder.ir.EfinderPackage#getDerivedPropertyRef_Property()
	 * @model required="true"
	 * @generated
	 */
	DerivedProperty getProperty();

	/**
	 * Sets the value of the '{@link efinder.ir.DerivedPropertyRef#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(DerivedProperty value);

} // DerivedPropertyRef
