/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.RandomBooleanType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Boolean Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomBooleanTypeTest extends BooleanTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomBooleanTypeTest.class);
	}

	/**
	 * Constructs a new Random Boolean Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomBooleanTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Random Boolean Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RandomBooleanType getFixture() {
		return (RandomBooleanType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType());
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

} //RandomBooleanTypeTest
