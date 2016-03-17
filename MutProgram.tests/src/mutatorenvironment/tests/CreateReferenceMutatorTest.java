/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.MutatorenvironmentFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Create Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CreateReferenceMutatorTest extends MutatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CreateReferenceMutatorTest.class);
	}

	/**
	 * Constructs a new Create Reference Mutator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateReferenceMutatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Create Reference Mutator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CreateReferenceMutator getFixture() {
		return (CreateReferenceMutator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createCreateReferenceMutator());
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

} //CreateReferenceMutatorTest
