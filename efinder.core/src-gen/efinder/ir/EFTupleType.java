/**
 */
package efinder.ir;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EF Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.EFTupleType#getId <em>Id</em>}</li>
 *   <li>{@link efinder.ir.EFTupleType#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getEFTupleType()
 * @model
 * @generated
 */
public interface EFTupleType extends EFType {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see efinder.ir.EfinderPackage#getEFTupleType_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link efinder.ir.EFTupleType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link efinder.ir.TupleTypeElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see efinder.ir.EfinderPackage#getEFTupleType_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<TupleTypeElement> getElements();

} // EFTupleType
