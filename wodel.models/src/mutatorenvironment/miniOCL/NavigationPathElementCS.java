/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Path Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.NavigationPathElementCS#getPathName <em>Path Name</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNavigationPathElementCS()
 * @model
 * @generated
 */
public interface NavigationPathElementCS extends NavigationPathCS {
	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' reference.
	 * @see #setPathName(EStructuralFeature)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getNavigationPathElementCS_PathName()
	 * @model
	 * @generated
	 */
	EStructuralFeature getPathName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.NavigationPathElementCS#getPathName <em>Path Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(EStructuralFeature value);

} // NavigationPathElementCS
