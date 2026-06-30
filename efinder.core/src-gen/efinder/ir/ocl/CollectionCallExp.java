/**
 */
package efinder.ir.ocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.CollectionCallExp#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getCollectionCallExp()
 * @model
 * @generated
 */
public interface CollectionCallExp extends AbstractOperationCallExp {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.ocl.OclPackage#getCollectionCallExp_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.CollectionCallExp#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CollectionCallExp
