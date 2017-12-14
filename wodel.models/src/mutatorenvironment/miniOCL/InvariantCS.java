/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.InvariantCS#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getInvariantCS()
 * @model
 * @generated
 */
public interface InvariantCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' containment reference.
	 * @see #setExp(ExpCS)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getInvariantCS_Exp()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getExp();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.InvariantCS#getExp <em>Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' containment reference.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(ExpCS value);

} // InvariantCS
