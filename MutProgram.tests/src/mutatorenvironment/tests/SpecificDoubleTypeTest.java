/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.SpecificDoubleType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specific Double Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificDoubleTypeTest extends DoubleTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpecificDoubleTypeTest.class);
	}

	/**
	 * Constructs a new Specific Double Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificDoubleTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Specific Double Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SpecificDoubleType getFixture() {
		return (SpecificDoubleType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType());
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

} //SpecificDoubleTypeTest
