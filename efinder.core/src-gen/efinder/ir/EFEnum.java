/**
 */
package efinder.ir;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EEnum;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EF Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.EFEnum#getEnum_ <em>Enum </em>}</li>
 *   <li>{@link efinder.ir.EFEnum#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getEFEnum()
 * @model
 * @generated
 */
public interface EFEnum extends EFType {
	/**
	 * Returns the value of the '<em><b>Enum </b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum </em>' reference.
	 * @see #setEnum_(EEnum)
	 * @see efinder.ir.EfinderPackage#getEFEnum_Enum_()
	 * @model required="true"
	 * @generated
	 */
	EEnum getEnum_();

	/**
	 * Sets the value of the '{@link efinder.ir.EFEnum#getEnum_ <em>Enum </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum </em>' reference.
	 * @see #getEnum_()
	 * @generated
	 */
	void setEnum_(EEnum value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.EFEnumLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getEFEnum_Literals()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFEnumLiteral> getLiterals();

} // EFEnum
