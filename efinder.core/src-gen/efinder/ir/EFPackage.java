/**
 */
package efinder.ir;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EF Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.EFPackage#getPkg <em>Pkg</em>}</li>
 *   <li>{@link efinder.ir.EFPackage#getClasses <em>Classes</em>}</li>
 *   <li>{@link efinder.ir.EFPackage#getEnumerations <em>Enumerations</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getEFPackage()
 * @model
 * @generated
 */
public interface EFPackage extends EObject {
	/**
	 * Returns the value of the '<em><b>Pkg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pkg</em>' reference.
	 * @see #setPkg(EPackage)
	 * @see efinder.ir.EfinderPackage#getEFPackage_Pkg()
	 * @model required="true"
	 * @generated
	 */
	EPackage getPkg();

	/**
	 * Sets the value of the '{@link efinder.ir.EFPackage#getPkg <em>Pkg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pkg</em>' reference.
	 * @see #getPkg()
	 * @generated
	 */
	void setPkg(EPackage value);

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getEFPackage_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFClass> getClasses();

	/**
	 * Returns the value of the '<em><b>Enumerations</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerations</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getEFPackage_Enumerations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFEnum> getEnumerations();

} // EFPackage
