/**
 */
package modeldraw;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link modeldraw.Edge#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends Relation {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EReference)
	 * @see modeldraw.ModeldrawPackage#getEdge_Source()
	 * @model
	 * @generated
	 */
	EReference getSource();

	/**
	 * Sets the value of the '{@link modeldraw.Edge#getSource <em>Source</em>}' reference.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EReference)
	 * @see modeldraw.ModeldrawPackage#getEdge_Target()
	 * @model
	 * @generated
	 */
	EReference getTarget();

	/**
	 * Sets the value of the '{@link modeldraw.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EReference value);

} // Edge
