/**
 */
package modelgraph;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelgraph.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link modelgraph.Edge#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelgraph.ModelgraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends Relation {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EReference)
	 * @see modelgraph.ModelgraphPackage#getEdge_Source()
	 * @model
	 * @generated
	 */
	EReference getSource();

	/**
	 * Sets the value of the '{@link modelgraph.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EReference value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EReference)
	 * @see modelgraph.ModelgraphPackage#getEdge_Target()
	 * @model
	 * @generated
	 */
	EReference getTarget();

	/**
	 * Sets the value of the '{@link modelgraph.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EReference value);

} // Edge
