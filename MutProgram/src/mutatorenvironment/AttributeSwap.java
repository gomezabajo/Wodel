/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Swap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.AttributeSwap#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeSwap()
 * @model
 * @generated
 */
public interface AttributeSwap extends AttributeSet
{
	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference.
	 * @see #setObject(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeSwap_Object()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getObject();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeSwap#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObSelectionStrategy value);

} // AttributeSwap
