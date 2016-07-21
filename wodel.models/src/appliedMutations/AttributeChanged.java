/**
 */
package appliedMutations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Changed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link appliedMutations.AttributeChanged#getAttName <em>Att Name</em>}</li>
 *   <li>{@link appliedMutations.AttributeChanged#getOldVal <em>Old Val</em>}</li>
 *   <li>{@link appliedMutations.AttributeChanged#getNewVal <em>New Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see appliedMutations.AppliedMutationsPackage#getAttributeChanged()
 * @model
 * @generated
 */
public interface AttributeChanged extends AppMutation {
	/**
	 * Returns the value of the '<em><b>Att Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att Name</em>' attribute.
	 * @see #setAttName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getAttributeChanged_AttName()
	 * @model required="true"
	 * @generated
	 */
	String getAttName();

	/**
	 * Sets the value of the '{@link appliedMutations.AttributeChanged#getAttName <em>Att Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att Name</em>' attribute.
	 * @see #getAttName()
	 * @generated
	 */
	void setAttName(String value);

	/**
	 * Returns the value of the '<em><b>Old Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Val</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Val</em>' attribute.
	 * @see #setOldVal(String)
	 * @see appliedMutations.AppliedMutationsPackage#getAttributeChanged_OldVal()
	 * @model required="true"
	 * @generated
	 */
	String getOldVal();

	/**
	 * Sets the value of the '{@link appliedMutations.AttributeChanged#getOldVal <em>Old Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Val</em>' attribute.
	 * @see #getOldVal()
	 * @generated
	 */
	void setOldVal(String value);

	/**
	 * Returns the value of the '<em><b>New Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Val</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Val</em>' attribute.
	 * @see #setNewVal(String)
	 * @see appliedMutations.AppliedMutationsPackage#getAttributeChanged_NewVal()
	 * @model required="true"
	 * @generated
	 */
	String getNewVal();

	/**
	 * Sets the value of the '{@link appliedMutations.AttributeChanged#getNewVal <em>New Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Val</em>' attribute.
	 * @see #getNewVal()
	 * @generated
	 */
	void setNewVal(String value);

} // AttributeChanged
