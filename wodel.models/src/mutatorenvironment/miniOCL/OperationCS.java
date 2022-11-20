/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.OperationCS#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.OperationCS#getParams <em>Params</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.OperationCS#getResultRef <em>Result Ref</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.OperationCS#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getOperationCS()
 * @model
 * @generated
 */
public interface OperationCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getOperationCS_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.OperationCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getOperationCS_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getParams();

	/**
	 * Returns the value of the '<em><b>Result Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Ref</em>' containment reference.
	 * @see #setResultRef(PathNameCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getOperationCS_ResultRef()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getResultRef();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.OperationCS#getResultRef <em>Result Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Ref</em>' containment reference.
	 * @see #getResultRef()
	 * @generated
	 */
	void setResultRef(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(ExpCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getOperationCS_Body()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getBody();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.OperationCS#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(ExpCS value);

} // OperationCS
