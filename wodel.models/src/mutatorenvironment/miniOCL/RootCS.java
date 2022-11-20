/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.RootCS#getPackages <em>Packages</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.RootCS#getContraints <em>Contraints</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getRootCS()
 * @model
 * @generated
 */
public interface RootCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.PackageCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getRootCS_Packages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageCS> getPackages();

	/**
	 * Returns the value of the '<em><b>Contraints</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contraints</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getRootCS_Contraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getContraints();

} // RootCS
