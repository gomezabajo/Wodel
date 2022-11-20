/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.ConstraintCS#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.ConstraintCS#getInvariants <em>Invariants</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getConstraintCS()
 * @model
 * @generated
 */
public interface ConstraintCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref</em>' containment reference.
	 * @see #setTypeRef(PathNameCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getConstraintCS_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getTypeRef();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.ConstraintCS#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
	void setTypeRef(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.InvariantCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getConstraintCS_Invariants()
	 * @model containment="true"
	 * @generated
	 */
	EList<InvariantCS> getInvariants();

} // ConstraintCS
