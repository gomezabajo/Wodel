/**
 */
package efinder.ir.ocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.CollectionLiteralExp#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getCollectionLiteralExp()
 * @model abstract="true"
 * @generated
 */
public interface CollectionLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.ocl.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see efinder.ir.ocl.OclPackage#getCollectionLiteralExp_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<OclExpression> getParts();

} // CollectionLiteralExp
