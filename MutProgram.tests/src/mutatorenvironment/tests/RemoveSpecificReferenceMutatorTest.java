/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.RemoveSpecificReferenceMutator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Remove Specific Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RemoveSpecificReferenceMutatorTest extends RemoveReferenceMutatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RemoveSpecificReferenceMutatorTest.class);
	}

	/**
	 * Constructs a new Remove Specific Reference Mutator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveSpecificReferenceMutatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Remove Specific Reference Mutator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RemoveSpecificReferenceMutator getFixture() {
		return (RemoveSpecificReferenceMutator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createRemoveSpecificReferenceMutator());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //RemoveSpecificReferenceMutatorTest
