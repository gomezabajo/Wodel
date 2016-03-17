/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.ReplaceStringType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Replace String Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReplaceStringTypeTest extends StringTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReplaceStringTypeTest.class);
	}

	/**
	 * Constructs a new Replace String Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplaceStringTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Replace String Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ReplaceStringType getFixture() {
		return (ReplaceStringType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createReplaceStringType());
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

} //ReplaceStringTypeTest
