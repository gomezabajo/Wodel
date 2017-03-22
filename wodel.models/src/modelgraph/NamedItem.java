/**
 */
package modelgraph;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelgraph.NamedItem#getAttName <em>Att Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelgraph.ModelgraphPackage#getNamedItem()
 * @model abstract="true"
 * @generated
 */
public interface NamedItem extends Item {
	/**
	 * Returns the value of the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att Name</em>' reference.
	 * @see #setAttName(EAttribute)
	 * @see modelgraph.ModelgraphPackage#getNamedItem_AttName()
	 * @model
	 * @generated
	 */
	EAttribute getAttName();

	/**
	 * Sets the value of the '{@link modelgraph.NamedItem#getAttName <em>Att Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att Name</em>' reference.
	 * @see #getAttName()
	 * @generated
	 */
	void setAttName(EAttribute value);

} // NamedItem
