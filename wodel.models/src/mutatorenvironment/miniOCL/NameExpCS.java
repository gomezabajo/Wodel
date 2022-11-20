/**
 */
package mutatorenvironment.miniOCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.NameExpCS#getExpName <em>Exp Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.NameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.NameExpCS#getCallExp <em>Call Exp</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNameExpCS()
 * @model
 * @generated
 */
public interface NameExpCS extends NavigationExpCS {
	/**
	 * Returns the value of the '<em><b>Exp Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp Name</em>' containment reference.
	 * @see #setExpName(PathNameCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNameExpCS_ExpName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getExpName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.NameExpCS#getExpName <em>Exp Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp Name</em>' containment reference.
	 * @see #getExpName()
	 * @generated
	 */
	void setExpName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Rounded Brackets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounded Brackets</em>' containment reference.
	 * @see #setRoundedBrackets(RoundedBracketClauseCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNameExpCS_RoundedBrackets()
	 * @model containment="true"
	 * @generated
	 */
	RoundedBracketClauseCS getRoundedBrackets();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.NameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounded Brackets</em>' containment reference.
	 * @see #getRoundedBrackets()
	 * @generated
	 */
	void setRoundedBrackets(RoundedBracketClauseCS value);

	/**
	 * Returns the value of the '<em><b>Call Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Exp</em>' containment reference.
	 * @see #setCallExp(CallExpCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNameExpCS_CallExp()
	 * @model containment="true"
	 * @generated
	 */
	CallExpCS getCallExp();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.NameExpCS#getCallExp <em>Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Exp</em>' containment reference.
	 * @see #getCallExp()
	 * @generated
	 */
	void setCallExp(CallExpCS value);

} // NameExpCS
