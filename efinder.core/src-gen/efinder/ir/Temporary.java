/**
 */
package efinder.ir;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Temporary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.Temporary#getClasses <em>Classes</em>}</li>
 *   <li>{@link efinder.ir.Temporary#getDangling <em>Dangling</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getTemporary()
 * @model
 * @generated
 */
public interface Temporary extends EObject {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getTemporary_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFClass> getClasses();

	/**
	 * Returns the value of the '<em><b>Dangling</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dangling</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getTemporary_Dangling()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getDangling();

} // Temporary
