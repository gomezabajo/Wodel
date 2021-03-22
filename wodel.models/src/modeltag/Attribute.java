/**
 */
package modeltag;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeltag.Attribute#getAtt <em>Att</em>}</li>
 * </ul>
 *
 * @see modeltag.ModeltagPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject {
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
	 * @see modeltag.ModeltagPackage#getAttribute_Att()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAtt();

	/**
	 * Sets the value of the '{@link modeltag.Attribute#getAtt <em>Att</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att</em>' reference.
	 * @see #getAtt()
	 * @generated
	 */
	void setAtt(EAttribute value);

} // Attribute
