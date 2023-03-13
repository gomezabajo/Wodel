/**
 */
package mutatormetrics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatormetrics.Object#getName <em>Name</em>}</li>
 *   <li>{@link mutatormetrics.Object#getCreated <em>Created</em>}</li>
 *   <li>{@link mutatormetrics.Object#getModified <em>Modified</em>}</li>
 *   <li>{@link mutatormetrics.Object#getRemoved <em>Removed</em>}</li>
 * </ul>
 *
 * @see mutatormetrics.MutatormetricsPackage#getObject()
 * @model abstract="true"
 * @generated
 */
public interface Object extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mutatormetrics.MutatormetricsPackage#getObject_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mutatormetrics.Object#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(int)
	 * @see mutatormetrics.MutatormetricsPackage#getObject_Created()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCreated();

	/**
	 * Sets the value of the '{@link mutatormetrics.Object#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(int value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' attribute.
	 * @see #setModified(int)
	 * @see mutatormetrics.MutatormetricsPackage#getObject_Modified()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getModified();

	/**
	 * Sets the value of the '{@link mutatormetrics.Object#getModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #getModified()
	 * @generated
	 */
	void setModified(int value);

	/**
	 * Returns the value of the '<em><b>Removed</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Removed</em>' attribute.
	 * @see #setRemoved(int)
	 * @see mutatormetrics.MutatormetricsPackage#getObject_Removed()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getRemoved();

	/**
	 * Sets the value of the '{@link mutatormetrics.Object#getRemoved <em>Removed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Removed</em>' attribute.
	 * @see #getRemoved()
	 * @generated
	 */
	void setRemoved(int value);

} // Object
