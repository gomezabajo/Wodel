/**
 */
package edutest;

import mutatorenvironment.Block;

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
 *   <li>{@link edutest.MutatorTests#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link edutest.MutatorTests#getTests <em>Tests</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getMutatorTests()
 * @model abstract="true"
 * @generated
 */
public interface MutatorTests extends EObject {
	/**
	 * Returns the value of the '<em><b>Blocks</b></em>' reference list.
	 * The list contents are of type {@link mutatorenvironment.Block}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks</em>' reference list.
	 * @see edutest.EdutestPackage#getMutatorTests_Blocks()
	 * @model
	 * @generated
	 */
	EList<Block> getBlocks();

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
