/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.MutatorenvironmentFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Complete Type Selection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompleteTypeSelectionTest extends CompleteSelectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CompleteTypeSelectionTest.class);
	}

	/**
	 * Constructs a new Complete Type Selection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteTypeSelectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Complete Type Selection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CompleteTypeSelection getFixture() {
		return (CompleteTypeSelection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection());
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

} //CompleteTypeSelectionTest
