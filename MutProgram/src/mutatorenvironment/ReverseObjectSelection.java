/**
 */
package mutatorenvironment;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reverse Object Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.ReverseObjectSelection#getObjSel <em>Obj Sel</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getReverseObjectSelection()
 * @model
 * @generated
 */
public interface ReverseObjectSelection extends ReverseSelection {

	/**
	 * Returns the value of the '<em><b>Obj Sel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj Sel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Sel</em>' reference.
	 * @see #setObjSel(ObjectEmitter)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getReverseObjectSelection_ObjSel()
	 * @model required="true"
	 * @generated
	 */
	ObjectEmitter getObjSel();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ReverseObjectSelection#getObjSel <em>Obj Sel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj Sel</em>' reference.
	 * @see #getObjSel()
	 * @generated
	 */
	void setObjSel(ObjectEmitter value);
} // ReverseObjectSelection
