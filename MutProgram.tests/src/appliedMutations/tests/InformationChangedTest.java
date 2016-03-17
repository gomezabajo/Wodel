/**
 */
package appliedMutations.tests;

import appliedMutations.AppliedMutationsFactory;
import appliedMutations.InformationChanged;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Information Changed</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InformationChangedTest extends AppMutationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InformationChangedTest.class);
	}

	/**
	 * Constructs a new Information Changed test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationChangedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Information Changed test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InformationChanged getFixture() {
		return (InformationChanged)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AppliedMutationsFactory.eINSTANCE.createInformationChanged());
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

} //InformationChangedTest
