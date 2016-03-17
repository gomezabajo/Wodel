/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.SpecificReferenceSelection;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specific Reference Selection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificReferenceSelectionTest extends SpecificSelectionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpecificReferenceSelectionTest.class);
	}

	/**
	 * Constructs a new Specific Reference Selection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificReferenceSelectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Specific Reference Selection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SpecificReferenceSelection getFixture() {
		return (SpecificReferenceSelection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createSpecificReferenceSelection());
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

} //SpecificReferenceSelectionTest
