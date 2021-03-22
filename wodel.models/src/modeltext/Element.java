/**
 */
package modeltext;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeltext.Element#getType <em>Type</em>}</li>
 *   <li>{@link modeltext.Element#getRef <em>Ref</em>}</li>
 *   <li>{@link modeltext.Element#getAtt <em>Att</em>}</li>
 *   <li>{@link modeltext.Element#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @see modeltext.ModeltextPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see modeltext.ModeltextPackage#getElement_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link modeltext.Element#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(EReference)
	 * @see modeltext.ModeltextPackage#getElement_Ref()
	 * @model
	 * @generated
	 */
	EReference getRef();

	/**
	 * Sets the value of the '{@link modeltext.Element#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(EReference value);

	/**
	 * Returns the value of the '<em><b>Att</b></em>' containment reference list.
	 * The list contents are of type {@link modeltext.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att</em>' containment reference list.
	 * @see modeltext.ModeltextPackage#getElement_Att()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAtt();

	/**
	 * Returns the value of the '<em><b>Words</b></em>' containment reference list.
	 * The list contents are of type {@link modeltext.Word}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Words</em>' containment reference list.
	 * @see modeltext.ModeltextPackage#getElement_Words()
	 * @model containment="true"
	 * @generated
	 */
	EList<Word> getWords();

} // Element
