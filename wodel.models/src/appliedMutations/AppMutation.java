/**
 */
package appliedMutations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>App Mutation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.AppMutation#getDef <em>Def</em>}</li>
 * </ul>
 *
 * @see appliedMutations.AppliedMutationsPackage#getAppMutation()
 * @model
 * @generated
 */
public interface AppMutation extends EObject {
	/**
	 * Returns the value of the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Def</em>' reference.
	 * @see #setDef(EObject)
	 * @see appliedMutations.AppliedMutationsPackage#getAppMutation_Def()
	 * @model required="true"
	 * @generated
	 */
	EObject getDef();

	/**
	 * Sets the value of the '{@link appliedMutations.AppMutation#getDef <em>Def</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Def</em>' reference.
	 * @see #getDef()
	 * @generated
	 */
	void setDef(EObject value);

} // AppMutation
