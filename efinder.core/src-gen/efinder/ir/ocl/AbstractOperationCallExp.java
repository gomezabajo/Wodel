/**
 */
package efinder.ir.ocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.AbstractOperationCallExp#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getAbstractOperationCallExp()
 * @model abstract="true"
 * @generated
 */
public interface AbstractOperationCallExp extends CallExp {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.ocl.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see efinder.ir.ocl.OclPackage#getAbstractOperationCallExp_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<OclExpression> getArguments();

} // AbstractOperationCallExp
