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
 * </p>
 * <ul>
 *   <li>{@link edutest.MutatorTests#getMarkedBlocks <em>Marked Blocks</em>}</li>
 *   <li>{@link edutest.MutatorTests#getTests <em>Tests</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getMutatorTests()
 * @model abstract="true"
 * @generated
 */
public interface MutatorTests extends EObject {
	/**
	 * Returns the value of the '<em><b>Marked Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link edutest.MarkedBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marked Blocks</em>' containment reference list.
	 * @see edutest.EdutestPackage#getMutatorTests_MarkedBlocks()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<MarkedBlock> getMarkedBlocks();

	/**
	 * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
	 * The list contents are of type {@link edutest.Test}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' containment reference list.
	 * @see edutest.EdutestPackage#getMutatorTests_Tests()
	 * @model containment="true"
	 * @generated
	 */
	EList<Test> getTests();

} // MutatorTests
