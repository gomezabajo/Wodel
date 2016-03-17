/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.CatStartStringType;
import mutatorenvironment.MutatorenvironmentFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Cat Start String Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CatStartStringTypeTest extends StringTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CatStartStringTypeTest.class);
	}

	/**
	 * Constructs a new Cat Start String Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatStartStringTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Cat Start String Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CatStartStringType getFixture() {
		return (CatStartStringType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createCatStartStringType());
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

} //CatStartStringTypeTest
