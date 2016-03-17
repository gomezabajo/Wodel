/**
 */
package mutatorgraph;

import org.eclipse.emf.ecore.EReference;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorgraph.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorgraph.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link mutatorgraph.Edge#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorgraph.MutatorgraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends Item {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EReference)
	 * @see mutatorgraph.MutatorgraphPackage#getEdge_Source()
	 * @model
	 * @generated
	 */
	EReference getSource();

	/**
	 * Sets the value of the '{@link mutatorgraph.Edge#getSource <em>Source</em>}' reference.
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
	 * If the meaning of the '<em>Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EReference)
	 * @see mutatorgraph.MutatorgraphPackage#getEdge_Target()
	 * @model
	 * @generated
	 */
	EReference getTarget();

	/**
	 * Sets the value of the '{@link mutatorgraph.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EReference value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference.
	 * @see #setLabel(EReference)
	 * @see mutatorgraph.MutatorgraphPackage#getEdge_Label()
	 * @model
	 * @generated
	 */
	EReference getLabel();

	/**
	 * Sets the value of the '{@link mutatorgraph.Edge#getLabel <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(EReference value);

} // Edge
