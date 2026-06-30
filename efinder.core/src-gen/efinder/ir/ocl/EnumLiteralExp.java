/**
 */
package efinder.ir.ocl;

import efinder.ir.EFEnumLiteral;
import efinder.ir.MetaTypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.EnumLiteralExp#getEnum_ <em>Enum </em>}</li>
 *   <li>{@link efinder.ir.ocl.EnumLiteralExp#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getEnumLiteralExp()
 * @model
 * @generated
 */
public interface EnumLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Enum </b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum </em>' containment reference.
	 * @see #setEnum_(MetaTypeRef)
	 * @see efinder.ir.ocl.OclPackage#getEnumLiteralExp_Enum_()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MetaTypeRef getEnum_();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.EnumLiteralExp#getEnum_ <em>Enum </em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum </em>' containment reference.
	 * @see #getEnum_()
	 * @generated
	 */
	void setEnum_(MetaTypeRef value);

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' reference.
	 * @see #setLiteral(EFEnumLiteral)
	 * @see efinder.ir.ocl.OclPackage#getEnumLiteralExp_Literal()
	 * @model required="true"
	 * @generated
	 */
	EFEnumLiteral getLiteral();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.EnumLiteralExp#getLiteral <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(EFEnumLiteral value);

} // EnumLiteralExp
