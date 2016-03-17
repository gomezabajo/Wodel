/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.RandomIntegerType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Integer Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomIntegerTypeTest extends IntegerTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomIntegerTypeTest.class);
	}

	/**
	 * Constructs a new Random Integer Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomIntegerTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Random Integer Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RandomIntegerType getFixture() {
		return (RandomIntegerType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType());
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

} //RandomIntegerTypeTest
