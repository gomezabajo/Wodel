/**
 */
package efinder.ir;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EF Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.EFClass#getKlass <em>Klass</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getEFClass()
 * @model
 * @generated
 */
public interface EFClass extends EFType {
	/**
	 * Returns the value of the '<em><b>Klass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Klass</em>' reference.
	 * @see #setKlass(EClass)
	 * @see efinder.ir.EfinderPackage#getEFClass_Klass()
	 * @model required="true"
	 * @generated
	 */
	EClass getKlass();

	/**
	 * Sets the value of the '{@link efinder.ir.EFClass#getKlass <em>Klass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Klass</em>' reference.
	 * @see #getKlass()
	 * @generated
	 */
	void setKlass(EClass value);

} // EFClass
