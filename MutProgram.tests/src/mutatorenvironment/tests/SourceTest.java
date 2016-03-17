/**
 */
package mutatorenvironment.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.Source;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceTest extends TestCase {

	/**
	 * The fixture for this Source test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Source fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SourceTest.class);
	}

	/**
	 * Constructs a new Source test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Source test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Source fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Source test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Source getFixture() {
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
		setFixture(MutatorenvironmentFactory.eINSTANCE.createSource());
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

} //SourceTest
