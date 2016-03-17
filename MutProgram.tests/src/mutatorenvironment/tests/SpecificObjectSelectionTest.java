/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.SpecificObjectSelection;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specific Object Selection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificObjectSelectionTest extends SpecificSelectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpecificObjectSelectionTest.class);
	}

	/**
	 * Constructs a new Specific Object Selection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificObjectSelectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Specific Object Selection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SpecificObjectSelection getFixture() {
		return (SpecificObjectSelection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createSpecificObjectSelection());
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

} //SpecificObjectSelectionTest
