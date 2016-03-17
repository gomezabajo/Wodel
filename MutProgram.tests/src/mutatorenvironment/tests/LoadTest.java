/**
 */
package mutatorenvironment.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import mutatorenvironment.Load;
import mutatorenvironment.MutatorenvironmentFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Load</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadTest extends TestCase {

	/**
	 * The fixture for this Load test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Load fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LoadTest.class);
	}

	/**
	 * Constructs a new Load test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Load test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Load fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Load test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Load getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createLoad());
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

} //LoadTest
