/**
 */
package modeltext;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeltext.MutatorInstance#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see modeltext.ModeltextPackage#getMutatorInstance()
 * @model
 * @generated
 */
public interface MutatorInstance extends Item {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link modeltext.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see modeltext.ModeltextPackage#getMutatorInstance_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // MutatorInstance
