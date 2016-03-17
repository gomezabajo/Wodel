/**
 */
package appliedMutations.tests;

import appliedMutations.AppliedMutationsFactory;
import appliedMutations.ObjectRemoved;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Object Removed</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObjectRemovedTest extends AppMutationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ObjectRemovedTest.class);
	}

	/**
	 * Constructs a new Object Removed test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectRemovedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Object Removed test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ObjectRemoved getFixture() {
		return (ObjectRemoved)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AppliedMutationsFactory.eINSTANCE.createObjectRemoved());
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

} //ObjectRemovedTest
