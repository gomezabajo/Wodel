/**
 */
package efinder.ir;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EF Metamodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.EFMetamodel#getRoots <em>Roots</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getEFMetamodel()
 * @model
 * @generated
 */
public interface EFMetamodel extends EObject {
	/**
	 * Returns the value of the '<em><b>Roots</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roots</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getEFMetamodel_Roots()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFPackage> getRoots();

} // EFMetamodel
