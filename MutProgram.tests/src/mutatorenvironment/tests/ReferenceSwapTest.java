/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.ReferenceSwap;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Reference Swap</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceSwapTest extends ReferenceSetTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReferenceSwapTest.class);
	}

	/**
	 * Constructs a new Reference Swap test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceSwapTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Reference Swap test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ReferenceSwap getFixture() {
		return (ReferenceSwap)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createReferenceSwap());
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

} //ReferenceSwapTest
