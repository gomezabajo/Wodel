/**
 */
package modeldraw;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.BooleanAttribute#isNegation <em>Negation</em>}</li>
 *   <li>{@link modeldraw.BooleanAttribute#getAtt <em>Att</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getBooleanAttribute()
 * @model
 * @generated
 */
public interface BooleanAttribute extends Item {
	/**
	 * Returns the value of the '<em><b>Negation</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Negation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negation</em>' attribute.
	 * @see #setNegation(boolean)
	 * @see modeldraw.ModeldrawPackage#getBooleanAttribute_Negation()
	 * @model default="false"
	 * @generated
	 */
	boolean isNegation();

	/**
	 * Sets the value of the '{@link modeldraw.BooleanAttribute#isNegation <em>Negation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negation</em>' attribute.
	 * @see #isNegation()
	 * @generated
	 */
	void setNegation(boolean value);

	/**
	 * Returns the value of the '<em><b>Att</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att</em>' reference.
	 * @see #setAtt(EAttribute)
	 * @see modeldraw.ModeldrawPackage#getBooleanAttribute_Att()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAtt();

	/**
	 * Sets the value of the '{@link modeldraw.BooleanAttribute#getAtt <em>Att</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att</em>' reference.
	 * @see #getAtt()
	 * @generated
	 */
	void setAtt(EAttribute value);

} // BooleanAttribute
