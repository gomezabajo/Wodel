/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ob Selection Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.ObSelectionStrategy#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.ObSelectionStrategy#getExpression <em>Expression</em>}</li>
 *   <li>{@link mutatorenvironment.ObSelectionStrategy#getResource <em>Resource</em>}</li>
 *   <li>{@link mutatorenvironment.ObSelectionStrategy#getRefRefType <em>Ref Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.ObSelectionStrategy#getRefRefRefType <em>Ref Ref Ref Type</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getObSelectionStrategy()
 * @model abstract="true"
 * @generated
 */
public interface ObSelectionStrategy extends ObjectEmitter {
	/**
	 * Returns the value of the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Type</em>' reference.
	 * @see #setRefType(EReference)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObSelectionStrategy_RefType()
	 * @model
	 * @generated
	 */
	EReference getRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObSelectionStrategy#getRefType <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' reference.
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(EReference value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObSelectionStrategy_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObSelectionStrategy#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see #setResource(String)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObSelectionStrategy_Resource()
	 * @model
	 * @generated
	 */
	String getResource();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObSelectionStrategy#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(String value);

	/**
	 * Returns the value of the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Ref Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Ref Type</em>' reference.
	 * @see #setRefRefType(EReference)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObSelectionStrategy_RefRefType()
	 * @model
	 * @generated
	 */
	EReference getRefRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObSelectionStrategy#getRefRefType <em>Ref Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Ref Type</em>' reference.
	 * @see #getRefRefType()
	 * @generated
	 */
	void setRefRefType(EReference value);

	/**
	 * Returns the value of the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Ref Ref Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Ref Ref Type</em>' reference.
	 * @see #setRefRefRefType(EReference)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObSelectionStrategy_RefRefRefType()
	 * @model
	 * @generated
	 */
	EReference getRefRefRefType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObSelectionStrategy#getRefRefRefType <em>Ref Ref Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Ref Ref Type</em>' reference.
	 * @see #getRefRefRefType()
	 * @generated
	 */
	void setRefRefRefType(EReference value);

} // ObSelectionStrategy
