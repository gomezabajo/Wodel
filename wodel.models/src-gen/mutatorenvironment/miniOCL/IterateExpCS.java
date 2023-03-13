/**
 */
package mutatorenvironment.miniOCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.IterateExpCS#getAccVar <em>Acc Var</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getIterateExpCS()
 * @model
 * @generated
 */
public interface IterateExpCS extends LoopExpCS {
	/**
	 * Returns the value of the '<em><b>Acc Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acc Var</em>' containment reference.
	 * @see #setAccVar(AccVarCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getIterateExpCS_AccVar()
	 * @model containment="true"
	 * @generated
	 */
	AccVarCS getAccVar();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.IterateExpCS#getAccVar <em>Acc Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acc Var</em>' containment reference.
	 * @see #getAccVar()
	 * @generated
	 */
	void setAccVar(AccVarCS value);

} // IterateExpCS
