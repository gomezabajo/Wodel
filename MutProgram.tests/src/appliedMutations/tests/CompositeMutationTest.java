/**
 */
package appliedMutations.tests;

import appliedMutations.AppliedMutationsFactory;
import appliedMutations.CompositeMutation;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Composite Mutation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeMutationTest extends AppMutationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CompositeMutationTest.class);
	}

	/**
	 * Constructs a new Composite Mutation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeMutationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Composite Mutation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CompositeMutation getFixture() {
		return (CompositeMutation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AppliedMutationsFactory.eINSTANCE.createCompositeMutation());
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

} //CompositeMutationTest
