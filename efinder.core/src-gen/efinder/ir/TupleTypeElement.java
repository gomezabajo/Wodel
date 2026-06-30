/**
 */
package efinder.ir;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Type Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.TupleTypeElement#getName <em>Name</em>}</li>
 *   <li>{@link efinder.ir.TupleTypeElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see efinder.ir.EfinderPackage#getTupleTypeElement()
 * @model
 * @generated
 */
public interface TupleTypeElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.EfinderPackage#getTupleTypeElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.TupleTypeElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeRef)
	 * @see efinder.ir.EfinderPackage#getTupleTypeElement_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeRef getType();

	/**
	 * Sets the value of the '{@link efinder.ir.TupleTypeElement#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeRef value);

} // TupleTypeElement
