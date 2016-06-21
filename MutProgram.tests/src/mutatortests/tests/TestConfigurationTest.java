/**
 */
package mutatortests.tests;

import junit.textui.TestRunner;
import mutatortests.MutatortestsFactory;
import mutatortests.TestConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Test Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestConfigurationTest extends ConfigurationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TestConfigurationTest.class);
	}

	/**
	 * Constructs a new Test Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Test Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TestConfiguration getFixture() {
		return (TestConfiguration)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatortestsFactory.eINSTANCE.createTestConfiguration());
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

} //TestConfigurationTest
