/**
 */
package appliedMutations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Att</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.ReferenceAtt#getAttName <em>Att Name</em>}</li>
 *   <li>{@link appliedMutations.ReferenceAtt#getOldVal <em>Old Val</em>}</li>
 *   <li>{@link appliedMutations.ReferenceAtt#getNewVal <em>New Val</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getReferenceAtt()
 * @model
 * @generated
 */
public interface ReferenceAtt extends ReferenceChanged {
	/**
	 * Returns the value of the '<em><b>Att Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att Name</em>' attribute.
	 * @see #setAttName(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceAtt_AttName()
	 * @model required="true"
	 * @generated
	 */
	String getAttName();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceAtt#getAttName <em>Att Name</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Val</em>' attribute.
	 * @see #setOldVal(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceAtt_OldVal()
	 * @model required="true"
	 * @generated
	 */
	String getOldVal();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceAtt#getOldVal <em>Old Val</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Val</em>' attribute.
	 * @see #setNewVal(String)
	 * @see appliedMutations.AppliedMutationsPackage#getReferenceAtt_NewVal()
	 * @model required="true"
	 * @generated
	 */
	String getNewVal();

	/**
	 * Sets the value of the '{@link appliedMutations.ReferenceAtt#getNewVal <em>New Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Val</em>' attribute.
	 * @see #getNewVal()
	 * @generated
	 */
	void setNewVal(String value);

} // ReferenceAtt
