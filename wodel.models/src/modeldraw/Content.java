/**
 */
package modeldraw;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.Content#getNodenum <em>Nodenum</em>}</li>
 *   <li>{@link modeldraw.Content#getInfo <em>Info</em>}</li>
 *   <li>{@link modeldraw.Content#getSymbol <em>Symbol</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getContent()
 * @model
 * @generated
 */
public interface Content extends NamedItem {
	/**
	 * Returns the value of the '<em><b>Nodenum</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.NodeEnumerator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodenum</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodenum</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getContent_Nodenum()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeEnumerator> getNodenum();

	/**
	 * Returns the value of the '<em><b>Info</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.Information}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Info</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Info</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getContent_Info()
	 * @model containment="true"
	 * @generated
	 */
	EList<Information> getInfo();

	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see #setSymbol(String)
	 * @see modeldraw.ModeldrawPackage#getContent_Symbol()
	 * @model
	 * @generated
	 */
	String getSymbol();

	/**
	 * Sets the value of the '{@link modeldraw.Content#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(String value);

} // Content
