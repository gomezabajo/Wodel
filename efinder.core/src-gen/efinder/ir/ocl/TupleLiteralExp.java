/**
 */
package efinder.ir.ocl;

import efinder.ir.EFTupleType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.TupleLiteralExp#getTupleType <em>Tuple Type</em>}</li>
 *   <li>{@link efinder.ir.ocl.TupleLiteralExp#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getTupleLiteralExp()
 * @model
 * @generated
 */
public interface TupleLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Tuple Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuple Type</em>' reference.
	 * @see #setTupleType(EFTupleType)
	 * @see efinder.ir.ocl.OclPackage#getTupleLiteralExp_TupleType()
	 * @model required="true"
	 * @generated
	 */
	EFTupleType getTupleType();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.TupleLiteralExp#getTupleType <em>Tuple Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tuple Type</em>' reference.
	 * @see #getTupleType()
	 * @generated
	 */
	void setTupleType(EFTupleType value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.ocl.TuplePart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see efinder.ir.ocl.OclPackage#getTupleLiteralExp_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<TuplePart> getParts();

} // TupleLiteralExp
