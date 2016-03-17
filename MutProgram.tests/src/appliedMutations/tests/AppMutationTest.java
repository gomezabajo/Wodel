/**
 */
package appliedMutations.tests;

import appliedMutations.AppMutation;
import appliedMutations.AppliedMutationsFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>App Mutation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AppMutationTest extends TestCase {

	/**
	 * The fixture for this App Mutation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppMutation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AppMutationTest.class);
	}

	/**
	 * Constructs a new App Mutation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppMutationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this App Mutation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AppMutation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this App Mutation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppMutation getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AppliedMutationsFactory.eINSTANCE.createAppMutation());
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

} //AppMutationTest
