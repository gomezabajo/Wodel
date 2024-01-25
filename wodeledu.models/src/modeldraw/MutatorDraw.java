/**
 */
package modeldraw;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Draw</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.MutatorDraw#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link modeldraw.MutatorDraw#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getMutatorDraw()
 * @model
 * @generated
 */
public interface MutatorDraw extends Item {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute.
	 * @see #setMetamodel(String)
	 * @see modeldraw.ModeldrawPackage#getMutatorDraw_Metamodel()
	 * @model
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link modeldraw.MutatorDraw#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.MutatorInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getMutatorDraw_Instances()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MutatorInstance> getInstances();

} // MutatorDraw
