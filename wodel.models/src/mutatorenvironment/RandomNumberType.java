/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Number Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.RandomNumberType#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.RandomNumberType#getMax <em>Max</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomNumberType()
 * @model abstract="true"
 * @generated
 */
public interface RandomNumberType extends NumberType {
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
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomNumberType_Object()
	 * @model containment="true"
	 * @generated
	 */
	ObSelectionStrategy getObject();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomNumberType#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' reference.
	 * @see #setMax(EAttribute)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomNumberType_Max()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getMax();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomNumberType#getMax <em>Max</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' reference.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(EAttribute value);

} // RandomNumberType
