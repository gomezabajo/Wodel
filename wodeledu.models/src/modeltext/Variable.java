/**
 */
package modeltext;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeltext.Variable#getRef <em>Ref</em>}</li>
 *   <li>{@link modeltext.Variable#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see modeltext.ModeltextPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Word {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(EReference)
	 * @see modeltext.ModeltextPackage#getVariable_Ref()
	 * @model
	 * @generated
	 */
	EReference getRef();

	/**
	 * Sets the value of the '{@link modeltext.Variable#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(EReference value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' reference.
	 * @see #setId(EAttribute)
	 * @see modeltext.ModeltextPackage#getVariable_Id()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getId();

	/**
	 * Sets the value of the '{@link modeltext.Variable#getId <em>Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(EAttribute value);

} // Variable
