/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mult Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.MultExpression#getFirst <em>First</em>}</li>
 *   <li>{@link mutatorenvironment.MultExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link mutatorenvironment.MultExpression#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getMultExpression()
 * @model
 * @generated
 */
public interface MultExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' containment reference.
	 * @see #setFirst(Evaluation)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMultExpression_First()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Evaluation getFirst();

	/**
	 * Sets the value of the '{@link mutatorenvironment.MultExpression#getFirst <em>First</em>}' containment reference.
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
	 * <p>
	 * If the meaning of the '<em>Operator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMultExpression_Operator()
	 * @model containment="true"
	 * @generated
	 */
	EList<BinaryOperator> getOperator();

	/**
	 * Returns the value of the '<em><b>Second</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Evaluation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMultExpression_Second()
	 * @model containment="true"
	 * @generated
	 */
	EList<Evaluation> getSecond();

} // MultExpression
