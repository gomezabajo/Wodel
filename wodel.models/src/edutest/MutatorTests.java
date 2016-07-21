/**
 */
package edutest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Tests</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edutest.MutatorTests#getBlock <em>Block</em>}</li>
 *   <li>{@link edutest.MutatorTests#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see edutest.EdutestPackage#getMutatorTests()
 * @model abstract="true"
 * @generated
 */
public interface MutatorTests extends EObject {
	/**
	 * Returns the value of the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' reference.
	 * @see #setBlock(EObject)
	 * @see edutest.EdutestPackage#getMutatorTests_Block()
	 * @model
	 * @generated
	 */
	EObject getBlock();

	/**
	 * Sets the value of the '{@link edutest.MutatorTests#getBlock <em>Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(EObject value);

	/**
	 * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
	 * The list contents are of type {@link edutest.Test}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' containment reference list.
	 * @see edutest.EdutestPackage#getMutatorTests_Tests()
	 * @model containment="true"
	 * @generated
	 */
	EList<Test> getTests();

} // MutatorTests
