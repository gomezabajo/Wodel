/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Max Value Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.MaxValueType#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getMaxValueType()
 * @model
 * @generated
 */
public interface MaxValueType extends NumberType {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMaxValueType_Attribute()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link mutatorenvironment.MaxValueType#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

} // MaxValueType
