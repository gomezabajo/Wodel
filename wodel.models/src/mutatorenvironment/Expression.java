/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.Expression#getFirst <em>First</em>}</li>
 *   <li>{@link mutatorenvironment.Expression#getOperator <em>Operator</em>}</li>
 *   <li>{@link mutatorenvironment.Expression#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject {
	/**
	 * Returns the value of the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' containment reference.
	 * @see #setFirst(Evaluation)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getExpression_First()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Evaluation getFirst();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Expression#getFirst <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' containment reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(Evaluation value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.BinaryOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getExpression_Operator()
	 * @model containment="true"
	 * @generated
	 */
	EList<BinaryOperator> getOperator();

	/**
	 * Returns the value of the '<em><b>Second</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Evaluation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getExpression_Second()
	 * @model containment="true"
	 * @generated
	 */
	EList<Evaluation> getSecond();

} // Expression
