/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.NavigationPathNameCS#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNavigationPathNameCS()
 * @model
 * @generated
 */
public interface NavigationPathNameCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.NavigationPathCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNavigationPathNameCS_Path()
	 * @model containment="true"
	 * @generated
	 */
	EList<NavigationPathCS> getPath();

} // NavigationPathNameCS
