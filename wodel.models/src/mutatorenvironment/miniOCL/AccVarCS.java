/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Acc Var CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.AccVarCS#getAccVarName <em>Acc Var Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.AccVarCS#getAccType <em>Acc Type</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.AccVarCS#getAccInitExp <em>Acc Init Exp</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getAccVarCS()
 * @model
 * @generated
 */
public interface AccVarCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Acc Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acc Var Name</em>' attribute.
	 * @see #setAccVarName(String)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getAccVarCS_AccVarName()
	 * @model
	 * @generated
	 */
	String getAccVarName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.AccVarCS#getAccVarName <em>Acc Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acc Var Name</em>' attribute.
	 * @see #getAccVarName()
	 * @generated
	 */
	void setAccVarName(String value);

	/**
	 * Returns the value of the '<em><b>Acc Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acc Type</em>' containment reference.
	 * @see #setAccType(PathNameCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getAccVarCS_AccType()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getAccType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.AccVarCS#getAccType <em>Acc Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acc Type</em>' containment reference.
	 * @see #getAccType()
	 * @generated
	 */
	void setAccType(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Acc Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acc Init Exp</em>' containment reference.
	 * @see #setAccInitExp(ExpCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getAccVarCS_AccInitExp()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getAccInitExp();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.AccVarCS#getAccInitExp <em>Acc Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acc Init Exp</em>' containment reference.
	 * @see #getAccInitExp()
	 * @generated
	 */
	void setAccInitExp(ExpCS value);

} // AccVarCS
