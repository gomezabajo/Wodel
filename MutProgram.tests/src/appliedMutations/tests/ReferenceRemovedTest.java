/**
 */
package appliedMutations.tests;

import appliedMutations.AppliedMutationsFactory;
import appliedMutations.ReferenceRemoved;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Reference Removed</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceRemovedTest extends AppMutationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReferenceRemovedTest.class);
	}

	/**
	 * Constructs a new Reference Removed test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRemovedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Reference Removed test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ReferenceRemoved getFixture() {
		return (ReferenceRemoved)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AppliedMutationsFactory.eINSTANCE.createReferenceRemoved());
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

} //ReferenceRemovedTest
