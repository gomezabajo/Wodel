/**
 */
package efinder.ir.ocl;

import efinder.ir.OperationFeatureRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.OperationCallExp#getName <em>Name</em>}</li>
 *   <li>{@link efinder.ir.ocl.OperationCallExp#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see efinder.ir.ocl.OclPackage#getOperationCallExp()
 * @model
 * @generated
 */
public interface OperationCallExp extends AbstractOperationCallExp {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see efinder.ir.ocl.OclPackage#getOperationCallExp_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OperationCallExp#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference.
	 * @see #setFeature(OperationFeatureRef)
	 * @see efinder.ir.ocl.OclPackage#getOperationCallExp_Feature()
	 * @model containment="true"
	 * @generated
	 */
	OperationFeatureRef getFeature();

	/**
	 * Sets the value of the '{@link efinder.ir.ocl.OperationCallExp#getFeature <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' containment reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(OperationFeatureRef value);

} // OperationCallExp
