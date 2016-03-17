/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.RemoveCompleteReferenceMutator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Remove Complete Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RemoveCompleteReferenceMutatorTest extends RemoveReferenceMutatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RemoveCompleteReferenceMutatorTest.class);
	}

	/**
	 * Constructs a new Remove Complete Reference Mutator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveCompleteReferenceMutatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Remove Complete Reference Mutator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RemoveCompleteReferenceMutator getFixture() {
		return (RemoveCompleteReferenceMutator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createRemoveCompleteReferenceMutator());
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

} //RemoveCompleteReferenceMutatorTest
