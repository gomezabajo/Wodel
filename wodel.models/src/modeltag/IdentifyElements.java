/**
 */
package modeltag;

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
 *   <li>{@link modeltag.IdentifyElements#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link modeltag.IdentifyElements#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see modeltag.ModeltagPackage#getIdentifyElements()
 * @model
 * @generated
 */
public interface IdentifyElements extends EObject {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute.
	 * @see #setMetamodel(String)
	 * @see modeltag.ModeltagPackage#getIdentifyElements_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link modeltag.IdentifyElements#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link modeltag.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see modeltag.ModeltagPackage#getIdentifyElements_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // IdentifyElements
