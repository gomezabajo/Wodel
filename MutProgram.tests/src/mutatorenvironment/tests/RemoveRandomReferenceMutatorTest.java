/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.RemoveRandomReferenceMutator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Remove Random Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RemoveRandomReferenceMutatorTest extends RemoveReferenceMutatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RemoveRandomReferenceMutatorTest.class);
	}

	/**
	 * Constructs a new Remove Random Reference Mutator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveRandomReferenceMutatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Remove Random Reference Mutator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RemoveRandomReferenceMutator getFixture() {
		return (RemoveRandomReferenceMutator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createRemoveRandomReferenceMutator());
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

} //RemoveRandomReferenceMutatorTest
