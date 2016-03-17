/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.SpecificIntegerType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specific Integer Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificIntegerTypeTest extends IntegerTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpecificIntegerTypeTest.class);
	}

	/**
	 * Constructs a new Specific Integer Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificIntegerTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Specific Integer Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SpecificIntegerType getFixture() {
		return (SpecificIntegerType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType());
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

} //SpecificIntegerTypeTest
