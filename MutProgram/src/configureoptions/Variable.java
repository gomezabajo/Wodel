/**
 */
package configureoptions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configureoptions.Variable#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see configureoptions.ConfigureoptionsPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Word {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link configureoptions.VariableType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see configureoptions.VariableType
	 * @see #setType(VariableType)
	 * @see configureoptions.ConfigureoptionsPackage#getVariable_Type()
	 * @model required="true"
	 * @generated
	 */
	VariableType getType();

	/**
	 * Sets the value of the '{@link configureoptions.Variable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see configureoptions.VariableType
	 * @see #getType()
	 * @generated
	 */
	void setType(VariableType value);

} // Variable
