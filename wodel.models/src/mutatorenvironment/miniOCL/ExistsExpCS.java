/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exists Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.ExistsExpCS#getAccVars <em>Acc Vars</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getExistsExpCS()
 * @model
 * @generated
 */
public interface ExistsExpCS extends LoopExpCS {
	/**
	 * Returns the value of the '<em><b>Acc Vars</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.AccVarCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acc Vars</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getExistsExpCS_AccVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<AccVarCS> getAccVars();

} // ExistsExpCS
