/**
 */
package modelgraph;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelgraph.Level#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelgraph.ModelgraphPackage#getLevel()
 * @model
 * @generated
 */
public interface Level extends Relation {
	/**
	 * Returns the value of the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' reference.
	 * @see #setUpper(EReference)
	 * @see modelgraph.ModelgraphPackage#getLevel_Upper()
	 * @model
	 * @generated
	 */
	EReference getUpper();

	/**
	 * Sets the value of the '{@link modelgraph.Level#getUpper <em>Upper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' reference.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(EReference value);

} // Level
