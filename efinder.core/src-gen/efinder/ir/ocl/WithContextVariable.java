/**
 */
package efinder.ir.ocl;

import efinder.ir.VariableDeclaration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>With Context Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.WithContextVariable#getContextVariable <em>Context Variable</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getWithContextVariable()
 * @model abstract="true"
 * @generated
 */
public interface WithContextVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Context Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Variable</em>' containment reference.
	 * @see #setContextVariable(VariableDeclaration)
	 * @see efinder.ir.ocl.OclPackage#getWithContextVariable_ContextVariable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableDeclaration getContextVariable();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.WithContextVariable#getContextVariable <em>Context Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Variable</em>' containment reference.
	 * @see #getContextVariable()
	 * @generated
	 */
	void setContextVariable(VariableDeclaration value);

} // WithContextVariable
