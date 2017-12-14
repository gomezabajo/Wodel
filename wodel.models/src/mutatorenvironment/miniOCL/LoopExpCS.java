/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.LoopExpCS#getItVar <em>It Var</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.LoopExpCS#getLogicOp <em>Logic Op</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.LoopExpCS#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getLoopExpCS()
 * @model
 * @generated
 */
public interface LoopExpCS extends NavigationExpCS {
	/**
	 * Returns the value of the '<em><b>It Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>It Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>It Var</em>' containment reference.
	 * @see #setItVar(IteratorVarCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getLoopExpCS_ItVar()
	 * @model containment="true"
	 * @generated
	 */
	IteratorVarCS getItVar();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.LoopExpCS#getItVar <em>It Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>It Var</em>' containment reference.
	 * @see #getItVar()
	 * @generated
	 */
	void setItVar(IteratorVarCS value);

	/**
	 * Returns the value of the '<em><b>Logic Op</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logic Op</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logic Op</em>' attribute list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getLoopExpCS_LogicOp()
	 * @model
	 * @generated
	 */
	EList<String> getLogicOp();

	/**
	 * Returns the value of the '<em><b>Exp</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getLoopExpCS_Exp()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpCS> getExp();

} // LoopExpCS
