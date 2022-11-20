/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.PackageCS#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.PackageCS#getPackages <em>Packages</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.PackageCS#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getPackageCS()
 * @model
 * @generated
 */
public interface PackageCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getPackageCS_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.PackageCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.PackageCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getPackageCS_Packages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageCS> getPackages();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.ClassCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getPackageCS_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassCS> getClasses();

} // PackageCS
