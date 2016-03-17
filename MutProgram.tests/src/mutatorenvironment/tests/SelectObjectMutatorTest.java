/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.SelectObjectMutator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Select Object Mutator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SelectObjectMutatorTest extends MutatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SelectObjectMutatorTest.class);
	}

	/**
	 * Constructs a new Select Object Mutator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectObjectMutatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Select Object Mutator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SelectObjectMutator getFixture() {
		return (SelectObjectMutator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createSelectObjectMutator());
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

} //SelectObjectMutatorTest
