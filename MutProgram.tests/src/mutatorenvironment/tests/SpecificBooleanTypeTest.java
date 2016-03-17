/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.SpecificBooleanType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specific Boolean Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificBooleanTypeTest extends BooleanTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpecificBooleanTypeTest.class);
	}

	/**
	 * Constructs a new Specific Boolean Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificBooleanTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Specific Boolean Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SpecificBooleanType getFixture() {
		return (SpecificBooleanType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType());
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

} //SpecificBooleanTypeTest
