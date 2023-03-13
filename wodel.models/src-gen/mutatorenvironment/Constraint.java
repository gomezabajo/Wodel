/**
 */
package mutatorenvironment;

import mutatorenvironment.miniOCL.InvariantCS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.Constraint#getId <em>Id</em>}</li>
 *   <li>{@link mutatorenvironment.Constraint#getType <em>Type</em>}</li>
 *   <li>{@link mutatorenvironment.Constraint#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link mutatorenvironment.Constraint#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getConstraint_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Constraint#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getConstraint_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Constraint#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.InvariantCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getConstraint_Expressions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InvariantCS> getExpressions();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' attribute list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getConstraint_Rules()
	 * @model
	 * @generated
	 */
	EList<String> getRules();

} // Constraint
