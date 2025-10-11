/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Var CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.IteratorVarCS#getItName <em>It Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.IteratorVarCS#getItType <em>It Type</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getIteratorVarCS()
 * @model
 * @generated
 */
public interface IteratorVarCS extends EObject {
	/**
	 * Returns the value of the '<em><b>It Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>It Name</em>' attribute.
	 * @see #setItName(String)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getIteratorVarCS_ItName()
	 * @model
	 * @generated
	 */
	String getItName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.IteratorVarCS#getItName <em>It Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>It Name</em>' attribute.
	 * @see #getItName()
	 * @generated
	 */
	void setItName(String value);

	/**
	 * Returns the value of the '<em><b>It Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>It Type</em>' containment reference.
	 * @see #setItType(PathNameCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getIteratorVarCS_ItType()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getItType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.IteratorVarCS#getItType <em>It Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>It Type</em>' containment reference.
	 * @see #getItType()
	 * @generated
	 */
	void setItType(PathNameCS value);

} // IteratorVarCS
