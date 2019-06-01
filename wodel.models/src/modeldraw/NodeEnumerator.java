/**
 */
package modeldraw;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Enumerator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.NodeEnumerator#getAtt <em>Att</em>}</li>
 *   <li>{@link modeldraw.NodeEnumerator#getEnumerator <em>Enumerator</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getNodeEnumerator()
 * @model
 * @generated
 */
public interface NodeEnumerator extends Item {
	/**
	 * Returns the value of the '<em><b>Att</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att</em>' reference.
	 * @see #setAtt(EAttribute)
	 * @see modeldraw.ModeldrawPackage#getNodeEnumerator_Att()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAtt();

	/**
	 * Sets the value of the '{@link modeldraw.NodeEnumerator#getAtt <em>Att</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att</em>' reference.
	 * @see #getAtt()
	 * @generated
	 */
	void setAtt(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Enumerator</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.Enumerator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerator</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getNodeEnumerator_Enumerator()
	 * @model containment="true"
	 * @generated
	 */
	EList<Enumerator> getEnumerator();

} // NodeEnumerator
