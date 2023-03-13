/**
 */
package mutatorenvironment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Closure Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.SpecificClosureSelection#getObjSel <em>Obj Sel</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getSpecificClosureSelection()
 * @model
 * @generated
 */
public interface SpecificClosureSelection extends SpecificSelection {
	/**
	 * Returns the value of the '<em><b>Obj Sel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Sel</em>' reference.
	 * @see #setObjSel(ObjectEmitter)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getSpecificClosureSelection_ObjSel()
	 * @model required="true"
	 * @generated
	 */
	ObjectEmitter getObjSel();

	/**
	 * Sets the value of the '{@link mutatorenvironment.SpecificClosureSelection#getObjSel <em>Obj Sel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj Sel</em>' reference.
	 * @see #getObjSel()
	 * @generated
	 */
	void setObjSel(ObjectEmitter value);

} // SpecificClosureSelection
