/**
 */
package mutatortests;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatortests.Test#getSource <em>Source</em>}</li>
 *   <li>{@link mutatortests.Test#getQuestion <em>Question</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatortests.MutatortestsPackage#getTest()
 * @model
 * @generated
 */
public interface Test extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see mutatortests.MutatortestsPackage#getTest_Source()
	 * @model required="true"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link mutatortests.Test#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Question</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Question</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Question</em>' attribute.
	 * @see #setQuestion(String)
	 * @see mutatortests.MutatortestsPackage#getTest_Question()
	 * @model required="true"
	 * @generated
	 */
	String getQuestion();

	/**
	 * Sets the value of the '{@link mutatortests.Test#getQuestion <em>Question</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Question</em>' attribute.
	 * @see #getQuestion()
	 * @generated
	 */
	void setQuestion(String value);

} // Test
