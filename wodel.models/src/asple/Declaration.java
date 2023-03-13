/**
 */
package asple;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link asple.Declaration#isRef <em>Ref</em>}</li>
 *   <li>{@link asple.Declaration#getMode <em>Mode</em>}</li>
 *   <li>{@link asple.Declaration#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 *
 * @see asple.AsplePackage#getDeclaration()
 * @model
 * @generated
 */
public interface Declaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(boolean)
	 * @see asple.AsplePackage#getDeclaration_Ref()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRef();

	/**
	 * Sets the value of the '{@link asple.Declaration#isRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #isRef()
	 * @generated
	 */
	void setRef(boolean value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link asple.Mode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see asple.Mode
	 * @see #setMode(Mode)
	 * @see asple.AsplePackage#getDeclaration_Mode()
	 * @model required="true"
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link asple.Declaration#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see asple.Mode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

	/**
	 * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link asple.Identifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' containment reference list.
	 * @see asple.AsplePackage#getDeclaration_Identifiers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Identifier> getIdentifiers();

} // Declaration
