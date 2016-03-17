/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.RemoveObjectMutator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Remove Object Mutator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RemoveObjectMutatorTest extends MutatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RemoveObjectMutatorTest.class);
	}

	/**
	 * Constructs a new Remove Object Mutator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveObjectMutatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Remove Object Mutator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RemoveObjectMutator getFixture() {
		return (RemoveObjectMutator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator());
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

} //RemoveObjectMutatorTest
