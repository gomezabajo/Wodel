/**
 */
package modelgraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelgraph.Information#getType <em>Type</em>}</li>
 *   <li>{@link modelgraph.Information#getAtt <em>Att</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelgraph.ModelgraphPackage#getInformation()
 * @model
 * @generated
 */
public interface Information extends Item {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EReference)
	 * @see modelgraph.ModelgraphPackage#getInformation_Type()
	 * @model required="true"
	 * @generated
	 */
	EReference getType();

	/**
	 * Sets the value of the '{@link modelgraph.Information#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EReference value);

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
	 * @see modelgraph.ModelgraphPackage#getInformation_Att()
	 * @model
	 * @generated
	 */
	EAttribute getAtt();

	/**
	 * Sets the value of the '{@link modelgraph.Information#getAtt <em>Att</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att</em>' reference.
	 * @see #getAtt()
	 * @generated
	 */
	void setAtt(EAttribute value);

} // Information
