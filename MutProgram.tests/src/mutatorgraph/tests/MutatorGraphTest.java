/**
 */
package mutatorgraph.tests;

import junit.textui.TestRunner;

import mutatorgraph.MutatorGraph;
import mutatorgraph.MutatorgraphFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mutator Graph</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MutatorGraphTest extends ItemTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MutatorGraphTest.class);
	}

	/**
	 * Constructs a new Mutator Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorGraphTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Mutator Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MutatorGraph getFixture() {
		return (MutatorGraph)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorgraphFactory.eINSTANCE.createMutatorGraph());
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

} //MutatorGraphTest
