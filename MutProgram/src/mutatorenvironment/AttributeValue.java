/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.AttributeValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeValue()
 * @model
 * @generated
 */
public interface AttributeValue extends EObject {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EAttribute)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeValue_Value()
	 * @model
	 * @generated
	 */
	EAttribute getValue();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeValue#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EAttribute value);
} // AttributeValue
