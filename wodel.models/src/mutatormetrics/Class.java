/**
 */
package mutatormetrics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatormetrics.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatormetrics.Class#getReferences <em>References</em>}</li>
 *   <li>{@link mutatormetrics.Class#getCcreated <em>Ccreated</em>}</li>
 *   <li>{@link mutatormetrics.Class#getCmodified <em>Cmodified</em>}</li>
 *   <li>{@link mutatormetrics.Class#getCremoved <em>Cremoved</em>}</li>
 * </ul>
 *
 * @see mutatormetrics.MutatormetricsPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends mutatormetrics.Object {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatormetrics.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see mutatormetrics.MutatormetricsPackage#getClass_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link mutatormetrics.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see mutatormetrics.MutatormetricsPackage#getClass_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reference> getReferences();

	/**
	 * Returns the value of the '<em><b>Ccreated</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ccreated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ccreated</em>' attribute.
	 * @see #setCcreated(int)
	 * @see mutatormetrics.MutatormetricsPackage#getClass_Ccreated()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCcreated();

	/**
	 * Sets the value of the '{@link mutatormetrics.Class#getCcreated <em>Ccreated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ccreated</em>' attribute.
	 * @see #getCcreated()
	 * @generated
	 */
	void setCcreated(int value);

	/**
	 * Returns the value of the '<em><b>Cmodified</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cmodified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cmodified</em>' attribute.
	 * @see #setCmodified(int)
	 * @see mutatormetrics.MutatormetricsPackage#getClass_Cmodified()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCmodified();

	/**
	 * Sets the value of the '{@link mutatormetrics.Class#getCmodified <em>Cmodified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cmodified</em>' attribute.
	 * @see #getCmodified()
	 * @generated
	 */
	void setCmodified(int value);

	/**
	 * Returns the value of the '<em><b>Cremoved</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cremoved</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cremoved</em>' attribute.
	 * @see #setCremoved(int)
	 * @see mutatormetrics.MutatormetricsPackage#getClass_Cremoved()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCremoved();

	/**
	 * Sets the value of the '{@link mutatormetrics.Class#getCremoved <em>Cremoved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cremoved</em>' attribute.
	 * @see #getCremoved()
	 * @generated
	 */
	void setCremoved(int value);

} // Class
