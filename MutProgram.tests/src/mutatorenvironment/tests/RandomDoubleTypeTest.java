/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.RandomDoubleType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Double Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomDoubleTypeTest extends DoubleTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomDoubleTypeTest.class);
	}

	/**
	 * Constructs a new Random Double Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomDoubleTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Random Double Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RandomDoubleType getFixture() {
		return (RandomDoubleType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType());
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

} //RandomDoubleTypeTest
