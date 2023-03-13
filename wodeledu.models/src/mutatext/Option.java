/**
 */
package mutatext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatext.Option#getType <em>Type</em>}</li>
 *   <li>{@link mutatext.Option#getObject <em>Object</em>}</li>
 *   <li>{@link mutatext.Option#getValid <em>Valid</em>}</li>
 *   <li>{@link mutatext.Option#getInvalid <em>Invalid</em>}</li>
 * </ul>
 *
 * @see mutatext.MutatextPackage#getOption()
 * @model
 * @generated
 */
public interface Option extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see mutatext.MutatextPackage#getOption_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link mutatext.Option#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see mutatext.MutatextPackage#getOption_Object()
	 * @model
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link mutatext.Option#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Valid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid</em>' containment reference.
	 * @see #setValid(Text)
	 * @see mutatext.MutatextPackage#getOption_Valid()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Text getValid();

	/**
	 * Sets the value of the '{@link mutatext.Option#getValid <em>Valid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' containment reference.
	 * @see #getValid()
	 * @generated
	 */
	void setValid(Text value);

	/**
	 * Returns the value of the '<em><b>Invalid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid</em>' containment reference.
	 * @see #setInvalid(Text)
	 * @see mutatext.MutatextPackage#getOption_Invalid()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Text getInvalid();

	/**
	 * Sets the value of the '{@link mutatext.Option#getInvalid <em>Invalid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invalid</em>' containment reference.
	 * @see #getInvalid()
	 * @generated
	 */
	void setInvalid(Text value);

} // Option
