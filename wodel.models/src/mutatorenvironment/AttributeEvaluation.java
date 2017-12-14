/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.AttributeEvaluation#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.AttributeEvaluation#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeEvaluation()
 * @model
 * @generated
 */
public interface AttributeEvaluation extends Evaluation {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' reference.
	 * @see #setName(EAttribute)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeEvaluation_Name()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeEvaluation#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(AttributeEvaluationType)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getAttributeEvaluation_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AttributeEvaluationType getValue();

	/**
	 * Sets the value of the '{@link mutatorenvironment.AttributeEvaluation#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(AttributeEvaluationType value);

} // AttributeEvaluation
