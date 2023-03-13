/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.AttributeSet#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeSet()
 * @model
 * @generated
 */
public interface AttributeSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeSet_Attribute()
	 * @model
	 * @generated
	 */
	EList<EAttribute> getAttribute();

} // AttributeSet
