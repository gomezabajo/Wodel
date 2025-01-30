/**
 */
package modeltext;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identify Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeltext.IdentifyElements#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link modeltext.IdentifyElements#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @see modeltext.ModeltextPackage#getIdentifyElements()
 * @model
 * @generated
 */
public interface IdentifyElements extends EObject {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute.
	 * @see #setMetamodel(String)
	 * @see modeltext.ModeltextPackage#getIdentifyElements_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link modeltext.IdentifyElements#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link modeltext.MutatorInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see modeltext.ModeltextPackage#getIdentifyElements_Instances()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MutatorInstance> getInstances();

} // IdentifyElements
