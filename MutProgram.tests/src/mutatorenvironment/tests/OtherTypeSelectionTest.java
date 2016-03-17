/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.OtherTypeSelection;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Other Type Selection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OtherTypeSelectionTest extends OtherSelectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OtherTypeSelectionTest.class);
	}

	/**
	 * Constructs a new Other Type Selection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OtherTypeSelectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Other Type Selection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OtherTypeSelection getFixture() {
		return (OtherTypeSelection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createOtherTypeSelection());
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

} //OtherTypeSelectionTest
